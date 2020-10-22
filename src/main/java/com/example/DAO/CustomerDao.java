package com.example.DAO;

import com.example.testEntity.Customer;

public interface CustomerDao {

    public String createCustomer(Customer customer);
    public String deleteCustomer(Customer customer);
}
