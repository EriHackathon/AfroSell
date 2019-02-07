    package com.erihackton.shopping.welcome;

    import android.support.v4.app.Fragment;
    import android.os.Bundle;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;

    import com.erihackton.shopping.afrosellandroidclient.R;

    /**
     * A placeholder fragment containing a simple view.
     */
    public class WelcomeActivityFragment extends Fragment implements WelcomeContract.View {

        WelcomeContract.Presenter mPresenter;

        public WelcomeActivityFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_welcome, container, false);
        }

        @Override
        public void setPresenter(WelcomeContract.Presenter presenter) {
            mPresenter = presenter;
            mPresenter.start(this.getActivity());
        }

        @Override
        public void showLoadingIndicator() {

        }

        @Override
        public void showAds() {


        }

        @Override
        public void showuserLoginFailure() {

        }
    }
