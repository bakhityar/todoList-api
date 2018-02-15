package com.sanscrit.task;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TaskController {
  @Autowired
  private TaskRepository tasks;


  public String getPrincipalsName() {
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    String principalsName = ((UserDetails)principal).getUsername();
    return principalsName;
  }

  @GetMapping("/tasks")
  public List<Task> findAll() {
    List<Task> allTasks = (List<Task>) tasks.findAll();
    List<Task> userTasks = new ArrayList<>();
    String principalsName = getPrincipalsName();
    for (Task t: allTasks) {
      if (t.getUser().getUsername().equals(principalsName)) {
        userTasks.add(t);
      }
    }
    return userTasks;
  }

  @GetMapping("/tasks/{id}")
  public Task findById(@PathVariable(value = "id") Long id) {
    Task task = tasks.findOne(id);
    String principalsName = getPrincipalsName();
    if (task.getUser().getUsername().equals(principalsName)) {
      return task;
    } else {
      return null;
    }
  }

}
