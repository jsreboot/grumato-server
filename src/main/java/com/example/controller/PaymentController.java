package com.example.controller;

import com.example.DAO.CustomerDao;
import com.example.DAO.impl.CustomerDaoImpl;
import com.example.payments.PaymentRequest;
import com.example.rest.BaseResponse;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:8080", allowCredentials = "true")
@RequestMapping("/payment")
public class PaymentController {

    private Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itcompany?useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false", "root", "mu52fe5N");
            System.out.println("Got our connection");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    private final String sharedKey = "SHARED_KEY";

    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";
    private static final int CODE_SUCCESS = 100;
    private static final int AUTH_FAILURE = 102;

    @GetMapping
    public BaseResponse showStatus() {

        CustomerDao customerDao = new CustomerDaoImpl();
        Map<String, String> stringStringMap = new HashMap<>();
        Set<String> strings = stringStringMap.keySet();
        String s = strings.stream().findAny().get();
        return new BaseResponse(s, stringStringMap.get("surname"));
    }

    @PostMapping("/pay")
    public BaseResponse pay(@RequestParam(defaultValue="SHARED_KEY") String key, @RequestBody PaymentRequest request) {

        final BaseResponse response;
        CustomerDao customerDao = new CustomerDaoImpl();
        String customers = null;
        if (sharedKey.equalsIgnoreCase(key)) {
            String userId = request.getUserId();
            String itemId = request.getItemId();
            String discount = request.getDiscount();
            // Process the request
            // ....
            // Return success response to the client.
            response = new BaseResponse(SUCCESS_STATUS, "");
        } else {
            response = new BaseResponse(ERROR_STATUS, "");
        }
        return response;
    }
}
