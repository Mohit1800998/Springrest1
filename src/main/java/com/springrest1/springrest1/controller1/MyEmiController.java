package com.springrest1.springrest1.controller1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest1.springrest1.services.ProductService;
@RestController
public class MyEmiController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("emi/{product_id}")
	public ResponseEntity<HttpStatus> addProduct(@PathVariable String product_id) {
		try {
			this.productService.getEmi(Integer.parseInt(product_id));
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	
	}

}
