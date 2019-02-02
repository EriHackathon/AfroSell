package erihackton.com.aelaf.erishopclient.welcome;

import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import erihackton.com.aelaf.erishopclient.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class WelcomeActivityFragment extends Fragment implements WelcomeContract.View {
WelcomeContract.Presenter mPresenter;
    Button buttRegister;
    Button buttLogIn;
    EditText editTextUserName;
    EditText editTextPassword;
    View view;
    public WelcomeActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_welcome, container, false);
        buttLogIn  =(Button) view.findViewById(R.id.buttLogIn);
        buttRegister = (Button)view.findViewById(R.id.buttRegister);
        editTextUserName = (EditText)view.findViewById(R.id.edtUserName);
        editTextPassword = (EditText)view.findViewById(R.id.edtPassword);

        buttLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"login",Snackbar.LENGTH_SHORT).show();
                String userName = editTextUserName.getText().toString();
                String password = editTextPassword.getText().toString();
                /**
                 * TODO: CLIENT SIDE validation
                 */
                mPresenter.getUser(userName,password);
            }
        });

        return view;
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
