package com.erihackton.shopping.welcome;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.erihackton.shopping.ActivityUtil;
import com.erihackton.shopping.UseCaseHandler;
import com.erihackton.shopping.afrosellandroidclient.R;

public class WelcomeActivity extends AppCompatActivity {
    UseCaseHandler mUseCaseHandler;
    WelcomePresenter welcomePresenter;
    public static final String TAG ="WelcomeActivity";
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
