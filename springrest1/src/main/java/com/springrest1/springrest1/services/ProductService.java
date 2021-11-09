package com.springrest1.springrest1.services;

import java.util.*;

import com.springrest1.springrest1.entities.Product;


public interface ProductService {

	public List<Product> getProducts();
	
	public Product getProduct(int product_id);
	
	public Boolean addProduct(Product product);
	
	public Boolean updateProduct(Product product);
	
	public boolean deleteProduct(int product);
	
	public int calculateEmi(int product_id);
}
