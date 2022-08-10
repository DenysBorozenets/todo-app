package com.denis.todoapp.controllers;

import com.denis.todoapp.models.ToDoNote;
import com.denis.todoapp.repositories.ToDoNoteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.Instant;

@Controller
public class ToDoMainController {

    private final Logger log = LoggerFactory.getLogger(ToDoMainController.class);

    @Autowired
    private ToDoNoteRepository toDoNoteRepository;

    @GetMapping("/")
    public ModelAndView index() {
        log.debug("request for GET index page");
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("toDoNotes", toDoNoteRepository.findAll());
        return modelAndView;
    }

    @PostMapping("toDoNote/{id}")
    public String updateNote(@PathVariable("id") long id,
                             @Valid ToDoNote toDoNote,
                             BindingResult result,
                             Model model) {
        if (result.hasErrors()) {
            toDoNote.setId(id);
            return "operation-edit-form";
        }
        toDoNote.setModifiedDate(Instant.now());
        toDoNoteRepository.save(toDoNote);
        return "redirect:/";
    }

    @PostMapping("/todo")
    public String createNote(@Valid ToDoNote toDoNote,
                             BindingResult result,
                             Model model) {
        if (result.hasErrors()) {
            return "add-note";
        }
        toDoNote.setDateOfCreation(Instant.now());
        toDoNote.setModifiedDate(Instant.now());

        toDoNoteRepository.save(toDoNote);
        return "redirect:/";

    }
}
