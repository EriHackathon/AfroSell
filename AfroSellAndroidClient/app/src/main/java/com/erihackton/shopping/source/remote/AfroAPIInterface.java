package com.erihackton.shopping.source.remote;

import com.erihackton.shopping.model.Product;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by aelaf on 2/5/19.
 */

 interface AfroAPIInterface {

    @GET("/products")
    Call<List<Product>> getAllProducts();

    @GET("/product?id")
    Call<Product> getProduct(@Query("id") int id);

    @POST("/products")
    Call<Void> addProduct(@Body Product product);

    @PUT("/products/{id}")
    Call<Void> updateProduct(@Body Product product, @Path("id") int id);

    @DELETE("/products/{id}")
    Call<Void> deleteProduct(@Path("id") int id);

 }
