package com.example.model;

import java.util.Date;

public class OrderModel {
    public int IdCode;
    public String Order;
    public String Customer;
    public Date Time;
    public Date TimeExecution;
    public int Code;
    public String Cost;

    //

    public int getIdCode() {
        return IdCode;
    }

    public void setIdCode(int idCode) {
        this.IdCode = idCode;
    }

    public String getOrder() {
        return Order;
    }

    public void setOrder(String order) {
        this.Order = order;
    }

    public String getCustomer() {
        return Customer;
    }

    public void setCustomer(String customer) {
        this.Customer = customer;
    }

    public Date getTime() {
        return Time;
    }

    public void setTime(Date time) {
        this.Time = time;
    }

    public Date getTimeExecution() {
        return TimeExecution;
    }

    public void setTimeExecution(Date timeExecution) {
        this.TimeExecution = timeExecution;
    }

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        this.Code = code;
    }

    public String getCost() {
        return Cost;
    }

    public void setCost(String cost) {
        this.Cost = cost;
    }
}
