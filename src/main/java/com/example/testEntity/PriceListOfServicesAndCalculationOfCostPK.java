package com.example.testEntity;

import java.io.Serializable;

public class PriceListOfServicesAndCalculationOfCostPK implements Serializable {
    private String costCalculationOrderCost;
    private String priceListOfServicesServiceCode;

    public String getCostCalculationOrderCost() {
        return costCalculationOrderCost;
    }

    public void setCostCalculationOrderCost(String costCalculationOrderCost) {
        this.costCalculationOrderCost = costCalculationOrderCost;
    }

    public String getPriceListOfServicesServiceCode() {
        return priceListOfServicesServiceCode;
    }

    public void setPriceListOfServicesServiceCode(String priceListOfServicesServiceCode) {
        this.priceListOfServicesServiceCode = priceListOfServicesServiceCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PriceListOfServicesAndCalculationOfCostPK that = (PriceListOfServicesAndCalculationOfCostPK) o;

        if (costCalculationOrderCost != null ? !costCalculationOrderCost.equals(that.costCalculationOrderCost) : that.costCalculationOrderCost != null)
            return false;
        if (priceListOfServicesServiceCode != null ? !priceListOfServicesServiceCode.equals(that.priceListOfServicesServiceCode) : that.priceListOfServicesServiceCode != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = costCalculationOrderCost != null ? costCalculationOrderCost.hashCode() : 0;
        result = 31 * result + (priceListOfServicesServiceCode != null ? priceListOfServicesServiceCode.hashCode() : 0);
        return result;
    }
}
