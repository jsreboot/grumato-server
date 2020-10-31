package com.example.DAO.impl;

import com.example.DAO.LoginDao;
import com.example.db.HibernateUtil;
import com.example.testEntity.Login;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import javax.transaction.Transactional;
import java.util.List;

public class LoginDaoImpl implements LoginDao {
    @Override
    public String createLogin(Login login) {
        String result = "";
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try {
            session.save(login);
            session.getTransaction().commit();
            session.close();
            result = "success";
        } catch (Exception e) {
            System.out.println("error message: " + e);
            result = "abort " + e;
        } finally {
            session.close();
        }
        return result;
    }

    @Transactional()
    @Override
    public String readLogin(Login login) {
        String result = "false";
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Login.class).add(Restrictions.and(Restrictions.eq("userName", login.getUserName()),
                    Restrictions.eq("userPassword", login.getUserPassword())));
            List<Login> list = criteria.list();
            return list.size() > 0 ? "true" : "false";
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
