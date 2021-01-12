package com.example.DAO.impl;

import com.example.DAO.OrderDao;
import com.example.db.HibernateUtil;
import com.example.model.OrderModel;
import com.example.testEntity.Customer;
import com.example.testEntity.Orders;
import org.hibernate.Session;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class OrderDaoImpl implements OrderDao {

    @Override
    public String createOrder(List orders) throws ParseException {
        return connectToDb(orders, "create");
    }

    @Override
    public String deleteOrder(Orders orders) throws ParseException {
        return connectToDb(null, "delete");
    }

    private String connectToDb(List orderses, String methodName) throws ParseException {
        String result = "";
        Orders orders = new Orders();
        LinkedHashMap jsonOnjectKeys = (LinkedHashMap) orderses.get(0);
        orders.setOrderDescription(jsonOnjectKeys.get("orderDescription").toString());
        orders.setCustomerCode(Integer.parseInt(jsonOnjectKeys.get("customerCode").toString()));

//        orders.setDateOfReceiptOfOrder((java.util.Date) o.get("dateOfReceiptOfOrder"));
//        orders.setOrderExecutionDate((java.util.Date) o.get("orderExecutionDate"));

//        "dateOfReceiptOfOrder"
//        "orderExecutionDate"

//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String dateOf = jsonOnjectKeys.get("dateOfReceiptOfOrder").toString();
        String dateTo = jsonOnjectKeys.get("orderExecutionDate").toString();
        java.util.Date parse = dateFormat.parse(dateOf);
        Date orderExecutionDate = dateFormat.parse(dateTo);
        orders.setDateOfReceiptOfOrder(parse);
        orders.setOrderExecutionDate(orderExecutionDate);

//        DateFormat dateOfReceiptOfOrder = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", new Locale("ru", "RU"));
//        java.sql.Date dutyDay1 = (java.sql.Date) dateOfReceiptOfOrder.parse("date_of_receipt_of_order");
//        orders.setDateOfReceiptOfOrder((java.util.Date) o.get(dutyDay1));

//        SimpleDateFormat dateOfReceiptOfOrder = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", new Locale("ru", "RU"));
//        Date date1 = (Date) dateOfReceiptOfOrder.parse("dateOfReceiptOfOrder");
//        orders.setDateOfReceiptOfOrder((java.util.Date) o.get(date1));

        orders.setProductCode(Integer.parseInt(jsonOnjectKeys.get("productCode").toString()));
        orders.setOrderCost(jsonOnjectKeys.get("orderCost").toString());

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            if (methodName.equals("create") ) {
                session.save(orders);
            }
            if (methodName.equals("delete") ) {
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
