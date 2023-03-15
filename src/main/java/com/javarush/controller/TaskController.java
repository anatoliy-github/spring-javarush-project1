package com.javarush.controller;

import com.javarush.dao.TaskDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javarush.domain.Task;

import java.util.List;

@Controller
public class TaskController {
    private final TaskDAO taskDAO;

    public TaskController(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    @RequestMapping("/")
    public String showAllTasks(Model model) {
        List<Task> allTasks = taskDAO.getAll();
        model.addAttribute("allTasks", allTasks);
        return "index";
    }
}
