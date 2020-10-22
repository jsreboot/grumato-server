package com.example.entity;


import javax.persistence.Table;

@Table(name = "cost_calculation")
public class CostCalculationEntity {
    private String orderCost;
    private String orderCode;
    private String serviceCode;
    private String totalCost;

    public String getOrderCost() {
        return orderCost;
    }

    public void setOrderCost(String orderCost) {
        this.orderCost = orderCost;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(String totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CostCalculationEntity that = (CostCalculationEntity) o;

        if (orderCost != null ? !orderCost.equals(that.orderCost) : that.orderCost != null) return false;
        if (orderCode != null ? !orderCode.equals(that.orderCode) : that.orderCode != null) return false;
        if (serviceCode != null ? !serviceCode.equals(that.serviceCode) : that.serviceCode != null) return false;
        if (totalCost != null ? !totalCost.equals(that.totalCost) : that.totalCost != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderCost != null ? orderCost.hashCode() : 0;
        result = 31 * result + (orderCode != null ? orderCode.hashCode() : 0);
        result = 31 * result + (serviceCode != null ? serviceCode.hashCode() : 0);
        result = 31 * result + (totalCost != null ? totalCost.hashCode() : 0);
        return result;
    }
}
