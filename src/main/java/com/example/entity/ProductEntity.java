package com.example.entity;


import javax.persistence.Table;

@Table(name = "product")
public class ProductEntity {
    private int productCode;
    private String productName;
    private String productDirection;

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDirection() {
        return productDirection;
    }

    public void setProductDirection(String productDirection) {
        this.productDirection = productDirection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductEntity that = (ProductEntity) o;

        if (productCode != that.productCode) return false;
        if (productName != null ? !productName.equals(that.productName) : that.productName != null) return false;
        if (productDirection != null ? !productDirection.equals(that.productDirection) : that.productDirection != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productCode;
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (productDirection != null ? productDirection.hashCode() : 0);
        return result;
    }
}
