package com.erihackton.shopping.pro;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Product {
	@Id
	private int productId;
	private String productName;
	 private String productCategory;
	 private String  productType ;
	 private double price;
	 private String productImage;
	 private String productDiscription;
	 private Date dateCreated,dateDeleted;
	 
	 public Product() {
		 
	 }
	 public Product(int productId, String productName, String productCategory, String productType, double price,
				String productImage, String productDiscription, Date dateCreated, Date dateDeleted) {
			super();
			this.productId = productId;
			this.productName = productName;
			this.productCategory = productCategory;
			this.productType = productType;
			this.price = price;
			this.productImage = productImage;
			this.productDiscription = productDiscription;
			this.dateCreated = dateCreated;
			this.dateDeleted = dateDeleted;
		}
		public void setProductDiscription(String productDiscription) {
			this.productDiscription = productDiscription;
		}
		public Date getDateCreated() {
			return dateCreated;
		}
		public void setDateCreated(Date dateCreated) {
			this.dateCreated = dateCreated;
		}
		public Date getDateDeleted() {
			return dateDeleted;
		}
		public void setDateDeleted(Date dateDeleted) {
			this.dateDeleted = dateDeleted;
		}
		 
	 // Product class Setters and getters
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public String getProductDiscription() {
		return productDiscription;
	}
	
	public Product updateProduct(Product newProduct) {
		//Product currentProduct = this;
		
		setDateCreated(newProduct.getDateCreated());
		setPrice(newProduct.getPrice());
		setProductCategory(newProduct.getProductCategory());
		setProductDiscription(newProduct.getProductDiscription());
		setProductName(newProduct.getProductName());
		setProductType(newProduct.getProductType());
		setProductImage(newProduct.getProductImage());
		
		return this;
	}
	 
	 

}
