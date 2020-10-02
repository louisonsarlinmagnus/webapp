package com.boot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Version
	private Integer version;
	private String productId;
	private String description;
	private String imageUrl;
	private float price;
	
	
	public Product(String productId, String description, String imageURL, float price) {
		super();
		this.productId = productId;
		this.description = description;
		this.imageUrl = imageURL;
		this.price = price;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Product() {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	
	
	
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageURL) {
		this.imageUrl = imageURL;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	
	

}
