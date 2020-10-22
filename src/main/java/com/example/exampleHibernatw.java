package com.example;

import com.example.db.HibernateUtil;
import com.example.entity.Customer;
import org.hibernate.Session;

import java.util.List;

public class exampleHibernatw {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
       Customer customer = new Customer();
       customer.setCompany("companyHibernate");
       customer.setCompanyNumber("12312321321321");
       customer.setCustomerCode(54);
       customer.setCustomercol("45345435345435435");
       customer.setName("hibernateName");
       customer.setPatronymic("hibernatePatronimyc");
       customer.setSurname("hibernateSurname");
       session.save(customer);
       session.getTransaction().commit();
       session.close();
    }
}
