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
    List<TaskModel> TaskList;
    Context context;

    public TaskAdapter(List<TaskModel> TaskList, Context context) {
        this.TaskList = TaskList;
        this.context = context;
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
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view;
        view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_layout_item,parent,false);
        TasksViewHolder viewHolder2 = new TasksViewHolder(view);
        context = parent.getContext();
        return viewHolder2;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder,final int position){
        TaskModel taskModel = TaskList.get(position);
        TasksViewHolder tvh = (TasksViewHolder) holder;
        tvh.taskName.setText(taskModel.taskName);
        tvh.taskRemainingTime.setText(taskModel.taskTimeLeft);
    }
    @Override
    public int getItemCount(){
        return TaskList.size();
    }
}
