package com.example.DAO;

import com.example.testEntity.Orders;

import java.util.List;

public interface OrderDao {
    public List<Orders> getOrders();

    public String createOrder(Orders orders);

    public String deleteOrder(Orders orders);
}
