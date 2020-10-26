package com.example.DAO;

import com.example.testEntity.Login;

public interface LoginDao {
    public String createLogin(Login login);
    public String readLogin(Login login);
    public String deleteLogin(Login login);
}
