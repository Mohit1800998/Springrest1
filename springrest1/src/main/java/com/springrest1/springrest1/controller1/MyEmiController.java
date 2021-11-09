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
	public int emi(@PathVariable String product_id) {
		
//		int pri = Integer.valueOf(principal);
//		int rate = Integer.valueOf(rateofinterest);
//		int ten = Integer.valueOf(tenure);
//		 
//		int emiCalculated = (pri * rate * (1 + rate ) * ten) / ((1 + rate)*( ten - 1));
		return this.productService.calculateEmi(Integer.parseInt(product_id));
	}
	

}
