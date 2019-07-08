package com.example.dreamcatcher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ProfileActivity extends AppCompatActivity {
    FloatingActionButton back;
    TextView usernameView, emailView, nameView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //if the user is not logged in
        //starting the login activity
        if (!SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }

        //go back button
        back = findViewById(R.id.back_fab);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goBack = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(goBack);
            }
        });

        emailView.findViewById(R.id.textView3);
        usernameView.findViewById(R.id.textView14);
        nameView.findViewById(R.id.textView12);

        //getting the current user
        User user = SharedPrefManager.getInstance(this).getUser();

        //setting the values to the textviews
        usernameView.setText(user.getUsername());
        emailView.setText(user.getEmail());
        nameView.setText(user.getName());
    }
}
