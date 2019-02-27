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
        setContentView(R.layout.fragment_product_add_x);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupFloatingLabelError();
       /* WelcomeActivityFragment activityFragment =
                (WelcomeActivityFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentWelcome);
        if (activityFragment == null) {
            // Create the fragment
            activityFragment =new  WelcomeActivityFragment();
            ActivityUtil.addFragmentToActivity(getSupportFragmentManager(),activityFragment,R.id.fragmentWelcome);

        }
        mUseCaseHandler = UseCaseHandler.getInstance();
welcomePresenter = WelcomePresenter.getInstance(this,mUseCaseHandler,activityFragment);*/
    }
    private void setupFloatingLabelError() {
        final TextInputLayout floatingProductName = (TextInputLayout) findViewById(R.id.productNameX_text_input_layout);
       final  EditText edt =(EditText) findViewById(R.id.productNameX);
        int val;
        floatingProductName.getEditText().addTextChangedListener(new TextWatcher() {
            // ...
            @Override
            public void onTextChanged(CharSequence text, int start, int count, int after) {
                if (text.length() > 0 && text.length() <= 4) {
                    floatingProductName.setError("Product Name needed");
                    floatingProductName.setErrorEnabled(true);
                } else {
                    floatingProductName.setErrorEnabled(false);
                    Toast.makeText(WelcomeActivity.this,floatingProductName.getEditText().getText().toString(),Toast.LENGTH_LONG).show();
                    Toast.makeText(WelcomeActivity.this,"*"+edt.getText().toString(),Toast.LENGTH_LONG).show();

                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
                Log.d(TAG, "beforeTextChanged: ");
            }

            @Override
            public void afterTextChanged(Editable s) {

                Log.d(TAG, "afterTextChanged: ");
            }
        });
    }

}
