package com.SpringBoot_Project_1.demo.services;

import com.SpringBoot_Project_1.demo.entities.TaskEntities;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class Task_services {
    @Getter
    private ArrayList<TaskEntities> tasks = new ArrayList<>();
    private int TaskId=1;
    public TaskEntities addTask(String title,String description,String deadline){
        TaskEntities Task = new TaskEntities();
        Task.setId(TaskId);
        Task.setTitle(title);
        Task.setDescription(description);
//        Task.setDeadline(new Date(deadline));
        Task.setCompleted(false);
        tasks.add(Task);
        TaskId++;
        return Task;
    }
//    public ArrayList<TaskEntities> getTasks(){
//        return tasks;
//    }
    public TaskEntities getTaskById(int id){
        for (TaskEntities Task : tasks){
            if (Task.getId()==id){
                return Task;
            }
        }
        return null;
    }
}
