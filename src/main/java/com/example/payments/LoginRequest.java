package com.example.payments;

import com.example.testEntity.Login;

import java.util.List;

public class LoginRequest {
    private Login login;

    public List getLoginEntry() {
        return loginEntry;
    }

    public void setLoginEntry(List loginEntry) {
        this.loginEntry = loginEntry;
    }

    private List loginEntry;

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}
