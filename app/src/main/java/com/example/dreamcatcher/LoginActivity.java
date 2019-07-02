package com.example.dreamcatcher;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final EditText passwordField = findViewById(R.id.signInPassword);
        final EditText emailField = findViewById(R.id.signInEmail);
        Button signIn_btn = findViewById(R.id.signIn_btn);

        signIn_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String password = passwordField.getText().toString();
                String email = emailField.getText().toString();
            }
        });



    }
    public void signIn(View v){

    }
    public void startSignUp(View v){
        Intent signUpActivity = new Intent(LoginActivity.this,SignUpActivity.class);
        startActivity(signUpActivity);
    }
}
