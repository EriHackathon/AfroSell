package com.erihackton.shopping.welcome;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.erihackton.shopping.ActivityUtil;
import com.erihackton.shopping.UseCaseHandler;
import com.erihackton.shopping.afrosellandroidclient.R;

public class WelcomeActivity extends AppCompatActivity {
    UseCaseHandler mUseCaseHandler;
    WelcomePresenter welcomePresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        WelcomeActivityFragment activityFragment =
                (WelcomeActivityFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentWelcome);
        if (activityFragment == null) {
            // Create the fragment
            activityFragment =new  WelcomeActivityFragment();
            ActivityUtil.addFragmentToActivity(getSupportFragmentManager(),activityFragment,R.id.fragmentWelcome);

        }
        mUseCaseHandler = UseCaseHandler.getInstance();
welcomePresenter = WelcomePresenter.getInstance(this,mUseCaseHandler,activityFragment);
    }

}
