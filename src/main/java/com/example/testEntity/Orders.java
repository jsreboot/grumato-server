package com.example.testEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Orders implements Serializable {

    @Id
    @Column(name = "order_code")
    private int orderCode;
    @Column(name = "order_description")
    private String orderDescription;
    @Column(name = "customer_code")
    private int customerCode;
    @Column(name = "date_of_receipt_of_order")
    private Date dateOfReceiptOfOrder;
    @Column(name = "order_execution_date")
    private Date orderExecutionDate;
    @Column(name = "product_code")
    private int productCode;
    @Column(name = "order_cost")
    private String orderCost;

    public int getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(int orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public int getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(int customerCode) {
        this.customerCode = customerCode;
    }

    public Date getDateOfReceiptOfOrder() {
        return dateOfReceiptOfOrder;
    }

    public void setDateOfReceiptOfOrder(Date dateOfReceiptOfOrder) {
        this.dateOfReceiptOfOrder = dateOfReceiptOfOrder;
    }

    public Date getOrderExecutionDate() {
        return orderExecutionDate;
    }

    public void setOrderExecutionDate(Date orderExecutionDate) {
        this.orderExecutionDate = orderExecutionDate;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public String getOrderCost() {
        return orderCost;
    }

    public void setOrderCost(String orderCost) {
        this.orderCost = orderCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orders orders = (Orders) o;

        if (orderCode != orders.orderCode) return false;
        if (customerCode != orders.customerCode) return false;
        if (productCode != orders.productCode) return false;
        if (orderDescription != null ? !orderDescription.equals(orders.orderDescription) : orders.orderDescription != null)
            return false;
        if (dateOfReceiptOfOrder != null ? !dateOfReceiptOfOrder.equals(orders.dateOfReceiptOfOrder) : orders.dateOfReceiptOfOrder != null)
            return false;
        if (orderExecutionDate != null ? !orderExecutionDate.equals(orders.orderExecutionDate) : orders.orderExecutionDate != null)
            return false;
        if (orderCost != null ? !orderCost.equals(orders.orderCost) : orders.orderCost != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderCode;
        result = 31 * result + (orderDescription != null ? orderDescription.hashCode() : 0);
        result = 31 * result + customerCode;
        result = 31 * result + (dateOfReceiptOfOrder != null ? dateOfReceiptOfOrder.hashCode() : 0);
        result = 31 * result + (orderExecutionDate != null ? orderExecutionDate.hashCode() : 0);
        result = 31 * result + productCode;
        result = 31 * result + (orderCost != null ? orderCost.hashCode() : 0);
        return result;
    }
}