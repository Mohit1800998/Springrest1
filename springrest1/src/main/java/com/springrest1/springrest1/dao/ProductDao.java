package com.springrest1.springrest1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import com.springrest1.springrest1.entities.Product;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
public interface ProductDao extends JpaRepository<Product, Integer> {

	
}
