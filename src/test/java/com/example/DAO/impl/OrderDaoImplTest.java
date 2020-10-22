package com.example.DAO.impl;


import com.example.testEntity.Orders;
import org.hibernate.criterion.Order;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.JUnit38ClassRunner;
import org.junit.runner.RunWith;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(JUnit38ClassRunner.class)
public class OrderDaoImplTest {


    @Before
    public void createTestData () {

    }

    @Test
    public void createOrder() {

    }

    @Test
    public void deleteOrder() {

    }

    private Orders createTestOrder() {
        Orders orders = new Orders();
        orders.setOrderCost("11");
        orders.setProductCode(11);
        orders.setOrderExecutionDate(new Date());
        orders.setDateOfReceiptOfOrder(new Date());
        orders.setCustomerCode(11);
        orders.setOrderDescription("11");
        return orders;
    }
}
