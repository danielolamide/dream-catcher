package com.example.dreamcatcher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void startSignUp(View v){
        Intent signUpActivity = new Intent(LoginActivity.this,SignUpActivity.class);
        startActivity(signUpActivity);
    }
}
