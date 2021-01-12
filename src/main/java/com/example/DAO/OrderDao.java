package com.example.DAO;

import com.example.model.OrderModel;
import com.example.model.UserModel;
import com.example.testEntity.Orders;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface OrderDao {
    public String createOrder(List orders) throws SQLException, ParseException;
    public String deleteOrder(Orders orders) throws SQLException, ParseException;
}
