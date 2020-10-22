package com.example.entity;

public class PriceListOfServicesEntity {
    private String serviceCode;
    private String description;
    private String цена;

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getЦена() {
        return цена;
    }

    public void setЦена(String цена) {
        this.цена = цена;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PriceListOfServicesEntity that = (PriceListOfServicesEntity) o;

        if (serviceCode != null ? !serviceCode.equals(that.serviceCode) : that.serviceCode != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (цена != null ? !цена.equals(that.цена) : that.цена != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = serviceCode != null ? serviceCode.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (цена != null ? цена.hashCode() : 0);
        return result;
    }
}
