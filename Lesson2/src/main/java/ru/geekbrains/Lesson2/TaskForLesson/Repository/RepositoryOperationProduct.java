package ru.geekbrains.Lesson2.TaskForLesson.Repository;

import ru.geekbrains.Lesson2.TaskForLesson.Product;
import java.util.List;

public class RepositoryOperationProduct implements ProductRepository {
    private List<Product> productList;

    @Override
    public void createdProduct(Product product) {
        productList.add(product);
    }

    @Override
    public void readProduct(int id) {
        for (Product p : productList) {
            if (p.getId() == id) {
                p.toString();
            }
        }
    }

    @Override
    public void updateProduct(Product product) {
        for (Product p : productList) {
            if (p.getId() == product.getId()) {
                productList.remove(p.getId());
                productList.add(product);
            }
        }
    }

    @Override
    public void deletedProduct(int id) {
        productList.remove(id);
    }
}
