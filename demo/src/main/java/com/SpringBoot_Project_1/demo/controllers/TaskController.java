package com.SpringBoot_Project_1.demo.controllers;

import com.SpringBoot_Project_1.demo.dto.CreateTaskDTO;
import com.SpringBoot_Project_1.demo.entities.TaskEntities;
import com.SpringBoot_Project_1.demo.services.Task_services;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/Task")
public class TaskController {
    private final Task_services TaskService;

    public TaskController(Task_services taskService) {
        this.TaskService = taskService;
    }

    @GetMapping("")
    public ResponseEntity<ArrayList<TaskEntities>> getTasks() {
        var tasks = TaskService.getTasks();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getTaskById(@PathVariable ("id")Integer id) {
        var task = TaskService.getTaskById(id);
        if (task == null) {
            ResponseEntity.BodyBuilder resp = ResponseEntity.status(HttpStatus.NOT_FOUND);
            return resp.body("Data Not Available");
        }
        return ResponseEntity.ok(task);
    }
    @PostMapping("")
    public ResponseEntity<TaskEntities> addTask(@RequestBody CreateTaskDTO body){
        var task =TaskService.addTask(body.getTitle(), body.getDescription(), body.getDeadline());
        return ResponseEntity.ok(task);
    }
}