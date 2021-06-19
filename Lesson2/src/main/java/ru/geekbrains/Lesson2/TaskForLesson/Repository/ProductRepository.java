package ru.geekbrains.Lesson2.TaskForLesson.Repository;

import ru.geekbrains.Lesson2.TaskForLesson.Product;


public interface ProductRepository {

    public void createdProduct(Product product);

    public void readProduct(int id);

    public void updateProduct(Product product);

    public void deletedProduct(int id);

}
