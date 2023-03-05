package com.example.myhouseholdorganaiser.task;

import java.io.Serializable;

public class MyTask implements Serializable {
    private String nameOfTask;
    private String deadline;

    public MyTask(String nameOfTask, String deadline) {
        this.nameOfTask = nameOfTask;
        this.deadline = deadline;
    }

    public String getNameOfTask() {
        return nameOfTask;
    }

    public String getDeadline() {
        return deadline;
    }

    public static MyTask getData(){
    String nameOfTask = "gagaga";
     String deadline = "21.09.88";
return new MyTask(nameOfTask, deadline);
    }
}
