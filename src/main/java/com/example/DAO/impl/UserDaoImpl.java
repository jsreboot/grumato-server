package com.example.DAO.impl;

import com.example.DAO.UserDao;
import com.example.db.HibernateUtil;
import com.example.testEntity.Employees;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public List<Employees> getEmployees() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Employees> query = builder.createQuery(Employees.class);
        Root<Employees> root = query.from(Employees.class);
        query.select(root);
        Query<Employees> q = session.createQuery(query);
        List<Employees> resultList = q.getResultList();
        session.close();
        return resultList;
    }

    @Override
    public String createUser(Employees employees) {
        return connectDB(employees, "create");
    }

    @Override
    public String deleteUser(Employees employees) {
        String result = "";
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.load(Employees.class, employees.getEmployeeCode());
        session.remove(employees);
        session.getTransaction().commit();
        session.close();
        result = "success";
        return result;
    }

    private String connectDB(Employees employees, String methodName) {
        String result = "";
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            if (methodName.equals("create")) {
                session.saveOrUpdate(employees);
            }
            if (methodName.equals("delete")) {
                session.delete(employees);
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
