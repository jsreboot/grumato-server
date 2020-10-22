package com.example.controller;

import com.example.DAO.UserDao;
import com.example.DAO.impl.UserDaoImpl;
import com.example.db.HibernateUtil;
import com.example.payments.UsersRequest;
import com.example.rest.BaseResponse;
import com.example.testEntity.Employees;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080", allowCredentials = "true")
@RequestMapping("/users")
public class UserController {

    private final String sharedKey = "SHARED_KEY";

    @GetMapping
    public BaseResponse showStatus() {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Employees> query = builder.createQuery(Employees.class);
        Root<Employees> root = query.from(Employees.class);
        query.select(root);
        Query<Employees> q = session.createQuery(query);
        List<Employees> list = q.getResultList();
        session.close();
        StringBuilder finalResult = new StringBuilder(" ");
        for (Employees leties : list) {
            finalResult.append(" ID: ").append(leties.getEmployeeCode()).append(" Surname: ").append(leties.getSurname()).append(" Name: ").append(leties.getName()).append(" Date: ")
                    .append(leties.getPatronymic()).append(" PhoneNumber: ").append(leties.getPhoneNumber()).append(" Direction: ").append(leties.getDirection());
        }
        return new BaseResponse(finalResult.toString(), "200");
    }

    @PostMapping("/add")
    public BaseResponse add(@RequestParam(defaultValue="SHARED_KEY") String key, @RequestBody UsersRequest request) {
        String status = "";
        String result = "";
        try {
            Employees employees = request.getEmployees();
            UserDao userDao = new UserDaoImpl();
            result = userDao.createUser(employees);
            status = "200";
        } catch (Exception e) {
            e.printStackTrace();
            status = "500";
        }
        return new BaseResponse(status, result);
    }


    @PostMapping("/delete")
    public BaseResponse delete(@RequestParam(defaultValue="ssss") String key, @RequestBody UsersRequest request) {
        String status = "";
        String result = "";
        try {
            Employees employees = request.getEmployees();
            UserDao userDao = new UserDaoImpl();
            result = userDao.deleteUser(employees);
            status = "200";
        } catch (Exception e) {
            e.printStackTrace();
            status = "500";
        }
        return new BaseResponse(status, result);
    }
}
