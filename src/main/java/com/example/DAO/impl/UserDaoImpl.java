package com.example.DAO.impl;

import com.example.DAO.UserDao;
import com.example.db.HibernateUtil;
import com.example.testEntity.Employees;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class UserDaoImpl implements UserDao {



    @Override
    public String createUser(List employees) throws SQLException {
        return connectDB(employees, "create");
    }

    @Override
    public String deleteUser(Employees employees) throws SQLException {
        return connectDB(null, "delete");
    }

    private String connectDB(List employeeses, String methodName) {
        String result = "";
        Employees employees = new Employees();
        LinkedHashMap o = (LinkedHashMap) employeeses.get(0);
        employees.setSurname(o.get("surname").toString());
        employees.setName(o.get("name").toString());
        employees.setPatronymic(o.get("patronymic").toString());
        employees.setPhoneNumber(o.get("phoneNumber").toString());
        employees.setDirection(o.get("direction").toString());
//        employees.setRole(o.get("role").toString());

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            if (methodName.equals("create") ) {
                session.save(employees);
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
