    package com.erihackton.shopping.welcome;

    import android.support.design.widget.TextInputLayout;
    import android.support.v4.app.Fragment;
    import android.os.Bundle;
    import android.text.Editable;
    import android.text.TextWatcher;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.Button;
    import android.widget.EditText;

    import com.erihackton.shopping.afrosellandroidclient.R;

    import org.w3c.dom.Text;

    import static android.R.attr.name;

    /**
     * A placeholder fragment containing a simple view.
     */
    public class WelcomeActivityFragment extends Fragment implements WelcomeContract.View {

        WelcomeContract.Presenter mPresenter;
        TextInputLayout nameLayout;
        EditText nameedtTxt;
        TextInputLayout passLayout;
        EditText passedtTxt;
        Button buttSignIn;
        Button buttSignUp;
        public WelcomeActivityFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.fragment_welcome, container, false);
            nameLayout = (TextInputLayout) v.findViewById(R.id.userNameLayout);
            nameedtTxt = (EditText) v.findViewById(R.id.userName);
            passLayout = (TextInputLayout) v.findViewById(R.id.passwordLayout);
            passedtTxt = (EditText) v.findViewById(R.id.password);
            buttSignIn = (Button) v.findViewById(R.id.buttSignIn);
            buttSignUp = (Button) v.findViewById(R.id.buttSignUp) ;
            preLoginHandling();
            buttSignIn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //sign in
                    //authenticate and give result
                }
            });
            buttSignUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //sign up
                    //forward to register page
                    /**
                     * TODO
                     * single Activity based new registration fragment ui
                     */
                }
            });
            return v;
        }

        private void preLoginHandling() {
            //
            nameLayout.getEditText().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence txt, int i, int i1, int i2) {
                        if(txt.length() == 0){
                            //disable sign in button
                            buttSignIn.setEnabled(false);
                        }
                        else{
                        }
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
            passLayout.getEditText().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence txt, int i, int i1, int i2) {
                    if(txt.length() == 0){
                        buttSignIn.setEnabled(false);
                    }
                    else{

                    }
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });

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
