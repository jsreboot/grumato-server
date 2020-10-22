package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
@Entity
public class OrdersEntity {
    @Id
    private int orderCode;
    private String orderDescription;
    private int customerCode;
    private Date dateOfReceiptOfOrder;
    private Date orderExecutionDate;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdersEntity that = (OrdersEntity) o;

        if (orderCode != that.orderCode) return false;
        if (customerCode != that.customerCode) return false;
        if (orderDescription != null ? !orderDescription.equals(that.orderDescription) : that.orderDescription != null)
            return false;
        if (dateOfReceiptOfOrder != null ? !dateOfReceiptOfOrder.equals(that.dateOfReceiptOfOrder) : that.dateOfReceiptOfOrder != null)
            return false;
        if (orderExecutionDate != null ? !orderExecutionDate.equals(that.orderExecutionDate) : that.orderExecutionDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderCode;
        result = 31 * result + (orderDescription != null ? orderDescription.hashCode() : 0);
        result = 31 * result + customerCode;
        result = 31 * result + (dateOfReceiptOfOrder != null ? dateOfReceiptOfOrder.hashCode() : 0);
        result = 31 * result + (orderExecutionDate != null ? orderExecutionDate.hashCode() : 0);
        return result;
    }
}
