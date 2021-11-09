package com.springrest1.springrest1.services;

import java.util.*;

import com.springrest1.springrest1.entities.Product;


public interface ProductService {

	public List<Product> getProducts();
	
	public Product getProduct(int product_id);
	
	public void addProduct(Product product);
	
	public void updateProduct(Product product);
	
	public void deleteCourse(int product);
	
	public int getEmi(int product_id);
}
