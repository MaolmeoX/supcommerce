package fr.imie.supcommerce.entity;

import fr.imie.supcommerce.dao.ProductDao;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by MaolmeoX on 15/05/2017.
 */
@Entity
@Table(name = "product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private float price;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    public Product() {
    }

    public Product(String name, String description, float price) {
        this.id = new Long(ProductDao.getAllProducts().size()) + 1;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Product(ArrayList<String> values) {
        this.id = new Long(ProductDao.getAllProducts().size()) + 1;
        this.name = values.get(0);
        this.description = values.get(1);
        this.price = Float.parseFloat(values.get(2));
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
