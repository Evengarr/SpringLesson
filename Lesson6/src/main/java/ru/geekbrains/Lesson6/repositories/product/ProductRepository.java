package ru.geekbrains.Lesson6.repositories.product;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.Lesson6.model.Buyer;
import ru.geekbrains.Lesson6.model.Product;

import javax.persistence.EntityManagerFactory;

@Component
public class ProductRepository implements productCRUDInterface {
    private SessionFactory productSessionFactory;

    @Autowired
    public ProductRepository(EntityManagerFactory factory) {
        if (factory.unwrap(SessionFactory.class) == null) {
            throw new NullPointerException("factory is not a hibernate factory");
        }
        this.productSessionFactory = factory.unwrap(SessionFactory.class);
    }


    @Override
    public void createdProduct(Product product) {
        Session session = this.productSessionFactory.getCurrentSession();
        session.persist(product);
        session.getTransaction().commit();
    }

    @Override
    public void readProduct(int id) {
        Session session = this.productSessionFactory.getCurrentSession();
        Product product = session.load(Product.class, id);
        session.getTransaction().commit();
    }

    @Override
    public void updateProduct(Product product) {
        Session session = this.productSessionFactory.getCurrentSession();
        session.update(product);
        session.getTransaction().commit();
    }

    @Override
    public void deletedProduct(int id) {
        Session session = this.productSessionFactory.getCurrentSession();
        Buyer buyer = session.load(Buyer.class, id);
        if (buyer != null) {
            session.delete(buyer);
        }
    }
}
