package com.attractor.laboratory64.service;

import com.attractor.laboratory64.model.Task;
import com.attractor.laboratory64.repository.TaskRepository;
import org.springframework.stereotype.Service;


@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task addTask(String taskData) {

        Task task = new Task(taskData);


        taskRepository.save(task);
        return task;
    }

    public Iterable<Task> getTask() {
        return taskRepository.findAll();
    }

    public Task changeTask(String id) {
        Task task = taskRepository.findTaskById(id);
        task.isActive = !task.isActive;
        taskRepository.save(task);
        return task;
    }

}
