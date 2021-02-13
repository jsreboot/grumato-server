package com.example.DAO.impl;

import com.example.DAO.OrderDao;
import com.example.db.HibernateUtil;
import com.example.testEntity.Orders;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class OrderDaoImpl implements OrderDao {

    @Override
    public List<Orders> getOrders() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Orders> query = builder.createQuery(Orders.class);
        Root<Orders> root = query.from(Orders.class);
        query.select(root);
        Query<Orders> q = session.createQuery(query);
        List<Orders> resultList = q.getResultList();
        session.close();
        return resultList;
    }

    @Override
    public String createOrder(Orders orders) {
        return connectToDb(orders, "create");
    }

    @Override
    public String deleteOrder(Orders orders) {
        return connectToDb(orders, "delete");
    }

    private String connectToDb(Orders orders, String methodName) {
        String result = "";
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            if (methodName.equals("create")) {
                session.save(orders);
            }
            if (methodName.equals("delete")) {
                session.load(Orders.class, orders.getOrderCode());
                session.delete(orders);
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
