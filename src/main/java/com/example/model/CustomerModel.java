package com.example.model;

public class CustomerModel {

    private int customerCode;
    private String surname;
    private String name;
    private String patronymic;
    private String CustomerCol;
    private String Company;
    private String CompanyNumber;
    private int id;

    public int getcustomerCode() {
        return customerCode;
    }

    public void setcustomerCode(int customerCode) {
        this.customerCode = customerCode;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getCustomerCol() {
        return CustomerCol;
    }

    public void setCustomerCol(String customerCol) {
        this.CustomerCol = customerCol;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        this.Company = company;
    }

    public String getCompanyNumber() {
        return CompanyNumber;
    }

    public void setCompanyNumber(String companyNumber) {
        this.CompanyNumber = companyNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
