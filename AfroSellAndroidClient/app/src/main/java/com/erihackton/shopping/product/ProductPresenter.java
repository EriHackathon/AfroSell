package com.erihackton.shopping.product;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.erihackton.shopping.UseCase;
import com.erihackton.shopping.UseCaseHandler;
import com.erihackton.shopping.domain.DeleteProduct;
import com.erihackton.shopping.domain.GetProducts;

/**
 * Created by aelaf on 2/6/19.
 */

public class ProductPresenter implements ProductContract.Presenter {
    public static final String TAG = "ProductPresenter";
    UseCaseHandler mUseCaseHandler;
    Context mContext;
    ProductActivityFragment productActivityFragmentView;
  /* static  ProductPresenter productPresenter;
    public static ProductPresenter getInstance(Context mContext,UseCaseHandler mUseCaseHandler,  ProductActivityFragment productActivityFragmentView){
        if(productPresenter==null){
            productPresenter = new ProductPresenter(mContext,mUseCaseHandler,productActivityFragmentView);
        }

        return  productPresenter;
    }*/
    public ProductPresenter(Context mContext,UseCaseHandler mUseCaseHandler,  ProductActivityFragment productActivityFragmentView) {
        this.mUseCaseHandler = mUseCaseHandler;
        this.mContext = mContext;
        this.productActivityFragmentView = productActivityFragmentView;
        this.productActivityFragmentView.setPresenter(this);
    }

    @Override
    public void deleteProduct(final int id) {
        DeleteProduct deleteProduct = new DeleteProduct(mContext);
        DeleteProduct.RequestValues delProduct = new DeleteProduct.RequestValues(id);
        deleteProduct.setmRequestValues(delProduct);
        mUseCaseHandler.execute(deleteProduct, delProduct, new UseCase.UseCaseCallback<DeleteProduct.ResponseValue, String>() {
            @Override
            public void onSucess(DeleteProduct.ResponseValue response) {
                Log.d(TAG, "onSucess: Delete");
                productActivityFragmentView.showDeleteProduct(id);
            }

            @Override
            public void onError(String err) {
                Log.d(TAG, "onError: Delete");
                productActivityFragmentView.showNoDeleteProduct();
            }
        });

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
                    productActivityFragmentView.showNoProducts();
                else
                    productActivityFragmentView.showListofProducts(response.getProductList());

            }

            @Override
            public void onError(String err) {
                Log.d(TAG, "onError: "+err);
                productActivityFragmentView.showNoProducts();
            }
        });

    }


}
