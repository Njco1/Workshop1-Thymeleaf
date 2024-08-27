package com.SpringDemoThymeleaf.Ejemplo_Workshop.service.impl;

import com.SpringDemoThymeleaf.Ejemplo_Workshop.model.Task;
import com.SpringDemoThymeleaf.Ejemplo_Workshop.repository.TaskRepository;
import com.SpringDemoThymeleaf.Ejemplo_Workshop.service.interfaces.ITaskService;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskService implements ITaskService {


    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    @Transactional
    public Task saveOrUpdate(Task task) {
        try{
            Task taskCreated = Task.builder()
                    .title(task.getTitle())
                    .description(task.getDescription())
                    .creationDate(task.getCreationDate())
                    .creationTime(task.getCreationTime())
                    .state(task.getState())
                    .build();
            return taskRepository.save(taskCreated);

        }catch (Exception e){
            throw new RuntimeException("ERROR: Task not created", e);
        }

    }

    @Override
    @Transactional(readOnly = true)
    public List<Task> getTask() throws Exception {
        try{
            return taskRepository.findAll();

    }catch (DataAccessException e){
            throw new Exception("ERROR: Task not have obtain from DATABASE", e);
        }
    }

    @Override
    @Transactional
    public boolean getDeleteById(Long taskId) {
        try{
            taskRepository.deleteById(taskId);
            if (taskRepository.findById(taskId) != null){
                return true;
            }
            return false;

        }catch (Exception e){
            throw new RuntimeException("ERROR: Task not be deleted by id", e);
        }
    }

   /* @Override
    @Transactional
    public boolean getDeleteById(Long taskId) {
        try{
            taskRepository.deleteById(taskId);
            return !taskRepository.findById(taskId).isPresent();

        }catch (){

        }
    }
    */
}
