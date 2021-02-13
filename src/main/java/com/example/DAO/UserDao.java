package com.example.DAO;

import com.example.testEntity.Employees;

import java.util.List;

public interface UserDao {

    public List<Employees> getEmployees();

    public String createUser(Employees employees);

    public String deleteUser(Employees employees);
}
