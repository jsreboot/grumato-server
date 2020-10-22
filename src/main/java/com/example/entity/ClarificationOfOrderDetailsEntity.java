package com.example.entity;


import javax.persistence.Entity;
import javax.persistence.Table;

public class ClarificationOfOrderDetailsEntity {
    private int customerCustomerCode;
    private int ordersOrderCode;
    private String clarification;

    public int getCustomerCustomerCode() {
        return customerCustomerCode;
    }

    public void setCustomerCustomerCode(int customerCustomerCode) {
        this.customerCustomerCode = customerCustomerCode;
    }

    public int getOrdersOrderCode() {
        return ordersOrderCode;
    }

    public void setOrdersOrderCode(int ordersOrderCode) {
        this.ordersOrderCode = ordersOrderCode;
    }

    public String getClarification() {
        return clarification;
    }

    public void setClarification(String clarification) {
        this.clarification = clarification;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClarificationOfOrderDetailsEntity that = (ClarificationOfOrderDetailsEntity) o;

        if (customerCustomerCode != that.customerCustomerCode) return false;
        if (ordersOrderCode != that.ordersOrderCode) return false;
        if (clarification != null ? !clarification.equals(that.clarification) : that.clarification != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerCustomerCode;
        result = 31 * result + ordersOrderCode;
        result = 31 * result + (clarification != null ? clarification.hashCode() : 0);
        return result;
    }
}
