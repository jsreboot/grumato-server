package com.example.controller;

import com.example.DAO.UserDao;
import com.example.DAO.impl.UserDaoImpl;
import com.example.payments.UsersRequest;
import com.example.rest.BaseResponse;
import com.example.testEntity.Employees;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080", allowCredentials = "true")
@RequestMapping("/users")
public class UserController {

    private final String sharedKey = "SHARED_KEY";

    @GetMapping
    public BaseResponse showStatus() throws IOException {
        UserDao userDao = new UserDaoImpl();
        List<Employees> employees = userDao.getEmployees();
        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(employees);
        return new BaseResponse(result, "200");
    }

    @PostMapping("/add")
    public BaseResponse add(@RequestParam(defaultValue = "SHARED_KEY") String key, @RequestBody UsersRequest request) {
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
    public BaseResponse delete(@RequestParam(defaultValue = "ssss") String key, @RequestBody UsersRequest request) {
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
