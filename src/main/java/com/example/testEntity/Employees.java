package com.example.testEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Employees implements Serializable {

    @Id
    @Column(name = "employee_code")
    private int employeeCode;
    @Column(name = "surname")
    private String surname;
    @Column(name = "name")
    private String name;
    @Column(name = "patronymic")
    private String patronymic;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "direction")
    private String direction;
    @Column(name = "project")
    private String project;

    public int getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(int employeeCode) {
        this.employeeCode = employeeCode;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employees employees = (Employees) o;

        if (employeeCode != employees.employeeCode) return false;
        if (surname != null ? !surname.equals(employees.surname) : employees.surname != null) return false;
        if (name != null ? !name.equals(employees.name) : employees.name != null) return false;
        if (patronymic != null ? !patronymic.equals(employees.patronymic) : employees.patronymic != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(employees.phoneNumber) : employees.phoneNumber != null)
            return false;
        if (direction != null ? !direction.equals(employees.direction) : employees.direction != null) return false;
        if (project != null ? !project.equals(employees.project) : employees.project != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = employeeCode;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (direction != null ? direction.hashCode() : 0);
        result = 31 * result + (project != null ? project.hashCode() : 0);
        return result;
    }
}
