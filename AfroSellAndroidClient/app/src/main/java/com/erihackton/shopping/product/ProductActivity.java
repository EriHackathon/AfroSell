package com.erihackton.shopping.product;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.erihackton.shopping.ActivityUtil;
import com.erihackton.shopping.UseCaseHandler;
import com.erihackton.shopping.afrosellandroidclient.R;

public class ProductActivity extends AppCompatActivity {

    UseCaseHandler mUseCaseHandler;
    ProductPresenter mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ProductActivityFragment productActivityFragment =
                (ProductActivityFragment) getSupportFragmentManager().findFragmentById(R.id.productfragment);
        mUseCaseHandler = UseCaseHandler.getInstance();
        ActivityUtil.addFragmentToActivity(getSupportFragmentManager(),productActivityFragment,R.id.productfragment);
        if (productActivityFragment==null)
            productActivityFragment =  ProductActivityFragment.getInstance();
        mPresenter =  new ProductPresenter(this,mUseCaseHandler,productActivityFragment);



    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
