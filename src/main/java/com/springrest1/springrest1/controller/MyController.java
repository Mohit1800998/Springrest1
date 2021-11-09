package com.springrest1.springrest1.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
@RestController
@RequestMapping("/product")
public class MyController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ProductService productService;
	
	// get the Products
	
	@GetMapping("/Products")
	public List<Product> getProducts(){
		
		return this.productService.getProducts();
	}
	


	//Get a single product from database
	@GetMapping("/Products/{product_id}")
	//@Cacheable(value = "Products", key = "#product_id")
	public Product getProduct(@PathVariable("product_id") String product_id) {
		return this.productService.getProduct(Integer.parseInt(product_id));
		
		//Product emi = this.restTemplate.getForObject("http://localhost:8090/Products/"+product.getProduct_id(),Product.class);
		
		
	}
	
	
	//Adding product into database
	@PostMapping(path="/Products")
	public ResponseEntity<HttpStatus> addProduct(Product product) {
		try {
			this.productService.addProduct(product);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	
	}
	//Update the product
	@PutMapping("/Products")
	public ResponseEntity<HttpStatus> updateProduct(Product product) {
		
		try {
			this.productService.updateProduct(product);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// delete the product
	@DeleteMapping("/Products/{product_id}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String product_id){
		
		try {
			this.productService.deleteCourse(Integer.parseInt(product_id));
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/emi/{product_id}")
	public int emi(@PathVariable String product_id) {
		
//		int pri = Integer.valueOf(principal);
//		int rate = Integer.valueOf(rateofinterest);
//		int ten = Integer.valueOf(tenure);
//		 
//		int emiCalculated = (pri * rate * (1 + rate ) * ten) / ((1 + rate)*( ten - 1));
		return this.productService.getEmi(Integer.parseInt(product_id));
	}
	
}
