package com.erihackton.shopping.product;

import com.erihackton.shopping.BasePresenter;
import com.erihackton.shopping.BaseView;
import com.erihackton.shopping.model.Product;

import java.util.List;

/**
 * Created by aelaf on 2/6/19.
 */

public interface ProductContract {
    interface Presenter extends BasePresenter{
        void getProducts();
        void addProduct(Product product);
        void updateProduct(int id);

    }
    interface View extends BaseView<Presenter>{
        void showListofProducts(List<Product> productList);
        void showNoProducts();
        void showAddProduct();
        void showUpdateProduct();
    }
}
