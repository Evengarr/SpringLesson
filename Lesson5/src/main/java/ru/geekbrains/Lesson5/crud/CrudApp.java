package ru.geekbrains.Lesson5.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.geekbrains.Lesson5.PrepareDataApp;

import java.util.List;


public class CrudApp {
    private static SessionFactory factory;

    public static void init() {
        PrepareDataApp.forcePrepareData();
        factory = new Configuration().configure("configs/crud/hibernate.cfg.xml").buildSessionFactory();
    }

    /*public static void showManyItems() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            List<Products> items = session.createQuery("from Products").getResultList();
            System.out.println(items + "\n");

            Products si1 = session.createQuery("select s from Products s where s.id = 3",
                    Products.class).getSingleResult();
            System.out.println(si1 + "\n");

            List<Products> cheapItems = session.createQuery("select s from Products s where s.cost < 80").getResultList();
            System.out.println(cheapItems + "\n");

            session.getTransaction().commit();
        }
    }*/

    public static void shutdown() {
        factory.close();
    }

    public static void createProduct() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Products xxx = new Products("xxx", 32.6);
            System.out.println(xxx);
            session.saveOrUpdate(xxx);
            System.out.println(xxx);
            session.getTransaction().commit();
            System.out.println(xxx);
        }
    }

    public static void readProduct() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Products products = session.get(Products.class, (long) (Math.random() * 10L));
            System.out.println(products);
            session.getTransaction().commit();
            System.out.println(products);
        }
    }

    public static void updateProduct() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Products products = session.get(Products.class, (long) (Math.random() * 10L));
            System.out.println(products);
            session.evict(products);
            products.setCost(100.00);
            System.out.println(products);
            session.getTransaction().commit();
            session.update(products);
            System.out.println(products);
        }
    }

    public static void deleteProduct() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Products products = session.get(Products.class, (long) (Math.random() * 10L));
            session.delete(products);
            session.getTransaction().commit();
        }
    }

    public static void main(String[] args) {
        try {
            init();
            switch ((int) (Math.random() * 4)) {
                case 0:
                    System.out.println("0");
                    createProduct();
                    break;
                case 1:
                    System.out.println("1");
                    readProduct();
                    break;
                case 2:
                    System.out.println("2");
                    updateProduct();
                    break;
                case 3:
                    System.out.println("3");
                    deleteProduct();
                    break;
                /*case 4:
                    System.out.println("4");
                    showManyItems();
                break;*/
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            shutdown();
        }
    }
}
