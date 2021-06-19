package ru.geekbrains.Lesson2.TaskForLesson.Repository;

import ru.geekbrains.Lesson2.TaskForLesson.Product;

public interface ProductRepository {
    void createdProduct(Product product);

    void readProduct(int id);

    void updateProduct(Product product);

    void deletedProduct(int id);

}
