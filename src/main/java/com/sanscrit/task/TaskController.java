package com.sanscrit.task;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Контроллер, обрабатывающий запросы
 */
@RestController
@RequestMapping("/api/v1")
public class TaskController {
  /**
   * Автозаполнение bean-a
   */
  @Autowired
  private TaskRepository tasks;

  /**
   * Функция возвращающая имя действующего пользователя
   * @return - имя пользвателя
   */
  public String getPrincipalsName() {
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    String principalsName = ((UserDetails)principal).getUsername();
    return principalsName;
  }

  /**
   * Функция поиска всех задач на сегодня автора запроса
   * @return - список задач
   */
  @JsonView(Task.Details.class)
  @GetMapping("/tasks/today")
  public List<Task> findToday() {
    List<Task> allTasks = (List<Task>) tasks.findAll();
    List<Task> userTasksToday = new ArrayList<>();
    String principalsName = getPrincipalsName();
    LocalDate now = LocalDate.now();
    for (Task t: allTasks) {
      if ( (t.getUser().getUsername().equals(principalsName)) && (t.getDate().isEqual(now) ) ){
        userTasksToday.add(t);
      }
    }
    return userTasksToday;
  }

  /**
   * Функция поиска всех задач на сегодняшний день. Доступна для пользователей с ролью Админа
   * @return - список задач
   */
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @JsonView(Task.Details.class)
  @GetMapping("/tasks/alltoday")
  public List<Task> findTodayAll() {
    List<Task> allTasks = (List<Task>) tasks.findAll();
    List<Task> userTasksToday = new ArrayList<>();
    String principalsName = getPrincipalsName();
    LocalDate now = LocalDate.now();
    for (Task t: allTasks) {
      if (t.getDate().isEqual(now)){
        userTasksToday.add(t);
      }
    }
    return userTasksToday;
  }

  /**
   * Функция поиска всех задач на неделю автора запроса
   * @return - список задач
   */
  @JsonView(Task.Details.class)
  @GetMapping("/tasks/thisweek")
  public List<Task> findWeek() {
    List<Task> allTasks = (List<Task>) tasks.findAll();
    List<Task> userTasksWeek = new ArrayList<>();
    String principalsName = getPrincipalsName();
    LocalDate now = LocalDate.now();
    //Поиск номера недели
    WeekFields weekFields = WeekFields.of(Locale.getDefault());
    int weekNum = now.get(weekFields.weekOfWeekBasedYear());
    for (Task t: allTasks) {
      LocalDate dateOfTask = t.getDate();
      WeekFields weekFieldsOfTask = WeekFields.of(Locale.getDefault());
      int weekNumOfTask = dateOfTask.get(weekFieldsOfTask.weekOfWeekBasedYear());
      if ( (t.getUser().getUsername().equals(principalsName)) && (weekNumOfTask == weekNum) ) {
        userTasksWeek.add(t);
      }
    }
    return userTasksWeek;
  }

  /**
   * Функция изменения статуса задачи
   * @param id - id задачи
   * @return задача с измененным статусом
   */
  @JsonView(Task.Details.class)
  @PostMapping("/tasks/{id}/changestatus")
  public Task changeStatus(@PathVariable Long id) {
    Task task = tasks.findOne(id);
    String principalsName = getPrincipalsName();
    if (task.getUser().getUsername().equals(principalsName) ){
        task.setStatus(!task.isStatus());
        tasks.save(task);
      }
    return task;
  }
}
