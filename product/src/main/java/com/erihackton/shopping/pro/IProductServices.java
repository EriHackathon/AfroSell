package com.erihackton.shopping.pro;

import java.util.List;

public interface IProductServices {

	List<Product> getAllProducts();

	Product getProduct(int id);

	void addProduct(Product pro);

	void updateProduct(Product pro, int id);

	void deleteProduct(int id);
	
}
