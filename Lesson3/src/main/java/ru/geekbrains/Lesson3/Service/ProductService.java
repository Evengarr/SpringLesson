package ru.geekbrains.Lesson3.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.Lesson3.Product;
import ru.geekbrains.Lesson3.Repository.OperationProduct;

import java.util.List;

@Component
public class ProductService {
    List<Product> productList;
    int counting;
    double mediumCost;
    private OperationProduct operationProduct;

    @Autowired
    public void setOperationProduct(OperationProduct operationProduct){
        this.operationProduct = operationProduct;
    }

    public void addProduct(Product product) {
        operationProduct.createdProduct(product);
    }

    public Object readProduct(Long id) {operationProduct.readProduct(id);
        return operationProduct.readProduct(id);
    }

    public void updateProduct(Product product) {operationProduct.updateProduct(product);
    }

    public void deletedProduct(Long id) {
        operationProduct.deletedProduct(id);
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

    public List<Product> getAllProducts(){
        return operationProduct.findAll();
    }

}
