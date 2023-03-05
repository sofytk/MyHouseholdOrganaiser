package com.example.myhouseholdorganaiser.task;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myhouseholdorganaiser.R;

import java.util.List;

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.MyViewHolder> {

    private final List<MyTask> myTasks;

    public TasksAdapter(List<MyTask> myTasks) {
        this.myTasks = myTasks;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tasks_item, parent, false);
        return new MyViewHolder(view);
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView nameOfTask;
        private TextView deadline;
        private CheckBox checkBox;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameOfTask = itemView.findViewById(R.id.task_name);
            deadline = itemView.findViewById(R.id.deadline);
            checkBox = itemView.findViewById(R.id.do_switch);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull TasksAdapter.MyViewHolder holder, int position) {
        MyTask task = myTasks.get(position);
        holder.nameOfTask.setText(task.getNameOfTask());
        holder.deadline.setText(task.getDeadline());
    }

    @Override
    public int getItemCount() {
        return myTasks.size();
    }
}
