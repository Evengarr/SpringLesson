package ru.geekbrains.Lesson3.Repository;

import ru.geekbrains.Lesson3.Product;

public interface ProductRepository {
    Product createdProduct(Product product);

    Product readProduct(Long id);

    void updateProduct(Product product);

    void deletedProduct(Long id);
}
