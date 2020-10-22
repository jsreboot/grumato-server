package com.example.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    public Customer() {
    }

    @Id
    private Integer customerCode;
    @Column (name = "id")
    private Integer id;
    @Column (name = "surname")
    private String surname;
    @Column (name = "name")
    private String name;
    @Column(name = "patronymic")
    private String patronymic;
    @Column (name = "customercol")
    private String customercol;
    @Column (name = "company")
    private String company;
    @Column (name = "company_number")
    private String companyNumber;
    @Column (name = "customer_code")

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

        Customer that = (Customer) o;

        if (customerCode != that.customerCode) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (patronymic != null ? !patronymic.equals(that.patronymic) : that.patronymic != null) return false;
        if (customercol != null ? !customercol.equals(that.customercol) : that.customercol != null) return false;
        if (company != null ? !company.equals(that.company) : that.company != null) return false;
        if (companyNumber != null ? !companyNumber.equals(that.companyNumber) : that.companyNumber != null)
            return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

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
