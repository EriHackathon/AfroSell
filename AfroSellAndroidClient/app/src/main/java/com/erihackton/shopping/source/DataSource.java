package com.erihackton.shopping.source;

import com.erihackton.shopping.model.Product;

import java.util.List;

/**
 * Created by aelaf on 2/5/19.
 */

public interface DataSource {
    interface getAuthenticUserCallBack{
        void onSuccess(String result);
        void onError(String err);
    }
    //products CRUD
    interface  GetAllProductsCallBack{
        void onSuccess(List<Product> productList);
        void onError(String err);
    }
    interface GetProductCallBack{
        void onSuccess(String result);
        void onError(String err);
    }
    interface AddProductCallBack{
        void onSuccess(String result);
        void onError(String err);
    }
    interface UpdateProductCallBack{
        void onSuccess(String result);
        void onError(String err);

    }
    interface DeleteProductCallBack{
        void onSuccess(String result);
        void onError(String err);
    }
    interface AddProductsCallBack{
        void onSuccess(String result);
        void onError(String err);
    }
    void getAuthenticUser(String name, String password,getAuthenticUserCallBack getAuthenticUserCallBack);

   void getAllProducts(GetAllProductsCallBack getAllProductsCallBack);

    void getProduct(int id,GetProductCallBack getProductCallBack );

    void addProduct(Product pro,AddProductCallBack addProductCallBack);

    void updateProduct(Product pro,UpdateProductCallBack updateProductCallBack);

    void deleteProduct(int id, DeleteProductCallBack deleteProductCallBack);
    void addProducts(List<Product> product,AddProductsCallBack addProductsCallBack);
}