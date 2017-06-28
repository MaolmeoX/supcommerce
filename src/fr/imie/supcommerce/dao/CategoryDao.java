package fr.imie.supcommerce.dao;

import fr.imie.supcommerce.entity.Category;

import java.util.List;

/**
 * Created by MaolmeoX on 23/06/2017.
 */
public interface CategoryDao {

    Category insert(Category c);

    Category update(Category c);

    void delete(Integer id);

    Category findById(Integer id);

    List<Category> findAll();
}
