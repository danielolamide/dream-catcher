package com.example.dreamcatcher;

import androidx.core.content.res.ResourcesCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Get current date
        Calendar today = Calendar.getInstance();
        String [] months = {"JAN","FEB","MAR","APR","MAY","JUN",
                            "JUL","AUG","SEP","OCT","NOV","DEC"};
        int year = (today.get(Calendar.YEAR)) % 100;
        String month = months[today.get(Calendar.MONTH)];
        int day_id = (today.get(Calendar.DAY_OF_WEEK));
        int date_id = (today.get(Calendar.DAY_OF_MONTH));
        String day = null;
        switch(day_id){
            case Calendar.SUNDAY:
                day = "SUN";
                break;
            case Calendar.MONDAY:
                day= "MON";
                break;
            case Calendar.TUESDAY:
                day = "TUE";
                break;
            case Calendar.WEDNESDAY:
                day = "WED";
                break;
            case Calendar.THURSDAY:
                day = "THU";
                break;
            case Calendar.FRIDAY:
                day = "FRI";
                break;
            case Calendar.SATURDAY:
                day = "SAT";
                break;
            default:
                day = "DAY";
                break;
        }
        String currentYear = Integer.toString(year);
        String suffix = getDateSuffix(date_id);
        String day_of_month = Integer.toString(date_id);
        String currentDay = getString(R.string.date,day_of_month,suffix,day,month,year);
        TextView dateView = findViewById(R.id.date_text);
        dateView.setText(currentDay);
    }

    //Get suffix for date
    public String getDateSuffix(int day){
        if (day >= 11 && day <= 13) {
            return "th";
        }
        switch (day % 10) {
            case 1:
                return "st";
            case 2:
                return "nd";
            case 3:
                return "rd";
            default:
                return "th";
        }
    }

}
