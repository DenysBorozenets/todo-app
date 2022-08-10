package com.denis.todoapp.repositories;

import com.denis.todoapp.models.ToDoNote;
import org.springframework.data.repository.CrudRepository;

public interface ToDoNoteRepository extends CrudRepository<ToDoNote, Long> {
}
