package com.erihackton.shopping.productAdd;

import com.erihackton.shopping.BasePresenter;
import com.erihackton.shopping.BaseView;
import com.erihackton.shopping.model.Product;

/**
 * Created by aelaf on 2/6/19.
 */

public interface ProductAddContract {
    interface Presenter extends BasePresenter{
        void addProduct(Product product);
        void updateProduct(Product product);
    }
    interface View extends BaseView<Presenter>{
        void showAddedProduct(Product product);
        void showNoAddedProduct(String err);
        void showUpdateProduct(Product product);
        void showNoUpdateProduct(String err);

    }
}
