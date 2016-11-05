package com.jermaine.myloginproject.login;

/**
 * Created by Jermaine on 30/10/2016.
 */
public class LoginContract {
    /**
     * View interface, LoginActivity should implement this
     **/

    public interface View {
        void showUsernameError(int resId);

        void showPasswordError(int resId);

        void showLoginError(int resId);

        String getUsername();

        String getPassword();

        void startMainActivity();
    }

    /**
     * Presenter interface, LoginPresenter should implement this
     **/
    interface Presenter {
        void onLoginClicked();
    }
}
