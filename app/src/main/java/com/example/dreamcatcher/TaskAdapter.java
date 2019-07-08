package com.example.dreamcatcher;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

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

    public class ActiveViewHolder extends RecyclerView.ViewHolder{
        public TextView activeTasks;

        public ActiveViewHolder(View itemView) {
            super(itemView);
            activeTasks = itemView.findViewById(R.id.active_task_number);
        }
    }
    private static final int TYPE_TASK = 1;
    private static final int TYPE_ACTIVE_NUMBER = 2;

//    @Override
//    public int getItemViewType(int position){
//        return position==0 ? TYPE_ACTIVE_NUMBER : TYPE_TASK;
//    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view;
//        switch (viewType){
//            case TYPE_ACTIVE_NUMBER:
//                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.active_task_item,parent,false);
//                ActiveViewHolder viewHolder1 = new ActiveViewHolder(view);
//                return viewHolder1;
//            case TYPE_TASK:
                view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_layout_item,parent,false);
                TasksViewHolder viewHolder2 = new TasksViewHolder(view);
                return viewHolder2;
//            default:
//                throw new IllegalArgumentException("Failed");
//        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder,final int position){
        TaskModel taskModel = TaskList.get(position);
//        if(holder.getItemViewType()==TYPE_ACTIVE_NUMBER){
//            ActiveViewHolder avh = (ActiveViewHolder) holder;
//            avh.activeTasks.setText(taskModel.activeTasks);
//        }
//        else if(holder.getItemViewType()==TYPE_TASK){

            TasksViewHolder tvh = (TasksViewHolder) holder;
            tvh.taskName.setText(taskModel.taskName);
            tvh.taskRemainingTime.setText(taskModel.taskTimeLeft);
//        }
    }
    @Override
    public int getItemCount(){
        return TaskList.size();
    }
}
