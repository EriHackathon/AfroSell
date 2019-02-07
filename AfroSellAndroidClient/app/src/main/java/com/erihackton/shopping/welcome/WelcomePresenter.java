package com.erihackton.shopping.welcome;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.erihackton.shopping.UseCase;
import com.erihackton.shopping.UseCaseHandler;
import com.erihackton.shopping.domain.GetProducts;
import com.erihackton.shopping.model.Product;

import java.util.List;

/**
 * Created by aelaf on 2/5/19.
 */

public class WelcomePresenter implements WelcomeContract.Presenter {
    public static final String  TAG = "WelcomePresenter";
    Context mContext;
    UseCaseHandler mUseCaseHandler;
    WelcomeActivityFragment welcomeActivityFragment;
    static WelcomePresenter welcomePresenter;
    public static WelcomePresenter getInstance(Context context, UseCaseHandler useCaseHandler, WelcomeActivityFragment fragment ){
        if(welcomePresenter==null|| context==null){
            welcomePresenter = new WelcomePresenter(context,useCaseHandler,fragment);

        }
        return welcomePresenter;
    }

    private WelcomePresenter(Context mContext, UseCaseHandler mUseCaseHandler, WelcomeActivityFragment welcomeActivityFragment) {
        this.mContext = mContext;
        this.mUseCaseHandler = mUseCaseHandler;
        this.welcomeActivityFragment = welcomeActivityFragment;
        welcomeActivityFragment.setPresenter(this);
    }

    @Override
    public void start(FragmentActivity fragmentActivity) {
        GetProducts getProducts = new GetProducts(mContext);
        mUseCaseHandler.execute(getProducts, null, new UseCase.UseCaseCallback<GetProducts.ResponseValue,String>() {
            @Override
            public void onSucess(GetProducts.ResponseValue response) {
                List<Product> productList = response.getProductList();
                Log.d(TAG, "onSucess: "+productList.get(0).getProductName());
                welcomeActivityFragment.showAds();
            }

            @Override
            public void onError(String err) {
                Log.d(TAG, "onError: "+err);
            }


        });
    }

    @Override
    public void loadPage(boolean force) {

    }

    @Override
    public void loadAds() {

    }

    @Override
    public void getUser(String name, String password) {

    }
}
