package fr.imie.supcommerce.rest;

import fr.imie.supcommerce.dao.DaoFactory;
import fr.imie.supcommerce.entity.Product;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.handler.MessageContext;
import java.util.List;

/**
 * Created by MaolmeoX on 28/06/2017.
 */
@Path("/products")
public class ProductResource {

    @GET
    @Path("/json/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getAllProductsInJson() {
        return DaoFactory.get_JPD().findAll();
    }

    @GET
    @Path("/xml/all")
    @Produces(MediaType.APPLICATION_XML)
    public List<Product> getAllProductsInXml() {
        return DaoFactory.get_JPD().findAll();
    }

    @GET
    @Path("/xml/{idProduct}")
    @Produces(MediaType.APPLICATION_XML)
    public Product getProductInXml(@PathParam("idProduct") Long id) {
        return DaoFactory.get_JPD().findById(id);
    }

    @GET
    @Path("/json/{idProduct}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProductInJson(@PathParam("idProduct") Long id) {
        return DaoFactory.get_JPD().findById(id);
    }

    @DELETE
    @Path("/delete/{idProduct}")
    public void deleteProduct(@PathParam("idProduct") Long id){
        DaoFactory.get_JPD().delete(id);
    }
}
