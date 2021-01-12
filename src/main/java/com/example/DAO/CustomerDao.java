package com.example.DAO;

import com.example.testEntity.Customer;

import java.util.List;

public interface CustomerDao {
    public String createCustomer(List customer);
    public String deleteCustomer(Customer customer);
}
