package com.denis.todoapp.config;

import com.denis.todoapp.models.ToDoNote;
import com.denis.todoapp.repositories.ToDoNoteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ToDoNoteDataLoader implements CommandLineRunner {
    private final Logger log = LoggerFactory.getLogger(ToDoNoteDataLoader.class);

    @Autowired
    ToDoNoteRepository toDoNoteRepository;

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {
        if (toDoNoteRepository.count() == 0) {
            ToDoNote toDoNote = new ToDoNote("Do smth");
            ToDoNote toDoNote2 = new ToDoNote("Make smth");

            toDoNoteRepository.save(toDoNote);
            toDoNoteRepository.save(toDoNote2);
        }

        log.info("Number of note: {}", toDoNoteRepository.count());
    }
}
