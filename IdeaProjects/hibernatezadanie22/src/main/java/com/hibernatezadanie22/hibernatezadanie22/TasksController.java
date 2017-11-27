package com.hibernatezadanie22.hibernatezadanie22;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TasksController {

    @Autowired
    private TasksRepository tasksRepository;

    @GetMapping("/")
    public String getAll(Model model) {
        List<Task> allTasks = tasksRepository.findAll();
        model.addAttribute("taskList", allTasks);
        return "index";
    }

    @GetMapping("/dodajZadanie")
    public String addTask(Model model){
        Task newTask = new Task();
        model.addAttribute("NoweZadanie", newTask);
        return "addTask";
    }

    @PostMapping("/dodajNoweZadanie")
    @RequestMapping
    public String addNewTask(Task fullTask) {
        tasksRepository.save(fullTask);
        return "redirect:/";

    }

    @GetMapping("/listaZadan")
    public String showAll(Model model) {
        List<Task> allTask = tasksRepository.findAll();
        model.addAttribute("taskList", allTask);
        return "tasksList";
    }


}
