package com.example.DAO.impl;

import com.example.DAO.OrderDao;
import com.example.db.HibernateUtil;
import com.example.model.OrderModel;
import com.example.testEntity.Customer;
import com.example.testEntity.Orders;
import org.hibernate.Session;

import java.sql.*;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

public class OrderDaoImpl implements OrderDao {

    @Override
    public String createOrder(Orders orders) {
        return connectToDb(orders, "create");
    }

    @Override
    public String deleteOrder(Orders orders) {
        return connectToDb(orders, "delete");
    }

    private String connectToDb(Orders orders, String methodName) {
        String result = "";
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            if (methodName.equals("create")) {
                session.saveOrUpdate(orders);
            }
            if (methodName.equals("delete")) {
                session.load(Orders.class, orders.getOrderCode());
                session.delete(orders);
            }
            session.getTransaction().commit();
            result = "success";
        } catch (Exception e) {
            System.out.println("error message: " + e);
            result = "abort " + e;
        } finally {
            session.close();
        }
        return result;
    }
}
