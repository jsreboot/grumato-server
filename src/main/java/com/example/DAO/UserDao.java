package com.example.DAO;

import com.example.testEntity.Employees;

import java.sql.SQLException;

public interface UserDao {
    public String createUser(Employees employees) throws SQLException;
    public String deleteUser(Employees employees) throws SQLException;
}
