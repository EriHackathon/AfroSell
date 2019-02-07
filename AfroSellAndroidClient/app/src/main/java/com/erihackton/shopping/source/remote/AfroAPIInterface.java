package com.erihackton.shopping.source.remote;

import com.erihackton.shopping.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by aelaf on 2/5/19.
 */

 interface AfroAPIInterface {

    @GET("/products")
    Call<List<Product>> getAllProducts();

    @GET("/product?id")
    Call<Product> getProduct(@Query("id") int id);

    @POST("/addproduct")
    Call<String> addProduct(@Body Product product);

    @POST("/updateProduct")
    Call<Product> updateProduct(@Body Product product,@Query("id") int id);

 }
