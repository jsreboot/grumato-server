package com.example.DAO.impl;

import com.example.DAO.CustomerDao;
import com.example.db.HibernateUtil;
import com.example.testEntity.Customer;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public List<Customer> getCustomers() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Customer> query = builder.createQuery(Customer.class);
        Root<Customer> root = query.from(Customer.class);
        query.select(root);
        Query<Customer> q = session.createQuery(query);
        List<Customer> resultList = q.getResultList();
        session.close();
        return resultList;
    }

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
            session.load(Customer.class, customer.getCustomerCode());
            session.remove(customer);
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
