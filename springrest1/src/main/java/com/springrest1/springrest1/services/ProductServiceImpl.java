package com.springrest1.springrest1.services;

import java.time.LocalDate;
import java.util.List;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springrest1.springrest1.exception.ResourceNotFoundException;
import com.springrest1.springrest1.dao.ProductDao;
import com.springrest1.springrest1.entities.Product;

@Service
public class ProductServiceImpl implements ProductService {

	// List<Product> list;
	@Autowired
	private ProductDao productDao;

	public ProductServiceImpl() {
		super();
//		list = new ArrayList<>();
//		list.add(new Product(5,"Personal Loan",50000,5,7,true,"Mohit","Mohit"));
//		list.add(new Product(6,"Business Loan",70000,8,3,false,"Mohit","Aman"));
//		list.add(new Product(7,"Personal Loan",53000,9,8,true,"Mohit","Yogesh"));
//		
//	

	}

	public ProductServiceImpl(ProductDao productDao) {

		this.productDao = productDao;
	}

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return productDao.findAll();
	}

	@Override
	public Product getProduct(int product_id) {
		// TODO Auto-generated method stub

		try {
			return productDao.findById(product_id)
					.orElseThrow(() -> new ResourceNotFoundException("Product not found"));
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Boolean addProduct(Product product) {
		// TODO Auto-generated method stub
//		list.add(product);
		boolean check = productDao.save(product) != null;
		if(check == false) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public Boolean updateProduct(Product product) {
		Product existingProduct = productDao.findById(product.getProduct_id()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setAmount(product.getAmount());
        existingProduct.setName(product.getName());
        existingProduct.setRateofInterest(product.getRateofInterest());
        existingProduct.setTenure(product.getTenure());;
        existingProduct.setUpdatedBy(product.getUpdatedBy());
        existingProduct.setUpdatedOn(product.getUpdatedOn());
       
		boolean check = productDao.save(existingProduct) != null;
		if(check == false) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public boolean deleteProduct(int product) {
		// TODO Auto-generated method stub
//		list = this.list.stream().filter(e->e.getProduct_id()!=product).collect(Collectors.toList());
		try {
			Product entity = productDao.findById(product)
					.orElseThrow(() -> new ResourceNotFoundException("Product Not Found"));
			productDao.delete(entity);
			return true;
		} catch (ResourceNotFoundException e) {
			System.out.println(e);
		}
		return false;
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
