package Bezos.TaskManager.Controllers;

import Bezos.TaskManager.Models.Task;
import Bezos.TaskManager.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public String listTasks(Model model) {
        model.addAttribute("tasks", taskService.findAllTasks());
        return "task/list";
    }

    @GetMapping("/{id}")
    public String viewTask(@PathVariable Long id, Model model) {
        Optional<Task> task = taskService.findTaskById(id);
        if (task.isPresent()) {
            model.addAttribute("task", task.get());
            return "task/view";
        } else {
            return "redirect:/tasks";
        }
    }

    @GetMapping("/new")
    public String newTaskForm(Model model) {
        model.addAttribute("task", new Task());
        return "task/form";
    }

    @PostMapping
    public String saveTask(@ModelAttribute Task task) {
        taskService.saveTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/edit/{id}")public String editTaskForm(@PathVariable Long id, Model model) {
        Optional<Task> task = taskService.findTaskById(id);
        if (task.isPresent()) {
            model.addAttribute("task", task.get());
            return"task/edit";
        } else {
            return"redirect:/tasks";
        }
    }

    @PostMapping("/update")public String updateTask(@ModelAttribute Task task) {
        taskService.saveTask(task);
        return"redirect:/tasks";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }
}
