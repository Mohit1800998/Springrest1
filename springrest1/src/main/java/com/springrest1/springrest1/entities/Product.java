package com.springrest1.springrest1.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;
import java.time.LocalDate;

@Entity
public class Product {
	
	@Id
	private int product_id;

	@JsonProperty("name")
	@Column(name="name",nullable=false)
	private String name;
	

	@JsonProperty("amount")
	@Min(1000)
	@Column(name="amount",nullable=false)
	private int amount;
	
    @Max(value = 100, message = "amount should not be greater than 100")
    @NotNull
	@JsonProperty("tenure")
	@Column(name="tenure",nullable=false)
	private int tenure;

	@Min(value = 2, message = "Rate of Interest should not be less than 18")
	@JsonProperty("rateofInterest")
	@Column(name="rateofInterest",nullable=false)
	private int rateofInterest;
	
	@AssertTrue
	@JsonProperty("isActive")
	@Column(name="isActive",nullable=false)
	private boolean isActive;

	@JsonProperty("createdOn")
	@Column(name="createdOn",nullable=false)
	private Date createdOn;
	

	@JsonProperty("createdBy")
	@Column(name="createdBy",nullable=false)
	private String createdBy;
	
	private Date updatedOn;
	private String updatedBy;
	
	
	public Product(int product_id, String name, int amount, int tenure, int rateofInterest, boolean isActive,
			String createdBy, String updatedBy) {
		super();
		this.product_id = product_id;
		this.name = name;
		this.amount = amount;
		this.tenure = tenure;
		this.rateofInterest = rateofInterest;
		this.isActive = isActive;
		this.createdOn = Date.valueOf(LocalDate.now());
		this.createdBy = createdBy;
		this.updatedOn = Date.valueOf(LocalDate.now());
		this.updatedBy = updatedBy;
	}
	

	public Product() {
		super();
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
		return tenure;
	}



	public void setTenure(int tenure) {
		this.tenure = tenure;
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



	public Date getCreatedOn() {
		return createdOn;
	}



	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}



	public String getCreatedBy() {
		return createdBy;
	}



	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}



	public Date getUpdatedOn() {
		return updatedOn;
	}



	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}



	public String getUpdatedBy() {
		return updatedBy;
	}



	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}



	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", name=" + name + ", amount=" + amount + ", Tenure=" + tenure
				+ ", rateofInterest=" + rateofInterest + ", isActive=" + isActive + ", CreatedBy=" + createdBy
				+ ", UpdatedBy=" + updatedBy + "]";
	}
	
	

}
