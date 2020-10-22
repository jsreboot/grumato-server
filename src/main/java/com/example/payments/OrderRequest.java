package com.example.payments;

import com.example.testEntity.Orders;

import java.util.List;

public class OrderRequest {
    private Orders order;

    public List getOrderEntry() {
        return orderEntry;
    }

    public void setOrderEntry(List orderEntry) {
        this.orderEntry = orderEntry;
    }

    List orderEntry;

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

}
