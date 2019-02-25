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
	@CrossOrigin(origins = "*")

	/*
	 * this methods  retrieves  all the product
	 * 
	 */
	@RequestMapping("/products")
    public ResponseEntity<Object> getAllProducts() {
		List<Product> listp;
		
		listp=productService.getAllProducts();
	    if (listp.size()==0) throw new ProductNotFoundException("Products are not found");
	      return new ResponseEntity<>(listp,HttpStatus.OK);
	   
     }
	
	/*
	 * retrieves specific product using product Id 
	 * 	product id as parameter 
	 */
	
	 @RequestMapping("/products/{id}")
	 
    public ResponseEntity<Object> getProduct(@PathVariable int id) throws ProductNotFoundException{
		 Product p;
		 try {
		 p= productService.getProduct(id);
		 }
		 catch(Exception ex) {
			 throw new ProductNotFoundException("Product Not Found ");
		 }
		
		
		 return new ResponseEntity<>(p,HttpStatus.OK);
	}
	 /*
	  * This method adds product to the table 
	  * product as parameter 
	  */
	 
	@RequestMapping(method=RequestMethod.POST,value="/products")
    public ResponseEntity<Object> addProduct(@RequestBody() Product pro) {
		try {
		productService.addProduct(pro);
		}
		catch(Exception ex) {
			throw new ProductNotFoundException("Product is not Added");
		}
		return new ResponseEntity<>("Product are Added",HttpStatus.OK);
		
		
	}
	/*
	 * 	This methods update the  product using  Product Id 
	 * It takes  product Instance and product Id as parameter 
	 */
	  @RequestMapping(method=RequestMethod.PUT,value="/products/{id}")
	 
   public ResponseEntity<Object> updateProduct(@RequestBody Product pro,@PathVariable int id) {
		  try {
			productService.updateProduct(pro,id);
		  }
		  
		  catch(Exception ex) {
			  throw new ProductNotFoundException("Product cant be Updated");
		  }
		  return new ResponseEntity<>("Product updated Successfully ",HttpStatus.OK);
		}
	  /*
	   * This method deletes  product using  product Id 
	   * It takes product Id as Parameter
	   */
	@RequestMapping(method=RequestMethod.DELETE,value="/products/{id}")
	public ResponseEntity<Object> deleteTopic(@PathVariable int id) {
		try {
			productService.deleteProduct(id);
		}catch(Exception ex) {
			throw new ProductNotFoundException("The Id is not Associated with any Product");
		}
		return new ResponseEntity<>("Product is deleted",HttpStatus.OK);
	}
}
