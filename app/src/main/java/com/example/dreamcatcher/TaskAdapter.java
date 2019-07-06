package com.example.dreamcatcher;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder>{

    List<TaskModel> TaskList;
    Context context;
    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView activeTasks,taskName,taskRemainingTime;
        public ViewHolder(View view){
            super(view);
//            activeTasks = view.findViewById(R.id.active_task_number);
            taskName = view.findViewById(R.id.task_name);
            taskRemainingTime = view.findViewById(R.id.time_left_task);
        }

    }
    public TaskAdapter(List<TaskModel> TaskList) {
        this.TaskList = TaskList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_layout_item,parent,false);
        ViewHolder viewHolder= new ViewHolder(view);
        context = parent.getContext();
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder,final int position){

        TaskModel taskModel = TaskList.get(position);
//        holder.activeTasks.setText(taskModel.getActiveTasks());
        holder.taskName.setText(taskModel.getTaskName());
        holder.taskRemainingTime.setText(taskModel.getTaskTimeLeft());
    }
    @Override
    public int getItemCount(){
        return 0;
    }
}
