package com.example.controller;

import com.example.DAO.CustomerDao;
import com.example.DAO.OrderDao;
import com.example.DAO.UserDao;
import com.example.DAO.impl.CustomerDaoImpl;
import com.example.DAO.impl.OrderDaoImpl;
import com.example.DAO.impl.UserDaoImpl;
import com.example.rest.BaseResponse;
import com.example.testEntity.Customer;
import com.example.testEntity.DataEntity;
import com.example.testEntity.Employees;
import com.example.testEntity.Orders;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080", allowCredentials = "true")
@RequestMapping("/data")
public class DataController {

    @GetMapping
    public BaseResponse showData() throws IOException, SQLException {
        UserDao userDao = new UserDaoImpl();
        OrderDao orderDao = new OrderDaoImpl();
        CustomerDao customerDao = new CustomerDaoImpl();
        List<Employees> userData = userDao.getEmployees();
        List<Orders> orderData = orderDao.getOrders();
        List<Customer> customerData = customerDao.getCustomers();
        DataEntity data = new DataEntity(userData, orderData, customerData);
        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(data);
        return new BaseResponse(result, "200");
    }
}



