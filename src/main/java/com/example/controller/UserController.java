package com.example.controller;

import com.example.DAO.UserDao;
import com.example.DAO.impl.UserDaoImpl;
import com.example.db.HibernateUtil;
import com.example.payments.UsersRequest;
import com.example.rest.BaseResponse;
import com.example.rest.UsersResponse;
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
    public UsersResponse showStatus() {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Employees> query = builder.createQuery(Employees.class);
        Root<Employees> root = query.from(Employees.class);
        query.select(root);
        Query<Employees> q = session.createQuery(query);
        List<Employees> list = q.getResultList();
        session.close();
        return new UsersResponse(list);
    }

    @PostMapping("/add")
    public BaseResponse add(@RequestParam(defaultValue="SHARED_KEY") String key, @RequestBody UsersRequest request) {
        String status = "";
        String result = "";
        try {
            UserDao userDao = new UserDaoImpl();
            result = "200";
            status = userDao.createUser(request.getUserEntry());
        } catch (Exception e) {
            result = "500";
            status = e.toString();
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
