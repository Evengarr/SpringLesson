package ru.geekbrains.Lesson2.TaskForLesson.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.geekbrains.Lesson2.TaskForLesson.Product;
import ru.geekbrains.Lesson2.TaskForLesson.Repository.RepositoryOperationProduct;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
@Component(value = "operation")
public class ProductOperationService {
    List<Product> productList;
    int counting;
    double mediumCost;
    RepositoryOperationProduct repo = new RepositoryOperationProduct();

    @PostConstruct
    public void init() {
        productList = new ArrayList<>();
        productList.add(new Product(1, "aaa", 13.5));
        productList.add(new Product(2, "bbb", 11.1));
        productList.add(new Product(3, "ccc", 10.0));
    }

    @Autowired
    private ProductOperationService operationService;

    public void addProduct(Product product) {
        repo.createdProduct(product);
    }

    public void readProduct(int id) {
    }

    public void updateProduct(Product product) {
    }

    public void deletedProduct(int id) {
        repo.deletedProduct(id);
    }

    public double mediumCostProduct() {
        double sumCost = 0;
        for (Product p : productList) {
            sumCost += p.getCost();
            counting += 1;
        }
        mediumCost = sumCost / counting;
        return mediumCost;
    }
}
