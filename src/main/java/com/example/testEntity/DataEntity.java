package com.example.testEntity;

import java.util.List;

public class DataEntity {
    private List<Employees> employees;
    private List<Orders> orders;
    private List<Customer> customer;

    public DataEntity(List<Employees> employees, List<Orders> orders, List<Customer> customer) {
        this.employees = employees;
        this.orders = orders;
        this.customer = customer;
    }

    public DataEntity(List<Employees> employees, List<Customer> customer) {
        this.employees = employees;
        this.customer = customer;
    }

    public List<Employees> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employees> employees) {
        this.employees = employees;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public List<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(List<Customer> customer) {
        this.customer = customer;
    }
}
