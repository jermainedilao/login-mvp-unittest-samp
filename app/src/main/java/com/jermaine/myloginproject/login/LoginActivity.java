package com.jermaine.myloginproject.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.jermaine.myloginproject.R;
import com.jermaine.myloginproject.notes.LoginSuccessActivity;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    private LoginPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mPresenter = new LoginPresenter(this, new LoginService());
    }

    public void onLoginClicked(View view) {
        mPresenter.onLoginClicked();
    }

    @Override
    public void showUsernameError(int resId) {
        ((EditText) findViewById(R.id.login_username)).setError(getString(resId));
    }

    @Override
    public void showPasswordError(int resId) {
        ((EditText) findViewById(R.id.login_password)).setError(getString(resId));
    }

    @Override
    public void showLoginError(int resId) {
        Toast.makeText(this, resId, Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getUsername() {
        return ((EditText) findViewById(R.id.login_username)).getText().toString();
    }

    @Override
    public String getPassword() {
        return ((EditText) findViewById(R.id.login_password)).getText().toString();
    }

    @Override
    public void startMainActivity() {
        Intent intent = new Intent(this, LoginSuccessActivity.class);
        startActivity(intent);
    }
}
