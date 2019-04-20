package com.erihackton.shopping.productAdd;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.erihackton.shopping.UseCase;
import com.erihackton.shopping.UseCaseHandler;
import com.erihackton.shopping.domain.AddProduct;
import com.erihackton.shopping.domain.UpdateProduct;
import com.erihackton.shopping.model.Product;

/**
 * Created by aelaf on 2/6/19.
 */

public class ProductAddPresenter implements ProductAddContract.Presenter {
   public static final String TAG = "ProductAddPresenter";
    UseCaseHandler mUseCaseHandler;
    Context mContext;
    ProductAddActivityFragment mProductAddActivityFragmentView;
   /* static ProductAddPresenter productAddPresenter;
    public static ProductAddPresenter getInstance(UseCaseHandler mUseCaseHandler, Context mContext, ProductAddActivityFragment productAddActivityFragment){
        if(productAddPresenter== null)
            productAddPresenter = new ProductAddPresenter(mUseCaseHandler,mContext,productAddActivityFragment);
        return productAddPresenter;
    }*/

    public ProductAddPresenter(UseCaseHandler mUseCaseHandler, Context mContext, ProductAddActivityFragment productAddActivityFragment) {
        this.mUseCaseHandler = mUseCaseHandler;
        this.mContext = mContext;
        this.mProductAddActivityFragmentView = productAddActivityFragment;
        mProductAddActivityFragmentView.setPresenter(this);
    }

    @Override
    public void start(FragmentActivity fragmentActivity) {
        //do some initializations
        Log.d(TAG, "start: init...");

    }

    @Override
    public void updateProduct(final Product product) {
        UpdateProduct updateProduct = new UpdateProduct(mContext);
       UpdateProduct.RequestValues upDateRequestValues = new UpdateProduct.RequestValues(product);
        Log.d(TAG, "updateProduct: action");
        mUseCaseHandler.execute(updateProduct, upDateRequestValues, new UseCase.UseCaseCallback<UpdateProduct.ResponseValue, String>() {
            @Override
            public void onSucess(UpdateProduct.ResponseValue response) {
                mProductAddActivityFragmentView.showUpdateProduct(product);
            }

            @Override
            public void onError(String err) {
                mProductAddActivityFragmentView.showNoUpdateProduct(err);
            }
        });
        
    }

    @Override
    public void addProduct(final Product product) {
        AddProduct addProduct = new AddProduct(mContext);
        AddProduct.RequestValues adRequestValues = new AddProduct.RequestValues(product);
        mUseCaseHandler.execute(addProduct, adRequestValues, new UseCase.UseCaseCallback<AddProduct.ResponseValue, String>() {
            @Override
            public void onSucess(AddProduct.ResponseValue response) {
                Log.d(TAG, "onSucess: "+response.getProductAddResult());
                mProductAddActivityFragmentView.showAddedProduct(product);
            }

            @Override
            public void onError(String err) {
                Log.d(TAG, "onError: "+err);
                mProductAddActivityFragmentView.showNoAddedProduct(err);
            }
        });
    }
}
