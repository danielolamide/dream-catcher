package com.example.dreamcatcher;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    public static final int TYPE_ACTIVE_COUNT = 0;
    public static final int TYPE_TASKS = 1;
    List<TaskModel> TaskList;
    Context context;

    public TaskAdapter(List<TaskModel> TaskList) {
        this.TaskList = TaskList;
    }

    public class ActiveTasksViewHolder extends RecyclerView.ViewHolder{
        public TextView activeTasks;

        public ActiveTasksViewHolder(View view){
            super(view);
            activeTasks = view.findViewById(R.id.active_task_number);

        }
    }

    public class TasksViewHolder extends RecyclerView.ViewHolder{
        public TextView taskName, taskRemainingTime;

        public TasksViewHolder(View view) {
            super(view);
            taskName = view.findViewById(R.id.task_name);
            taskRemainingTime = view.findViewById(R.id.time_left_task);
        }
    }

    @Override
    public int getItemViewType(int position){
       if(position < 1){
           return TYPE_ACTIVE_COUNT;
       }
       else{
           return TYPE_TASKS;
       }
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view;
        switch (viewType){
            case TYPE_ACTIVE_COUNT:
                  view = LayoutInflater.from(parent.getContext()).inflate(R.layout.active_task_item,parent,false);
                ActiveTasksViewHolder viewHolder= new ActiveTasksViewHolder(view);
                context = parent.getContext();
                return viewHolder;
            case TYPE_TASKS:
                view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_layout_item,parent,false);
                TasksViewHolder viewHolder2 = new TasksViewHolder(view);
                context = parent.getContext();
                return viewHolder2;
            default:
                throw new IllegalArgumentException("Invalid");
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder,final int position){
        TaskModel taskModel = TaskList.get(position);
        switch(holder.getItemViewType()){
            case TYPE_ACTIVE_COUNT:
                ActiveTasksViewHolder atv = (ActiveTasksViewHolder) holder;
                atv.activeTasks.setText(taskModel.getActiveTasks());
                break;
            case TYPE_TASKS:
                TasksViewHolder tvh = (TasksViewHolder) holder;
                tvh.taskName.setText(taskModel.getTaskName());
                tvh.taskRemainingTime.setText(taskModel.getTaskTimeLeft());
                break;
            default:
                throw new IllegalArgumentException("Failed");

        }
    }
    @Override
    public int getItemCount(){
        return 0;
    }
}
