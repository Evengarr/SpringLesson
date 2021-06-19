package ru.geekbrains.Lesson2.TaskForLesson;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.geekbrains.Lesson2.TaskForLesson.Service.ProductOperationService;


public class MainProducts {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProductsConfig.class);

        ProductOperationService productOperationService = context.getBean("operation", ProductOperationService.class);
        System.out.println(productOperationService.mediumCostProduct());
        productOperationService.addProduct(new Product(4, "ddd", 16.9));
        System.out.println(productOperationService.mediumCostProduct());

        context.close();
    }
}
