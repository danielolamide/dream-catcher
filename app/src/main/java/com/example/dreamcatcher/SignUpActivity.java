package com.example.dreamcatcher;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }
    public void startSignIn(View v){
        Intent signInActivity = new Intent(SignUpActivity.this,LoginActivity.class);
        startActivity(signInActivity);
    }
}
