package com.example.testEntity;

import java.io.Serializable;

public class ClarificationOfOrderDetailsPK implements Serializable {
    private int customerCustomerCode;
    private int ordersOrderCode;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClarificationOfOrderDetailsPK that = (ClarificationOfOrderDetailsPK) o;

        if (customerCustomerCode != that.customerCustomerCode) return false;
        if (ordersOrderCode != that.ordersOrderCode) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerCustomerCode;
        result = 31 * result + ordersOrderCode;
        return result;
    }
}
