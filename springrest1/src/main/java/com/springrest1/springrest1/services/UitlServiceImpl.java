package com.springrest1.springrest1.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.springrest1.springrest1.dao.ProductDao;
import com.springrest1.springrest1.entities.Product;

public class UitlServiceImpl implements UtilService{
	
	@Autowired
	private ProductDao productDao;

	public UitlServiceImpl() {
		super();
	}
	
	@Override
	public int calculateEmi(int product_id) {
		// TODO Auto-generated method stub
		Product product = productDao.findById(product_id).get();
		int pri = product.getAmount();
		int rate = product.getRateofInterest();
		int ten = product.getTenure();

		int emiCalculated = ((pri * rate * (1 + rate) * ten) / ((1 + rate) * (ten - 1))) / 100;

		return emiCalculated;
	}


}
