ppackage com.erihackton.shopping.pro;
/*
 * This class is about product controller class 
 * developed by Dawit Tekle
 */
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.erihackton.shopping.exceptions.ProductNotFoundException;

@RestController
public class ProductController {
	@Autowired
	private ProductServices productService;
	/*
	 * this methods  retrieves  all the product
	 * 
	 */
	@RequestMapping("/products")
    public ResponseEntity<Object> getAllProducts() {
		List<Product> listp;
		
		listp=productService.getAllProducts();
	    if (listp.size()==0) throw new ProductNotFoundException();
	      return new ResponseEntity<>(listp,HttpStatus.OK);
	   
     }
	/*
	 * retrieves specific product using product Id 
	 * 	product id as parameter 
	 */
	
	 @RequestMapping("/products/{id}")
	 
    public ResponseEntity<Object> getProduct(@PathVariable int id) {
		Product p= productService.getProduct(id);
		if(p==null) throw new ProductNotFoundException();
		 return new ResponseEntity<>(p,HttpStatus.OK);
	}
	 /*
	  * This method adds product to the table 
	  * product as parameter 
	  */
	 
	@RequestMapping(method=RequestMethod.POST,value="/products")
    public void addProduct(@RequestBody() Product pro) {
		if(pro!=null) {
		productService.addProduct(pro);
		}
	}
	/*
	 * 	This methods update the  product using  Product Id 
	 * It takes  product Instance and product Id as parameter 
	 */
	  @RequestMapping(method=RequestMethod.PUT,value="/products/{id}")
	 
   public void updateProduct(@RequestBody Product pro,@PathVariable int id) {
			productService.updateProduct(pro,id);
		}
	  /*
	   * This method deletes  product using  product Id 
	   * It takes product Id as Parameter
	   */
	@RequestMapping(method=RequestMethod.DELETE,value="/products/{id}")
	public void deleteTopic(@PathVariable int id) {
			productService.deleteProduct(id);
		
	}
}
