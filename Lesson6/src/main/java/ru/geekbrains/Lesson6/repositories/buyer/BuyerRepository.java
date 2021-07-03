package ru.geekbrains.Lesson6.repositories.buyer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.Lesson6.model.Buyer;

import javax.persistence.EntityManagerFactory;

@Component
public class BuyerRepository implements buyerCRUDInterface {
    private SessionFactory buyerSessionFactory;

    @Autowired
    public BuyerRepository(EntityManagerFactory factory) {
        if (factory.unwrap(SessionFactory.class) == null) {
            throw new NullPointerException("factory is not a hibernate factory");
        }
        this.buyerSessionFactory = factory.unwrap(SessionFactory.class);
    }

    @Override
    public void createdProduct(Buyer buyer) {
        Session session = this.buyerSessionFactory.getCurrentSession();
        session.persist(buyer);
        session.getTransaction().commit();
    }

    @Override
    public void readProduct(int id) {
        Session session = this.buyerSessionFactory.getCurrentSession();
        Buyer buyer = session.load(Buyer.class, id);
        session.getTransaction().commit();
    }

    @Override
    public void updateProduct(Buyer buyer) {
        Session session = this.buyerSessionFactory.getCurrentSession();
        session.update(buyer);
        session.getTransaction().commit();
    }

    @Override
    public void deletedProduct(int id) {
        Session session = this.buyerSessionFactory.getCurrentSession();
        Buyer buyer = session.load(Buyer.class, id);
        if (buyer != null) {
            session.delete(buyer);
        }
    }
}
