package com.example.dreamcatcher;

import androidx.fragment.app.DialogFragment;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CreateTask extends AppCompatActivity {
    FloatingActionButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_create_task);

        Spinner task_type_spinner = findViewById(R.id.task_type_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.task_type_spinner,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        task_type_spinner.setAdapter(adapter);

        //go back button
        back = findViewById(R.id.back_fab);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goBack = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(goBack);
            }
        });
    }
    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }
    public void showDatePickerDialog(View v){
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(),"datepicker");
    }

}
