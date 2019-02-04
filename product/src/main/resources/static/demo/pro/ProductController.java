package com.product.demo.pro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	@Autowired
	private ProductServices productService;
	@RequestMapping("/products")
    public List<Product> getAllProducts() {
	   return productService.getAllProducts();
     }
	@RequestMapping("/products/{id}")
    public String getProduct(@PathVariable int id) {
		return productService.getProduct(2);
	}
	@RequestMapping(method=RequestMethod.POST,value="/products")
    public void addProduct(@RequestBody Product pro) {
		productService.addProduct(pro);
	}
	@RequestMapping(method=RequestMethod.PUT,value="/products/{id}")
   public void updateProduct(@RequestBody Product pro,@PathVariable int id) {
			productService.updateProduct(pro,id);
		}
	@RequestMapping(method=RequestMethod.DELETE,value="/products/{id}")
	public String deleteTopic(@PathVariable int id) {
		return productService.deleteProduct(id);
		
	}
}
