package erihackton.com.aelaf.erishopclient.welcome;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import erihackton.com.aelaf.erishopclient.ActivityUtil;
import erihackton.com.aelaf.erishopclient.R;
import erihackton.com.aelaf.erishopclient.UseCaseHandler;

public class WelcomeActivity extends AppCompatActivity {
UseCaseHandler mUseCaseHandler;
    WelcomePresenter welcomePresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

         mUseCaseHandler = UseCaseHandler.getInstance();

        WelcomeActivityFragment activityFragment =
                (WelcomeActivityFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentWelcome);
        if (activityFragment == null) {
            // Create the fragment
            activityFragment =new  WelcomeActivityFragment();
            ActivityUtil.addFragmentToActivity(getSupportFragmentManager(),activityFragment,R.id.fragmentWelcome);

        }
        /***
         * WelcomePresenter shud no t bo recreated every now then s
         */
        welcomePresenter =  WelcomePresenter.getInstance(this,mUseCaseHandler,activityFragment);
    }

}
