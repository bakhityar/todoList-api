package com.sanscrit.core;

import com.sanscrit.task.Task;
import com.sanscrit.task.TaskRepository;
import com.sanscrit.user.User;
import com.sanscrit.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;

/**
 * Загрузка данных в БД
 */
@Component
public class DatabaseLoader implements ApplicationRunner {
    /**
     * Автозаполнение bean-a
     */
    @Autowired
    private TaskRepository tasks;
    /**
     * Автозаполнение bean-a
     */
    @Autowired
    private UserRepository users;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        User user = new User("admin", "Bakhtiyar", "Seidakhmetov", "1441616", new String[] {"ROLE_ADMIN"});
//        users.save(user);
//
//        Task task = new Task("Встретиться с братом", LocalDate.of(2018, Month.FEBRUARY, 22), false);
//        task.setUser(user);
//        tasks.save(task);
//
//        Task task2 = new Task("Купить домой лампу", LocalDate.of(2018, Month.FEBRUARY, 16), true);
//        task2.setUser(user);
//        tasks.save(task2);
//
//        Task task3 = new Task("Обязательно сходить в Мск", LocalDate.of(2018, Month.FEBRUARY, 14), false);
//        task3.setUser(user);
//        tasks.save(task3);
//
//        Task task4 = new Task("Подготовить отчет для Владислава", LocalDate.of(2018, Month.FEBRUARY, 28), false);
//        task4.setUser(user);
//        tasks.save(task4);
//
//        User user2 = new User("user", "Mark", "Newman", "123456", new String[] {"ROLE_USER"});
//        users.save(user2);
//
//        Task task11 = new Task("Дочитать книгу", LocalDate.of(2018, Month.FEBRUARY, 20), false);
//        task11.setUser(user2);
//        tasks.save(task11);
//
//        Task task22 = new Task("Переписать диск на комп", LocalDate.of(2018, Month.FEBRUARY, 13), true);
//        task22.setUser(user2);
//        tasks.save(task22);
//
//        Task task33 = new Task("Розетка в детской", LocalDate.of(2018, Month.FEBRUARY, 17), false);
//        task33.setUser(user2);
//        tasks.save(task33);
//
//        Task task44 = new Task("План на вечер", LocalDate.of(2018, Month.FEBRUARY, 23), false);
//        task44.setUser(user2);
//        tasks.save(task44);
//
//        User user3 = new User("user2", "Airat", "Issayev", "qwerty", new String[] {"ROLE_USER"});
//        users.save(user3);
//
//        Task task111 = new Task("Погулять на свежем воздухе", LocalDate.of(2018, Month.FEBRUARY, 25), true);
//        task111.setUser(user3);
//        tasks.save(task111);
//
//        Task task222 = new Task("Записаться в бассейн", LocalDate.of(2018, Month.FEBRUARY, 26), true);
//        task222.setUser(user3);
//        tasks.save(task222);
//
//        Task task333 = new Task("Поискать хороший самоучитель", LocalDate.of(2018, Month.FEBRUARY, 14), false);
//        task333.setUser(user3);
//        tasks.save(task333);
//
//        Task task444 = new Task("Приготовить одежду для ДР", LocalDate.of(2018, Month.FEBRUARY, 28), false);
//        task444.setUser(user3);
//        tasks.save(task444);
    }
}
