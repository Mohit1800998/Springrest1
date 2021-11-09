package com.springrest1.springrest1.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;
import javax.validation.constraints.NotNull;

import org.springframework.data.redis.core.RedisHash;

import java.sql.Date;
import java.time.LocalDate;
@RedisHash("Product")
@Entity
public class Product {
	
	@Id
	private int product_id;
	@NotNull(message = "Name cannot be null")
	private String name;
	
	private int amount;
    @Max(value = 100, message = "amount should not be greater than 100")
	private int Tenure;

	@Min(value = 2, message = "Rate of Interest should not be less than 18")
	private int rateofInterest;
	@AssertTrue
	private boolean isActive;
	private Date CreatedOn;
	private String CreatedBy;
	private Date UpdatedOn;
	private String UpdatedBy;
	
	
	public Product(int product_id, String name, int amount, int tenure, int rateofInterest, boolean isActive,
			String createdBy, String updatedBy) {
		super();
		this.product_id = product_id;
		this.name = name;
		this.amount = amount;
		Tenure = tenure;
		this.rateofInterest = rateofInterest;
		this.isActive = isActive;
		CreatedOn = Date.valueOf(LocalDate.now());
		CreatedBy = createdBy;
		UpdatedOn = Date.valueOf(LocalDate.now());
		UpdatedBy = updatedBy;
	}
	
	
	public Date getCreatedOn() {
		return CreatedOn;
	}
 

	public void setCreatedOn(Date createdOn) {
		CreatedOn = createdOn;
	}


	public Date getUpdatedOn() {
		return UpdatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		UpdatedOn = updatedOn;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getTenure() {
		return Tenure;
	}
	public void setTenure(int tenure) {
		Tenure = tenure;
	}
	public int getRateofInterest() {
		return rateofInterest;
	}
	public void setRateofInterest(int rateofInterest) {
		this.rateofInterest = rateofInterest;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getCreatedBy() {
		return CreatedBy;
	}
	public void setCreatedBy(String createdBy) {
		CreatedBy = createdBy;
	}
	public String getUpdatedBy() {
		return UpdatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		UpdatedBy = updatedBy;
	}
	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", name=" + name + ", amount=" + amount + ", Tenure=" + Tenure
				+ ", rateofInterest=" + rateofInterest + ", isActive=" + isActive + ", CreatedBy=" + CreatedBy
				+ ", UpdatedBy=" + UpdatedBy + "]";
	}
	
	

}
