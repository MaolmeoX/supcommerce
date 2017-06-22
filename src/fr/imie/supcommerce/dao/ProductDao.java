package fr.imie.supcommerce.dao;

import java.util.ArrayList;
import java.util.List;

import fr.imie.supcommerce.entity.Product;

public class ProductDao {

	private static ArrayList<Product> products = new ArrayList<>();
	
	public static List<Product> getAllProducts() {
		return products;
	}

	public static boolean addProduct(Product p) {
		p.setId(new Long(products.size()));
		products.add(p);
		return true;
	}

	public static Product findProduct(Long id) {
		for (Product p : products) {
			if (p.getId().equals(id)) {
				return p;
			}
		}
		return null;
	}

	public static void removeProduct(Long id) {
		products.remove(findProduct(id));
	}

	
	
}
