package com.example.payments;


import com.example.model.UserModel;
import com.example.testEntity.Employees;

import java.util.List;

public class UsersRequest {
    private Employees employees;

    public List getUserEntry() {
        return userEntry;
    }

    public void setUserEntry(List userEntry) {
        this.userEntry = userEntry;
    }

    private List userEntry;

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }
}
