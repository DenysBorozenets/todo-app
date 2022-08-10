package com.denis.todoapp.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "todo_note")
public class ToDoNote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    @Column(name = "is_completed")
    private boolean completed;

    @Getter
    @Setter
    @Column(name = "date_of_creation")
    private Instant dateOfCreation;

    @Getter
    @Setter
    @Column(name = "modified_date")
    private Instant modifiedDate;

    public ToDoNote() {
    }

    public ToDoNote(String description, boolean isCompleted, Instant modifiedDate, Instant completionDate) {
        this.description = description;
        this.completed = false;
        this.dateOfCreation = Instant.now();
        this.modifiedDate = Instant.now();
    }

//    public ToDoNote(String description) {
//        this.description = description;
//    }

    @Override
    public String toString() {
        return "ToDoNote{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", isCompleted=" + completed +
                ", dateOfCreation=" + dateOfCreation +
                ", modifiedDate=" + modifiedDate +
                '}';
    }

}
