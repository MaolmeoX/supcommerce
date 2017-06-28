package fr.imie.supcommerce.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by MaolmeoX on 22/06/2017.
 */

@Entity
@Table(name = "category")
@XmlRootElement
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category") // fetch = FetchType.EAGER,
    private Collection<Product> products;

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }
}
