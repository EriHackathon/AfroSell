package com.erihackton.shopping.productAdd;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.erihackton.shopping.ActivityUtil;
import com.erihackton.shopping.UseCaseHandler;
import com.erihackton.shopping.afrosellandroidclient.R;

public class ProductAddActivity extends AppCompatActivity {
    UseCaseHandler mUseCaseHandler;
    ProductAddPresenter mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_add);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ProductAddActivityFragment productAddActivityFragment =
                (ProductAddActivityFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentProductAdd);
        if (productAddActivityFragment == null)
            productAddActivityFragment =  ProductAddActivityFragment.getInstance();
        ActivityUtil.addFragmentToActivity(getSupportFragmentManager(),productAddActivityFragment,R.id.fragmentProductAdd);
        mUseCaseHandler = UseCaseHandler.getInstance();
        mPresenter = new ProductAddPresenter(mUseCaseHandler,this,productAddActivityFragment);

                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
