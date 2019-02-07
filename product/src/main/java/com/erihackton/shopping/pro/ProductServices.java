package com.erihackton.shopping.pro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServices implements IProductServices {
	@Autowired
	private  ProductRepository prorepos ;
	public List<Product> getAllProducts(){
		return  (List<Product>) prorepos.findAll();
	}
	public Product getProduct(int id) {
//		return "Hello";//prorepos.sayHi();
		return prorepos.findById(id).get();
	}
	public void addProduct(Product pro) {
		//check duplication or set the primaryKey autoincrement
		prorepos.save(pro);
		
		
	}
	public void updateProduct(Product Updatedpro, int id) {
		Product currentProduct = prorepos.findById(id).get();
			
		currentProduct.updateProduct(Updatedpro);
		
		prorepos.save(currentProduct);
		
	}
	public void deleteProduct(int id) {
		//handle entiry not found;
		prorepos.deleteById(id);
	}

}