package com.example.rest;

import com.example.testEntity.Employees;

public class BaseResponse {
    private final String status;
    private final String code;

    public BaseResponse(String status, String code) {
        this.status = status;
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }
}
