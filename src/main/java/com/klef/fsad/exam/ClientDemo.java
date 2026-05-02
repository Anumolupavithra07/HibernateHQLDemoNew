package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Date;

public class ClientDemo 
{
    public static void main(String[] args) 
    {
        // Create SessionFactory
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        // INSERT
        Delivery d1 = new Delivery("Order1", new Date(), "Delivered", "Hyderabad", 500);
        Delivery d2 = new Delivery("Order2", new Date(), "Pending", "Delhi", 800);
        Delivery d3 = new Delivery("Order3", new Date(), "Shipped", "Mumbai", 1000);

        session.save(d1);
        session.save(d2);
        session.save(d3);

        System.out.println("Records Inserted");

        // DELETE using HQL
       String hql = "delete from Delivery where id=?1";
        Query q = session.createQuery(hql);
        q.setParameter(1, 1);

        int result = q.executeUpdate();

        System.out.println(result + " Record Deleted");

        tx.commit();

        session.close();
        sf.close();
    }
}