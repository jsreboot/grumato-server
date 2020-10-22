package com.example.controller;

import com.example.DAO.LoginDao;
import com.example.DAO.impl.LoginDaoImpl;
import com.example.db.HibernateUtil;
import com.example.payments.LoginRequest;
import com.example.rest.BaseResponse;
import com.example.testEntity.Login;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080", allowCredentials = "true")
@RequestMapping("/login")
public class LoginController {


    @GetMapping
    public BaseResponse showStatus() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Login> query = builder.createQuery(Login.class);
        Root<Login> root = query.from(Login.class);
        query.select(root);
        Query<Login> q = session.createQuery(query);
        List<Login> list = q.getResultList();
        session.close();
        StringBuilder finalResult = new StringBuilder(" ");
        for (Login leties : list) {
            finalResult.append(" ID: ").append(leties.getUserId()).append(" Name: ").append(leties.getUserName()).append(" Password: ").append(leties.getUserPassword());
        }
        return new BaseResponse(finalResult.toString(), "200");
    }

    @PostMapping("/add")
    public BaseResponse add(@RequestParam(defaultValue="SHARED_KEY") String key, @RequestBody LoginRequest request) {
        String status = "";
        String result = "";
        try {
            Login login = request.getLogin();
            LoginDao loginDao = new LoginDaoImpl();
            result = loginDao.createLogin(login);
            status = "200";
        } catch (Exception e) {
            e.printStackTrace();
            status = "500";
        }
        return new BaseResponse(result, status);
    }


    @PostMapping("/delete")
    public BaseResponse delete(@RequestParam(defaultValue="ssss") String key, @RequestBody LoginRequest request) {
        String status = "";
        String result = "";
        try {
            Login login = request.getLogin();
            LoginDao loginDao = new LoginDaoImpl();
            result = loginDao.deleteLogin(login);
            status = "200";
        } catch (Exception e) {
            e.printStackTrace();
            status = "500";
        }
        return new BaseResponse(status, result);
    }
}
