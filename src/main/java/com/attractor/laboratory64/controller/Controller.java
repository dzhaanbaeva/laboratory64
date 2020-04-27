package com.attractor.laboratory64.controller;

import com.attractor.laboratory64.model.Task;
import com.attractor.laboratory64.repository.TaskRepository;
import com.attractor.laboratory64.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class Controller {
    private final TaskService taskService;
    private final TaskRepository taskRepository;

    public Controller(TaskService taskService, TaskRepository taskRepository) {
        this.taskService = taskService;
        this.taskRepository = taskRepository;
    }

    @GetMapping("/tasks")
    public Iterable<Task> getTasks() {
        return taskService.getTask();
    }

    @PostMapping("/tasks/{id}")
    public Task changeActive(@PathVariable String id) {
        Task task = taskRepository.findTaskById(id);
        task.isActive = !task.isActive;
        taskRepository.save(task);
        return task;
    }

    @PostMapping("/create")
    public String rootSave(
            @RequestParam("task") String task) throws IOException {


        String t = new String(task);
        taskService.addTask(t);

        return t;
    }
}
