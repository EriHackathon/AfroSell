package com.erihackton.shopping.product;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.erihackton.shopping.UseCase;
import com.erihackton.shopping.UseCaseHandler;
import com.erihackton.shopping.domain.GetProducts;
import com.erihackton.shopping.model.Product;
import com.erihackton.shopping.productAdd.ProductAddPresenter;

/**
 * Created by aelaf on 2/6/19.
 */

public class ProductPresenter implements ProductContract.Presenter {
    public static final String TAG = "ProductPresenter";
    UseCaseHandler mUseCaseHandler;
    Context mContext;
    ProductActivityFragment productActivityFragment;
  /* static  ProductPresenter productPresenter;
    public static ProductPresenter getInstance(Context mContext,UseCaseHandler mUseCaseHandler,  ProductActivityFragment productActivityFragment){
        if(productPresenter==null){
            productPresenter = new ProductPresenter(mContext,mUseCaseHandler,productActivityFragment);
        }

        return  productPresenter;
    }*/
    public ProductPresenter(Context mContext,UseCaseHandler mUseCaseHandler,  ProductActivityFragment productActivityFragment) {
        this.mUseCaseHandler = mUseCaseHandler;
        this.mContext = mContext;
        this.productActivityFragment = productActivityFragment;
        this.productActivityFragment.setPresenter(this);
    }

    @Override
    public void start(FragmentActivity fragmentActivity) {
        getProducts();

    }

    @Override
    public void getProducts() {
        GetProducts getProducts = new GetProducts(mContext);
        mUseCaseHandler.execute(getProducts, null, new UseCase.UseCaseCallback<GetProducts.ResponseValue, String>() {
            @Override
            public void onSucess(GetProducts.ResponseValue response) {
                Log.d(TAG, "onSuccess: ");
                if (response.getProductList()== null || response.getProductList().isEmpty())
                    productActivityFragment.showNoProducts();
                else
                    productActivityFragment.showListofProducts(response.getProductList());

            }

            @Override
            public void onError(String err) {
                Log.d(TAG, "onError: "+err);
                productActivityFragment.showNoProducts();
            }
        });

    }

    @Override
    public void addProduct(Product product) {

    }

    @Override
    public void updateProduct(int id) {

    }
}
