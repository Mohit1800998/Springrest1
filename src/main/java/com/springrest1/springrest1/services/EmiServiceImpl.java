package com.springrest1.springrest1.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.springrest1.springrest1.dao.ProductDao;

public class EmiServiceImpl implements EmiService{
	
	@Autowired
	private ProductDao productDao;

	@Override
	public int getEmi(int product_id) {
		// TODO Auto-generated method stub
		int pri = Integer.valueOf(productDao.findById(product_id).get().getAmount());
		int rate = Integer.valueOf(productDao.findById(product_id).get().getRateofInterest());
		int ten = Integer.valueOf(productDao.findById(product_id).get().getTenure());
		
		int emiCalculated = (pri * rate * (1 + rate ) * ten) / ((1 + rate)*( ten - 1));
		
		return emiCalculated;
	}

}
