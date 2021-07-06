package ru.geekbrains.Lesson6.repositories.buyer;

import ru.geekbrains.Lesson6.model.Buyer;

public interface buyerCRUDInterface {
    void createdProduct(Buyer buyer);

    void readProduct(int id);

    void updateProduct(Buyer buyer);

    void deletedProduct(int id);
}
