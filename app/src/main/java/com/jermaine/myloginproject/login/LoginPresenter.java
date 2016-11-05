package com.jermaine.myloginproject.login;

import com.jermaine.myloginproject.R;

/**
 * Created by Jermaine on 30/10/2016.
 */
public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View mView;
    private LoginService mService;

    public LoginPresenter(LoginContract.View mView, LoginService mService) {
        this.mView = mView;
        this.mService = mService;
    }

    @Override
    public void onLoginClicked() {
        String username = mView.getUsername();
        String password = mView.getPassword();
        if (username.isEmpty()) {
            mView.showUsernameError(R.string.username_error);
            return;
        }
        if (password.isEmpty()) {
            mView.showPasswordError(R.string.password_error);
            return;
        }

        boolean isLoginSuccessful = mService.login(username, password);

        if (isLoginSuccessful) {
            mView.startMainActivity();
            return;
        }

        mView.showLoginError(R.string.login_error);
    }
}
