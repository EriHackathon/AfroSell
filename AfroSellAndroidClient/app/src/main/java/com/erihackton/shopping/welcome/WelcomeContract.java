package com.erihackton.shopping.welcome;

import com.erihackton.shopping.BasePresenter;
import com.erihackton.shopping.BaseView;

/**
 * Created by aelaf on 2/5/19.
 */

public interface WelcomeContract {
    interface View extends BaseView<Presenter> {

        void showLoadingIndicator();
        void showAds();
        //void showUserLogin(User user);
        void showuserLoginFailure();
    }
    interface Presenter extends BasePresenter {
        void loadPage(boolean force);
        void loadAds();
        void getUser(String name,String password);
        // void loadUserLogin(User user);
    }
}
