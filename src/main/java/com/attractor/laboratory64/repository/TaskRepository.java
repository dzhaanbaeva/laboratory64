package com.attractor.laboratory64.repository;

import com.attractor.laboratory64.model.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, String> {
    public Iterable<Task> findAll();
    public Task findTaskById(String id);
}
