package com.jermaine.myloginproject.login;

/**
 * Created by Jermaine on 30/10/2016.
 */
public class LoginService {
    public boolean login(String username, String password) {
        return username.contentEquals(password);
    }
}
