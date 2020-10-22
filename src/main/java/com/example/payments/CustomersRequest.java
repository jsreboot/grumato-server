package com.example.payments;

import com.example.testEntity.Customer;
import java.util.List;

public class CustomersRequest {
    private Customer customer;

    public List getCustomerEntry() {
        return customerEntry;
    }

    public void setCustomerEntry(List customerEntry) {
        this.customerEntry = customerEntry;
    }
    private List customerEntry;


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
