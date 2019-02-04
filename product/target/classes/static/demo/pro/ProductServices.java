package com.product.demo.pro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServices {
	@Autowired
	private  ProductRepository prorepos ;
	public List<Product> getAllProducts(){
		return  (List<Product>) prorepos.findAll();
	}
	public String getProduct(int id) {
		return prorepos.sayHi();
	}
	public void addProduct(Product pro) {
		
		
	}
	public void updateProduct(Product pro, int id) {
		
		
	}
	public String deleteProduct(int id) {
		
		return null;
	}

}
