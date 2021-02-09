package com.example.DAO.impl;

import com.example.DAO.UserDao;
import com.example.db.HibernateUtil;
import com.example.entity.EmployeesEntity;
import com.example.testEntity.Employees;
import org.hibernate.Session;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    @Override
    public String createUser(Employees employees) throws SQLException {
        return connectDB(employees, "create");
    }

    @Override
    public String deleteUser(Employees employees) throws SQLException {
        String result = "";
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.load(Employees.class, employees.getEmployeeCode());
//        Employees employees1 = session.get(Employees.class, employees.getEmployeeCode());
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
            if (methodName.equals("create") ) {
                session.saveOrUpdate(employees);
            }
            if (methodName.equals("delete") ) {
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
