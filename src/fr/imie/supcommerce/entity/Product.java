package fr.imie.supcommerce.entity;

import com.sun.istack.internal.Nullable;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * Created by MaolmeoX on 15/05/2017.
 */
@Entity
@Table(name = "product")
@XmlRootElement
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private float price;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @Nullable
    private Category category;

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
    @XmlTransient
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;

    }
}
