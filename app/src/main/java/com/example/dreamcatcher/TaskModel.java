package com.example.dreamcatcher;

public class TaskModel {
    public String taskName;
    public String activeTasks;
    public String taskTimeLeft;


    public TaskModel(String taskName, String taskTimeLeft) {
        this.taskName = taskName;
        this.taskTimeLeft = taskTimeLeft;
    }
}
