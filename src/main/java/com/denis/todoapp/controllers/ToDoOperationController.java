package com.denis.todoapp.controllers;

import com.denis.todoapp.models.ToDoNote;
import com.denis.todoapp.repositories.ToDoNoteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ToDoOperationController {
    private final Logger log = LoggerFactory.getLogger(ToDoOperationController.class);

    @Autowired
    ToDoNoteRepository toDoNoteRepository;

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") long id, Model model) {
        ToDoNote note = toDoNoteRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ToDoNote id: " + id + "Not found"));

        model.addAttribute("toDoNote", note);
        return "operation-edit-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteNote(@PathVariable("id") long id, Model model) {
        ToDoNote note = toDoNoteRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ToDoNote id: " + id + "Not found"));
        toDoNoteRepository.delete(note);
        return "redirect:/";
    }
}
