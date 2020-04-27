package com.attractor.laboratory64.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import java.util.UUID;


@Data
public class Task {


    @Id
    private String id = UUID.randomUUID().toString();
    public String task;
    public boolean isActive = true;


    public Task(String task) {
        this.task = task;
    }


}
