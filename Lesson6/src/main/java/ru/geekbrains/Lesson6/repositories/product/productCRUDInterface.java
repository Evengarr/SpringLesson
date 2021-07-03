package ru.geekbrains.Lesson6.repositories.product;

import ru.geekbrains.Lesson6.model.Product;

public interface productCRUDInterface {
    void createdProduct(Product product);

    void readProduct(int id);

    void updateProduct(Product product);

    void deletedProduct(int id);
}
