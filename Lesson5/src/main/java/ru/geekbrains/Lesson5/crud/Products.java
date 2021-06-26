package ru.geekbrains.Lesson5.crud;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "simple_products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "cost")
    private Double cost;

    @Override
    public String toString() {
        return String.format("Products [id = %d, title = %s, price = %f \n]", id, title, cost);
    }

    public Products(String title, Double cost){
        this.title = title;
        this.cost = cost;
    }
}
