package com.sanscrit.task;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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

  @GetMapping("/tasks/today")
  public List<Task> findToday() {
    List<Task> allTasks = (List<Task>) tasks.findAll();
    List<Task> userTasksToday = new ArrayList<>();
    String principalsName = getPrincipalsName();
    LocalDate now = LocalDate.now();
    for (Task t: allTasks) {
      if (t.getDate().isEqual(now)) {
        userTasksToday.add(t);
      }
    }
    return userTasksToday;
  }

//  @PostMapping("/tasks")
//  public Task saveTask(Task task) {
//    return tasks.save(task);
//  }

  @GetMapping("/tasks/thisweek")
  public List<Task> findWeek() {
    List<Task> allTasks = (List<Task>) tasks.findAll();
    List<Task> userTasksWeek = new ArrayList<>();
    String principalsName = getPrincipalsName();
    LocalDate now = LocalDate.now();
    WeekFields weekFields = WeekFields.of(Locale.getDefault());
    int weekNum = now.get(weekFields.weekOfWeekBasedYear());
    for (Task t: allTasks) {
      LocalDate dateOfTask = t.getDate();
      WeekFields weekFieldsOfTask = WeekFields.of(Locale.getDefault());
      int weekNumOfTask = dateOfTask.get(weekFieldsOfTask.weekOfWeekBasedYear());
      if (weekNumOfTask == weekNum) {
        userTasksWeek.add(t);
      }
    }
    return userTasksWeek;
  }

}
