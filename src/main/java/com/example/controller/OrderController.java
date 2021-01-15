package com.example.controller;


import com.example.DAO.CustomerDao;
import com.example.DAO.OrderDao;
import com.example.DAO.impl.CustomerDaoImpl;
import com.example.DAO.impl.OrderDaoImpl;
import com.example.db.HibernateUtil;
import com.example.model.OrderModel;
import com.example.payments.OrderRequest;
import com.example.rest.BaseResponse;
import com.example.testEntity.Customer;
import com.example.testEntity.Orders;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:8080", allowCredentials = "true")
@RequestMapping("/orders")
public class OrderController {

    private final String sharedKey = "SHARED_KEY";

    @GetMapping
    public BaseResponse showStatus() throws IOException {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Orders> query = builder.createQuery(Orders.class);
        Root<Orders> root = query.from(Orders.class);
        query.select(root);
        Query<Orders> q = session.createQuery(query);
        List<Orders> list = q.getResultList();
        session.close();
        ObjectMapper mapper = new ObjectMapper();
        ObjectMapper mapper1 = new ObjectMapper();
        List<String> resultList = new ArrayList<>();
        for (Orders leties : list) {
            resultList.add(mapper.writeValueAsString(leties));
        }
        String result = mapper1.writeValueAsString(resultList);
        return new BaseResponse(result, "200");
    }

    @PostMapping("/add")
    public BaseResponse add(@RequestParam(defaultValue="SHARED_KEY") String key, @RequestBody OrderRequest request) {
        String status = "";
        String result = "";
        try {
            Orders orders = request.getOrder();
            OrderDao orderDao = new OrderDaoImpl();
            result = orderDao.createOrder(orders);
            status = "200";
        } catch (Exception e) {
            e.printStackTrace();
            status = "500";
        }
        return new BaseResponse(status, result);
    }

    @PostMapping("/delete")
    public BaseResponse delete(@RequestParam(defaultValue="ssss") String key, @RequestBody OrderRequest request) {
        String status = "";
        String result = "";
        try {
            Orders orders = request.getOrder();
            OrderDao orderDao = new OrderDaoImpl();
            result = orderDao.deleteOrder(orders);
            status = "200";
        } catch (Exception e) {
            e.printStackTrace();
            status = "500";
        }
        return new BaseResponse(status, result);
    }
}
