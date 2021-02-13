package com.example.controller;


import com.example.DAO.OrderDao;
import com.example.DAO.impl.OrderDaoImpl;
import com.example.payments.OrderRequest;
import com.example.rest.BaseResponse;
import com.example.testEntity.Orders;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080", allowCredentials = "true")
@RequestMapping("/orders")
public class OrderController {

    private final String sharedKey = "SHARED_KEY";

    @GetMapping
    public BaseResponse showStatus() throws IOException {
        OrderDao orderDao = new OrderDaoImpl();
        List<Orders> orders = orderDao.getOrders();
        ObjectMapper mapper1 = new ObjectMapper();
        String result = mapper1.writeValueAsString(orders);
        return new BaseResponse(result, "200");
    }

    @PostMapping("/add")
    public BaseResponse add(@RequestParam(defaultValue = "SHARED_KEY") String key, @RequestBody OrderRequest request) {
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
    public BaseResponse delete(@RequestParam(defaultValue = "ssss") String key, @RequestBody OrderRequest request) {
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
