package com.example.DAO;

import com.example.testEntity.Employees;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    public String createUser(List employees) throws SQLException;
    public String deleteUser(Employees employees) throws SQLException;
}
