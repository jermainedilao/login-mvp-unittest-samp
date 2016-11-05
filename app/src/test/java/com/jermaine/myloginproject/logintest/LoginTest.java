package com.jermaine.myloginproject.logintest;

import com.jermaine.myloginproject.R;
import com.jermaine.myloginproject.login.LoginContract;
import com.jermaine.myloginproject.login.LoginPresenter;
import com.jermaine.myloginproject.login.LoginService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Jermaine on 30/10/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class LoginTest {
    @Mock
    private LoginContract.View mView;
    @Mock
    private LoginService mService;

    private LoginPresenter mPresenter;

    @Before
    public void setUp() throws Exception {
        mPresenter = new LoginPresenter(mView, mService);
    }

    @Test
    public void shouldShowErrorWhenUsernameIsEmpty() throws Exception {
        when(mView.getUsername()).thenReturn("");
        mPresenter.onLoginClicked();

        verify(mView).showUsernameError(R.string.username_error);
    }

    @Test
    public void shouldShowErrorWhenPasswordIsEmpty() throws Exception {
        when(mView.getUsername()).thenReturn("hello");
        when(mView.getPassword()).thenReturn("");
        mPresenter.onLoginClicked();

        verify(mView).showPasswordError(R.string.password_error);
    }

    @Test
    public void shouldShowLoginError() throws Exception {
        when(mView.getUsername()).thenReturn("hello");
        when(mView.getPassword()).thenReturn("world");
        when(mService.login("hello", "world")).thenReturn(false);
        mPresenter.onLoginClicked();

        verify(mView).showLoginError(R.string.login_error);
    }

    @Test
    public void shouldStartMainActivity() throws Exception {
        when(mView.getUsername()).thenReturn("hello");
        when(mView.getPassword()).thenReturn("hello");
        when(mService.login("hello", "hello")).thenReturn(true);
        mPresenter.onLoginClicked();

        verify(mView).startMainActivity();
    }
}
