package com.erihackton.shopping.pro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
	@Autowired
	private ProductServices productService;
	@CrossOrigin(origins = "*")
	@RequestMapping("/products")
    public List<Product> getAllProducts() {
	   return productService.getAllProducts();
     }
     @CrossOrigin(origins = "*")
	@RequestMapping("/products/{id}")
    public Product getProduct(@PathVariable int id) {
		return productService.getProduct(id);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(method=RequestMethod.POST,value="/products")
    public void addProduct(@RequestBody() Product pro) {
		productService.addProduct(pro);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(method=RequestMethod.PUT,value="/products/{id}")
   public void updateProduct(@RequestBody Product pro,@PathVariable int id) {
			productService.updateProduct(pro,id);
		}
	@CrossOrigin(origins = "*")
	@RequestMapping(method=RequestMethod.DELETE,value="/products/{id}")
	public void deleteTopic(@PathVariable int id) {
			productService.deleteProduct(id);
		
	}
}
