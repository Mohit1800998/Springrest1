package com.springrest1.springrest1.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest1.springrest1.dao.ProductDao;
import com.springrest1.springrest1.entities.Product;

@Service
public class ProductServiceImpl implements ProductService {

	//List<Product> list;
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

	


	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return productDao.findAll();
	}




	@Override
	public Product getProduct(int product_id) {
		// TODO Auto-generated method stub
//		Product p = null;
//		for(Product pro : list) {
//			
//			if(pro.getProduct_id() == product) {
//				p = pro;
//			}
//		}
		return productDao.findById(product_id).orElse(null);
	}


	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
//		list.add(product);
		productDao.save(product);
	}




	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
//		list.forEach(e -> {
//			if(e.getProduct_id() == product.getProduct_id()) {
//				e.setName(product.getName());
//				e.setAmount(product.getAmount());
//				e.setTenure(product.getTenure());
//				e.setRateofInterest(product.getRateofInterest());
//				e.setCreatedBy(product.getCreatedBy());
//				e.setUpdatedBy(product.getUpdatedBy());
//				
//			}
//		});
		
		productDao.save(product);
	}

@Override
	public void deleteCourse(int product) {
		// TODO Auto-generated method stub
//		list = this.list.stream().filter(e->e.getProduct_id()!=product).collect(Collectors.toList());
		
		Product entity = productDao.findById(product).orElse(null);
		productDao.delete(entity);
	}




	@Override
	public int getEmi(int product_id) {
		// TODO Auto-generated method stub
		int pri = Integer.valueOf(productDao.findById(product_id).get().getAmount());
		int rate = Integer.valueOf(productDao.findById(product_id).get().getRateofInterest());
		int ten = Integer.valueOf(productDao.findById(product_id).get().getTenure());
		
		int emiCalculated = ((pri * rate * (1 + rate ) * ten) / ((1 + rate)*( ten - 1)))/100;
		
		return emiCalculated;
	}

}
