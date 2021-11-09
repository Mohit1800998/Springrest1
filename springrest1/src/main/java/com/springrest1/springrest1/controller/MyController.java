package com.springrest1.springrest1.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.springrest1.springrest1.entities.Product;
import com.springrest1.springrest1.services.ProductService;

@RestController
@RequestMapping("/product")
public class MyController {

	@Autowired
	private ProductService productService;

	// get the Products

	@GetMapping("/products")
	public List<Product> getProducts() {

		return this.productService.getProducts();
	}

	// Get a single product from database
	@GetMapping("/products/{product_id}")
	// @Cacheable(value = "Products", key = "#product_id")
	public ResponseEntity<?> getProduct(@PathVariable(value = "product_id") int product_id) {

		Product product = this.productService.getProduct(product_id);
		if (product != null) {
			return ResponseEntity.ok().body(product);
		} else {
			return ResponseEntity.ok().body("Product Not Found");
		}
	}

	// Adding product into database
	@PostMapping(path = "/Products")
	public String addProduct(Product product) {
		boolean check = this.productService.addProduct(product);
		if (check == true) {
			return "Product Successfully Added";
		} else {
			return "Product cannot be added please try again...";
		}

	}

	// Update the product
	@PutMapping("/update")
	public ResponseEntity<?> updateProduct(@RequestBody Product product) {

		boolean check = this.productService.updateProduct(product);
		if (check == true) {
			return ResponseEntity.ok().body("Product Successfully Updated");
		}
		return ResponseEntity.ok().body("Product cannot be added please try again...");

	}

	// delete the product
	@DeleteMapping("/Products/{product_id}")
	public String deleteCourse(@PathVariable String product_id) {

		boolean value = this.productService.deleteProduct(Integer.parseInt(product_id));
		if (value == true) {
			return "Product is Deleted";
		} else {
			return "Not Deleted";
		}

	}

	@GetMapping("/emi/{product_id}")
	public int emi(@PathVariable String product_id) {

		return this.productService.calculateEmi(Integer.parseInt(product_id));
	}

}
