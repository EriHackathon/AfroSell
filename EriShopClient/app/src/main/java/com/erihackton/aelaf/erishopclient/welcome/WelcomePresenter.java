package erihackton.com.aelaf.erishopclient.welcome;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import erihackton.com.aelaf.erishopclient.UseCase;
import erihackton.com.aelaf.erishopclient.UseCaseHandler;
import erihackton.com.aelaf.erishopclient.domain.GetAuthenticUser;

/**
 * Created by aelaf on 1/29/19.
 */

public class WelcomePresenter implements WelcomeContract.Presenter {
    public static final String  TAG = "WelcomePresenter";
    Context mContext;
    UseCaseHandler mUseCaseHandler;
    WelcomeActivityFragment welcomeActivityFragment;
    static WelcomePresenter welcomePresenter;
    public static WelcomePresenter getInstance(Context context, UseCaseHandler useCaseHandler,WelcomeActivityFragment fragment ){
        if(welcomePresenter==null|| context==null){
           welcomePresenter = new WelcomePresenter(context,useCaseHandler,fragment);
        }
        return welcomePresenter;
    }
    private WelcomePresenter(Context context, UseCaseHandler useCaseHandler,WelcomeActivityFragment fragment){
        mContext = context;
        mUseCaseHandler = useCaseHandler;
        welcomeActivityFragment = fragment;
        welcomeActivityFragment.setPresenter(this);
    }

    @Override
    public void getUser(String name, String password) {
        /**
         * TODO:
         * do network request..
         * authenticate
         * update client side
         * persist on client side
         */
        Log.d(TAG, "getUser: "+ name +" and "+password);
        GetAuthenticUser.RequestValues  requestValues = new GetAuthenticUser.RequestValues(name,password);
        GetAuthenticUser getAuthenticUser = new GetAuthenticUser();
        mUseCaseHandler.execute(getAuthenticUser, requestValues, new UseCase.UseCaseCallback<GetAuthenticUser.ResponseValues>() {
            @Override
            public void onSucess(GetAuthenticUser.ResponseValues response) {

            }

            @Override
            public void onError() {

            }
        });
    }

    @Override
    public void start(FragmentActivity fragmentActivity) {
        Log.d(TAG, "start: asking usecaseHandler ;-) " );
    }

    @Override
    public void loadPage(boolean force) {

    }

    @Override
    public void loadAds() {

    }
}
