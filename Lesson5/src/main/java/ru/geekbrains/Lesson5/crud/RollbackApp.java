/*
package ru.geekbrains.Lesson5.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RollbackApp {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("configs/crud/hibernate.cfg.xml").buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            Products newProducts = new Products("www", 66.69);
            System.out.println("Before save: " + newProducts);
            session.save(newProducts);
            System.out.println("After save: " + newProducts);
            session.getTransaction().rollback();
            System.out.println("After rollback: " + newProducts);

            session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println(session.get(Products.class, newProducts.getId()));
            session.beginTransaction().commit();
        } finally {
            factory.close();
            if (session != null){
                session.close();
            }
        }
    }
}
*/
