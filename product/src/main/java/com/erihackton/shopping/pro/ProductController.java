package com.erihackton.shopping.pro;
/*
 * This class is about product controller class
 * developed by Dawit Tekle
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.erihackton.shopping.exceptions.ProductNotFoundException;

@RestController
public class ProductController {
    @Autowired
    private ProductServices productService;


    /*
     * this methods  retrieves  all the product
     *
     */
    @CrossOrigin(origins = "*")
    @RequestMapping("/products")
    public ResponseEntity<Object> getAllProducts() {
        List<Product> listp;

        listp = productService.getAllProducts();
        if (listp.size() == 0) throw new ProductNotFoundException();
        return new ResponseEntity<>(listp, HttpStatus.OK);

    }

    /*
     * retrieves specific product using product Id
     * 	product id as parameter
     */

    @CrossOrigin(origins = "*")
    @RequestMapping("/products/{id}")
    public ResponseEntity<Object> getProduct(@PathVariable int id) {
        Product p = productService.getProduct(id);
        if (p == null) throw new ProductNotFoundException();
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    /*
     * This method adds product to the table
     * product as parameter
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST, value = "/products")
    public void addProduct(@RequestBody() Product pro) {
        if (pro != null) {
            productService.addProduct(pro);
        }
    }


    /*
     * 	This methods update the  product using  Product Id
     * It takes  product Instance and product Id as parameter
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.PUT, value = "/products/{id}")

    public void updateProduct(@RequestBody Product pro, @PathVariable int id) {
        productService.updateProduct(pro, id);
    }

    /*
     * This method deletes  product using  product Id
     * It takes product Id as Parameter
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.DELETE, value = "/products/{id}")
    public void deleteTopic(@PathVariable int id) {
        productService.deleteProduct(id);

    }
}
