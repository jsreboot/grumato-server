package com.example.controller;

import com.example.DAO.CustomerDao;
import com.example.DAO.impl.CustomerDaoImpl;
import com.example.db.HibernateUtil;
import com.example.payments.CustomersRequest;
import com.example.rest.BaseResponse;
import com.example.testEntity.Customer;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080", allowCredentials = "true")
@RequestMapping("/customers")
public class CustomerController {

    private final String sharedKey = "SHARED_KEY";

    @GetMapping
    public BaseResponse showStatus() throws IOException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Customer> query = builder.createQuery(Customer.class);
        Root<Customer> root = query.from(Customer.class);
        query.select(root);
        Query<Customer> q = session.createQuery(query);
        ObjectMapper mapper = new ObjectMapper();
        ObjectMapper mapper1 = new ObjectMapper();
        List<Customer> answerDatabase = q.getResultList();
        List<String> jsonList = new ArrayList<>();
        String result = "";
        for (Customer customer : answerDatabase) {
            jsonList.add(mapper.writeValueAsString(customer));
        }
        result = mapper1.writeValueAsString(jsonList);
        session.close();
        return new BaseResponse(result, "200");
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
