package ru.geekbrains.Lesson3.Repository;

import org.springframework.stereotype.Component;
import ru.geekbrains.Lesson3.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class OperationProduct implements ProductRepository{
    private List<Product> productList;
    private Long maxId;

    @PostConstruct
    public void init() {
        this.productList = new ArrayList<>();
        productList.add(new Product(1L, "aaa", 13.5));
        productList.add(new Product(2L, "bbb", 11.1));
        productList.add(new Product(3L, "ccc", 10.0));
        this.maxId = Long.valueOf(productList.size());
    }

    @Override
    public Product createdProduct(Product product) {
        if (product.getId() == null){
            maxId++;
            product.setId(maxId);
            productList.add(product);
            return product;
        } else {
            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i).getId().equals(product.getId())){
                    productList.set(i, product);
                    return product;
                }
            }
        }
        throw new RuntimeException("-");
    }

    @Override
    public Product readProduct(Long id) {
        for (Product p : productList) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        throw new RuntimeException("Продукт не обнаружен");
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
    public void deletedProduct(Long id) {
        Product product = productList.get(Math.toIntExact(id));
        productList.remove(product);
    }

    public List<Product> findAll(){
        return Collections.unmodifiableList(productList);
    }
}
