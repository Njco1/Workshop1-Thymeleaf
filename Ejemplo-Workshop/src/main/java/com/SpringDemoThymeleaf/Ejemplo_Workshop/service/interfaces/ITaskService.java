package com.SpringDemoThymeleaf.Ejemplo_Workshop.service.interfaces;

import com.SpringDemoThymeleaf.Ejemplo_Workshop.model.Task;
import jakarta.persistence.Id;

import java.util.List;

public interface ITaskService {

    Task saveOrUpdate(Task task);

    List <Task> getTask() throws Exception;

    boolean getDeleteById(Long taskId);
}
