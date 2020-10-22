package com.example.entity;

import com.example.testEntity.Login;

public class LoginEntity {
    private int userId;
    private String userName;
    private String userPassword;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoginEntity login = (LoginEntity) o;

        if (userId != login.userId) return false;
        if (userName != null ? !userName.equals(login.userName) : login.userName != null) return false;
        if (userPassword != null ? !userPassword.equals(login.userPassword) : login.userPassword != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        return result;
    }
}
