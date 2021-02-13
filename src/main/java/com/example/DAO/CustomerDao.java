package com.example.DAO;

import com.example.testEntity.Customer;

import java.util.List;

public interface CustomerDao {
    public List<Customer> getCustomers();

    public String createCustomer(Customer customer);

    public String deleteCustomer(Customer customer);
}
