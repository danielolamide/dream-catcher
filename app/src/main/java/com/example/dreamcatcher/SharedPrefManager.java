package com.example.dreamcatcher;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class SharedPrefManager {
    //constants
    private static final String SHARED_PREF_NAME = "dreamcatcher_sharedpref";
    private static final String NAME = "name";
    private static final String USERNAME = "username";
    private static final String EMAIL = "email";
    private static final String ID = "id";

    private static SharedPrefManager mInstance;
    private static Context mContext;

    private SharedPrefManager(Context context) {
        mContext = context;
    }

    static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }

    // method to allow user login
    public void userLogin(User user) {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(ID, user.getId());
        editor.putString(USERNAME, user.getUsername());
        editor.putString(EMAIL, user.getEmail());
        editor.apply();
    }

    // method to check whether user is already logged in
    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(USERNAME, null) != null;
    }

    // get the logged in user
    public User getUser() {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new User (
                sharedPreferences.getInt(ID, -1),
                sharedPreferences.getString(NAME, null),
                sharedPreferences.getString(USERNAME, null),
                sharedPreferences.getString(EMAIL, null)
        );
    }

    // log out the user
    public void logout() {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        mContext.startActivity(new Intent(mContext,LoginActivity.class));
    }
}
