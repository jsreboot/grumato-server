package com.example.testEntity;

public class EmployeeOrder {
    private int ordersOrderCode;
    private int employeesEmployeeCode;

    public int getOrdersOrderCode() {
        return ordersOrderCode;
    }

    public void setOrdersOrderCode(int ordersOrderCode) {
        this.ordersOrderCode = ordersOrderCode;
    }

    public int getEmployeesEmployeeCode() {
        return employeesEmployeeCode;
    }

    public void setEmployeesEmployeeCode(int employeesEmployeeCode) {
        this.employeesEmployeeCode = employeesEmployeeCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeOrder that = (EmployeeOrder) o;

        if (ordersOrderCode != that.ordersOrderCode) return false;
        if (employeesEmployeeCode != that.employeesEmployeeCode) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ordersOrderCode;
        result = 31 * result + employeesEmployeeCode;
        return result;
    }
}
