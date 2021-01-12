package com.example.DAO.impl;

import com.example.DAO.CustomerDao;
import com.example.db.HibernateUtil;
import com.example.testEntity.Customer;
import org.hibernate.Session;

import java.util.LinkedHashMap;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {

    @Override
    public String createCustomer (List customer){
        return connectDB(customer, "create");
    }
//    public String createCustomer(Customer customer) {
//        String result = "";
//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//        try {
//            session.beginTransaction();
//            session.save(customer);
//            session.getTransaction().commit();
//            result = "success";
//        } catch (Exception e) {
//            System.out.println("error message: " + e);
//            result = "abort " + e;
//        } finally {
//            session.close();
//        }
//        return result;
//    }

    @Override
    public String deleteCustomer(Customer customer) {
        return connectDB(null, "delete");
    }
//    public String deleteCustomer(Customer customer) {
//        String result = "";
//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//        try {
//            session.beginTransaction();
//            session.delete(customer);
//            session.getTransaction().commit();
//            result = "success";
//        } catch (Exception e) {
//            System.out.println("error message: " + e);
//            result = "abort " + e;
//        } finally {
//            session.close();
//        }
//        return result;
//    }

    private String connectDB (List customers, String methodName){
        String result = "";
        Customer customer = new Customer();
        LinkedHashMap o = (LinkedHashMap) customers.get(0);
        customer.setSurname(o.get("surname").toString());
        customer.setName(o.get("name").toString());
        customer.setPatronymic(o.get("patronymic").toString());
        customer.setCustomercol(o.get("customercol").toString());
        customer.setCompany(o.get("company").toString());
        customer.setCompanyNumber(o.get("companyNumber").toString());

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            if (methodName.equals("create") ) {
                session.save(customer);
            }
            if (methodName.equals("delete") ) {
                session.delete(customer);
            }
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
