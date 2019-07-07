package com.example.dreamcatcher;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    RecyclerView tasks_info;
    TaskAdapter taskAdapter;
    ArrayList<TaskModel> taskModels = new ArrayList<>();

    public static final String[] activeTasks ={"1"};
    public static final String[] taskNames = {"Learn to play piano","Learn to swim","Stop smoking"};
    public static final String[] timeRemaining = {"12hrs 20min","1hr 30min","20hrs 10min"};

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

        TaskModel taskModel = new TaskModel();
        taskModel.setActiveTasks(activeTasks[0]);
        for(int i = 0 ; i<taskNames.length; i++){
            taskModel.setTaskName(taskNames[i]);
            taskModel.setTaskTimeLeft(timeRemaining[i]);
            taskModels.add(taskModel);

        }
        tasks_info = findViewById(R.id.recycler_task_details);
        taskAdapter = new TaskAdapter(taskModels);
        tasks_info.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
//        tasks_info.setItemAnimator(new DefaultItemAnimator());
        tasks_info.setAdapter(taskAdapter);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Intent intent;
                Toast toast;
                switch(menuItem.getItemId()){
                    case R.id.home_page:
                        break;
                    case R.id.tasks_menu:
                         toast = Toast.makeText(MainActivity.this,"Task Menu",Toast.LENGTH_LONG);
                        toast.show();
                        break;
                    case R.id.create_task_menu:
                        intent = new Intent(MainActivity.this,CreateTask.class);
                        startActivity(intent);
                        break;
                    case R.id.profile_menu:
                        intent = new Intent(MainActivity.this,ProfileActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        intent = null;
                        break;

                }
                return false;
            }
        });
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
