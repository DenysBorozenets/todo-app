package com.denis.todoapp.controllers;

import com.denis.todoapp.repositories.ToDoNoteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

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
}
