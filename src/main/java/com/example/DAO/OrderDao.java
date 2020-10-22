package com.example.DAO;

import com.example.model.OrderModel;
import com.example.model.UserModel;
import com.example.testEntity.Orders;

import java.sql.SQLException;

public interface OrderDao {
    public String createOrder(Orders orders) throws SQLException;
    public String deleteOrder(Orders orders) throws SQLException;
}
