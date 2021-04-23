package com.example.testEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Customer implements Serializable {
    @Id
    @Column(name = "customer_code")
    private int customerCode;
    private String surname;
    private String name;
    private String patronymic;
    private String customercol;
    private String company;
    @Column(name = "company_number")
    private String companyNumber;
    private Integer id;

    public int getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(int customerCode) {
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

    public String getCustomercol() {
        return customercol;
    }

    public void setCustomercol(String customercol) {
        this.customercol = customercol;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompanyNumber() {
        return companyNumber;
    }

    public void setCompanyNumber(String companyNumber) {
        this.companyNumber = companyNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (customerCode != customer.customerCode) return false;
        if (surname != null ? !surname.equals(customer.surname) : customer.surname != null) return false;
        if (name != null ? !name.equals(customer.name) : customer.name != null) return false;
        if (patronymic != null ? !patronymic.equals(customer.patronymic) : customer.patronymic != null) return false;
        if (customercol != null ? !customercol.equals(customer.customercol) : customer.customercol != null)
            return false;
        if (company != null ? !company.equals(customer.company) : customer.company != null) return false;
        if (companyNumber != null ? !companyNumber.equals(customer.companyNumber) : customer.companyNumber != null)
            return false;
        if (id != null ? !id.equals(customer.id) : customer.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerCode;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
        result = 31 * result + (customercol != null ? customercol.hashCode() : 0);
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (companyNumber != null ? companyNumber.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }
}
