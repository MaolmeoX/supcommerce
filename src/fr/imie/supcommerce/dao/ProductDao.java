package fr.imie.supcommerce.dao;

import fr.imie.supcommerce.entity.Product;

import java.util.List;

/**
 * Created by MaolmeoX on 23/06/2017.
 */
public interface ProductDao {

    Product insert(Product p);

    Product update(Product p);

    void delete(Long id);

    Product findById(Long id);

    List<Product> findAll();
}
