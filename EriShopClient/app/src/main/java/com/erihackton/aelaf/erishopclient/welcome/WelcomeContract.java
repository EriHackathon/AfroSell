package erihackton.com.aelaf.erishopclient.welcome;

import erihackton.com.aelaf.erishopclient.BasePresenter;
import erihackton.com.aelaf.erishopclient.BaseView;

/**
 * Created by aelaf on 1/29/19.
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
