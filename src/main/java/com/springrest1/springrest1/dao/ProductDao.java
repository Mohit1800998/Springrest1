package com.springrest1.springrest1.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest1.springrest1.entities.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

	
}
