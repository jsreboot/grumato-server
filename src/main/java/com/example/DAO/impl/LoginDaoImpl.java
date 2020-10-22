package com.example.DAO.impl;

import com.example.DAO.LoginDao;
import com.example.db.HibernateUtil;
import com.example.testEntity.Login;
import org.hibernate.Session;

import java.sql.SQLException;

public class LoginDaoImpl implements LoginDao {
    @Override
    public String createLogin(Login login) {
        String result = "";
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.save(login);
            session.getTransaction().commit();
            result = "success";
        } catch (Exception e) {
            System.out.println("error message: " + e);
            result = "abort " + e;
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public String deleteLogin(Login login) {
        String result = "";
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.delete(login);
            session.getTransaction().commit();
            result = "success";
        } catch (Exception e) {
            System.out.println("error message: " + e);
            result = "abort " + e;
        } finally {
            session.close();
        }
        return result;
    }
}
