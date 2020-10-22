package com.example.controller;

import com.example.DAO.CustomerDao;
import com.example.DAO.impl.CustomerDaoImpl;
import com.example.db.HibernateUtil;
import com.example.payments.CustomersRequest;
import com.example.rest.BaseResponse;
import com.example.testEntity.Customer;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080", allowCredentials = "true")
@RequestMapping("/customers")
public class CustomerController {

    private final String sharedKey = "SHARED_KEY";

    @GetMapping
    public BaseResponse showStatus() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Customer> query = builder.createQuery(Customer.class);
        Root<Customer> root = query.from(Customer.class);
        query.select(root);
        Query<Customer> q = session.createQuery(query);
        List<Customer> list = q.getResultList();
        session.close();
        StringBuilder finalResult = new StringBuilder(" ");
        for (Customer leties : list) {
            finalResult.append(leties.getName()).append(" ");
        }
        return new BaseResponse(finalResult.toString(), "200");
    }

    @PostMapping("/add")
    public BaseResponse pay(@RequestParam(defaultValue="SHARED_KEY") String key, @RequestBody CustomersRequest request) {
        String status = "";
        String result = "";
        try {
            Customer customer = request.getCustomer();
            CustomerDao customerDao = new CustomerDaoImpl();
            result = customerDao.createCustomer(customer);
            status = "200";
        } catch (Exception e) {
            e.printStackTrace();
            status = "500";
        }
        return new BaseResponse(status, result);
    }

    @PostMapping("/delete")
    public BaseResponse delete(@RequestParam(defaultValue="ssss") String key, @RequestBody CustomersRequest request) {
        String status = "";
        String result = "";
        try {
            Customer customer = request.getCustomer();
            CustomerDao customerDao = new CustomerDaoImpl();
            result = customerDao.deleteCustomer(customer);
            status = "200";
        } catch (Exception e) {
            e.printStackTrace();
            status = "500";
        }
        return new BaseResponse(status, result);
    }

}
