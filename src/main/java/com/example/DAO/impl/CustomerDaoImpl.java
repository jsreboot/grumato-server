package com.example.DAO.impl;

import com.example.DAO.CustomerDao;
import com.example.db.HibernateUtil;
import com.example.testEntity.Customer;
import org.hibernate.Session;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public String createCustomer(Customer customer) {
        String result = "";
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.save(customer);
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
    public String deleteCustomer(Customer customer) {
        String result = "";
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.delete(customer);
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
