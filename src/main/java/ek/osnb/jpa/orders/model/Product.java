package ek.osnb.jpa.orders.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double price;

    public Long getId() {
        return id;
    }

    //TODO doesn't work, make DTO
    @JsonBackReference
    @ManyToMany
    private Set<Category> categories = new HashSet<>();

    public Set<Category> getCategories() {
        return categories;
    }

    public void addCategory(Category category) {
        if (category == null) return;
        if (this.categories.add(category)) {
            category.addProduct(this);
        }
    }

    public void removeCategory(Category category) {
        if (category == null) return;
        if (this.categories.remove(category)) {
            category.removeProduct(this);
        }
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
