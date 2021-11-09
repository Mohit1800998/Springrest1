package com.springrest1.springrest1;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springrest1.springrest1.dao.ProductDao;
import com.springrest1.springrest1.entities.Product;
import com.springrest1.springrest1.services.ProductService;
import com.springrest1.springrest1.services.ProductServiceImpl;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class Springrest1ApplicationTests {

	
	@Test
	void contextLoads() {
	}
	
	@Autowired
	private ProductDao repo;

	@Autowired
	private ProductServiceImpl productService;
	
	@BeforeEach
	void setUp() {
		this.productService = new ProductServiceImpl(this.repo);
	}

	@Autowired
	private ProductService productService1;
	@Autowired
	private ProductDao productDao;

	@Test
	void getProduct() {
		Product product = new Product(1, "Personal Loan", 233, 0, 0, false, "Mohit", "Yogesh");
		repo.save(product);
		Product actualResult = productService1.getProduct(1);
		Boolean result;
		if(actualResult != null) {
			result = true;
		}
		else {
			result = false;
		}
		assertThat(result).isTrue();
	}
	
	@Test
	void isProductExistById1() {
		
		Product actualResult = productService1.getProduct(1234);
		Boolean result;
		if(actualResult != null) {
			result = true;
		}
		else {
			result = false;
		}
		assertThat(result).isFalse();
	}
	

	@Test
	void isProductDeleted() {
		Product product = new Product(1, "Personal Loan", 233, 0, 0, false, "Mohit", "Yogesh");
		repo.save(product);
		productService.deleteProduct(1);

		Product actualResult = productService1.getProduct(1);
		Boolean result;
		if(actualResult != null) {
			result = true;
		}
		else {
			result = false;
		}
		assertThat(result).isFalse();

	}
	
	@Test
	void isProductDeleted1() {

		Product product = new Product(1, "Personal Loan", 233, 0, 0, false, "Mohit", "Yogesh");
		repo.save(product);
		Product actualResult = productService1.getProduct(1);
		
		Boolean result;
		if(actualResult != null) {
			result = true;
		}
		else {
			result = false;
		}
		assertThat(result).isTrue();

	}

	@Test
	void isEmiCalculated() {

		
		Product product = new Product(1, "Personal Loan", 233, 0, 0, false, "Mohit", "Yogesh");
		repo.save(product);
		
		int id = 1;
		int actualResult = productService.calculateEmi(id);
		int expectedResult = 0;

		assertThat(actualResult).isEqualTo(expectedResult);
	}

}
