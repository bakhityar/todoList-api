package com.sanscrit.task;

import com.sanscrit.user.User;
import com.sanscrit.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Обработчик событий класса Task
 */
@Component
@RepositoryEventHandler(Task.class)
public class TaskEventHandler {
  /**
   * Автозаполнение bean-a
   */
  @Autowired
  private UserRepository users;

  /**
   * Вместе с аннотацией @HandleBeforeCreate Функция присваивает новой задаче создающего ее Юзера
   * @param task - Задача (Task.class)
   */
  @HandleBeforeCreate
  public void addTaskBasedOnLoggedInUser(Task task) {
    String username = SecurityContextHolder.getContext().getAuthentication().getName();
    User user = users.findByUsername(username);
    task.setUser(user);
  }
}
