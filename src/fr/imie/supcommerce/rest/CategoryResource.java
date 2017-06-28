package fr.imie.supcommerce.rest;

import fr.imie.supcommerce.dao.DaoFactory;
import fr.imie.supcommerce.entity.Category;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by MaolmeoX on 28/06/2017.
 */
@Path("/category")
public class CategoryResource {

    @GET
    @Path("/json/{idCategory}")
    @Produces(MediaType.APPLICATION_JSON)
    public Category getCategoryInJson(@PathParam("idCategory") Integer id) {
        return DaoFactory.get_JCD().findById(id);
    }

    @GET
    @Path("/json/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Category> getAllCategoryInJson() {
        return DaoFactory.get_JCD().findAll();
    }

    @POST
    @Path("/json/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public String addJsonCategory(Category category){
        DaoFactory.get_JCD().insert(category);
        return category.toString();
    }

    @PUT
    @Path("/json/update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public String updateCategory(@PathParam("id") Integer id, Category category){

        Category categoryBdd = DaoFactory.get_JCD().findById(id);
        categoryBdd.setName(category.getName());
        DaoFactory.get_JCD().update(categoryBdd);
        return category.toString();
    }

}
