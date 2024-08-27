package com.SpringDemoThymeleaf.Ejemplo_Workshop.repository;

import com.SpringDemoThymeleaf.Ejemplo_Workshop.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository <Task, Long> {

   // Tarea findByDescription(String description);
}
