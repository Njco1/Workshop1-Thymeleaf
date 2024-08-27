package com.SpringDemoThymeleaf.Ejemplo_Workshop.model;

import com.SpringDemoThymeleaf.Ejemplo_Workshop.enums.StateEnum;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Builder
@Table(name = "tareas")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "title", length = 100, nullable = false)
    String title;

    @Column(name = "description")
    String description;

    @Column(name = "creation_date", nullable = false)
    LocalDate creationDate;

    @Column(name = "creation_time", nullable = false)
    LocalTime creationTime;

    @Column(name = "state", length = 50, nullable = false)
    StateEnum state;

}
