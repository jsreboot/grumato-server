package com.example.controller;

import com.example.DAO.CustomerDao;
import com.example.DAO.impl.CustomerDaoImpl;
import com.example.payments.CustomersRequest;
import com.example.rest.BaseResponse;
import com.example.testEntity.Customer;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080", allowCredentials = "true")
@RequestMapping("/customers")
public class CustomerController {

    private final String sharedKey = "SHARED_KEY";

    @GetMapping
    public BaseResponse showStatus() throws IOException {
        CustomerDao customerDao = new CustomerDaoImpl();
        List<Customer> customers = customerDao.getCustomers();
        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(customers);
        return new BaseResponse(result, "200");
    }

    @PostMapping("/add")
    public BaseResponse pay(@RequestParam(defaultValue = "SHARED_KEY") String key, @RequestBody CustomersRequest request) {
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
    public BaseResponse delete(@RequestParam(defaultValue = "ssss") String key, @RequestBody CustomersRequest request) {
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
