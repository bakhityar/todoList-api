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

@Component
public class DatabaseLoader implements ApplicationRunner {
    @Autowired
    private TaskRepository tasks;

    @Autowired
    private UserRepository users;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        User user = new User("admin", "sss", "bbb", "123", new String[] {"ROLE_ADMIN"});
//        users.save(user);
//
//        Task task = new Task("ADM Do testwork", LocalDate.of(2018, Month.FEBRUARY, 22), false);
//        task.setUser(user);
//        tasks.save(task);
//
//        Task task2 = new Task("ADM VVVVVVV", LocalDate.of(2018, Month.FEBRUARY, 16), true);
//        task2.setUser(user);
//        tasks.save(task2);
//
//        Task task3 = new Task("ADM FFFFFF", LocalDate.of(2018, Month.FEBRUARY, 14), false);
//        task3.setUser(user);
//        tasks.save(task3);
//
//        Task task4 = new Task("ADM NNNNNNN", LocalDate.of(2018, Month.FEBRUARY, 28), false);
//        task4.setUser(user);
//        tasks.save(task4);
//
//        User user2 = new User("user", "sss", "bbb", "123", new String[] {"ROLE_USER"});
//        users.save(user2);
//
//        Task task11 = new Task("USR Do testwork", LocalDate.of(2018, Month.FEBRUARY, 22), false);
//        task11.setUser(user2);
//        tasks.save(task11);
//
//        Task task22 = new Task("USR VVVVVVV", LocalDate.of(2018, Month.FEBRUARY, 16), true);
//        task22.setUser(user2);
//        tasks.save(task22);
//
//        Task task33 = new Task("USR FFFFFF", LocalDate.of(2018, Month.FEBRUARY, 11), false);
//        task33.setUser(user2);
//        tasks.save(task33);
//
//        Task task44 = new Task("USR NNNNNNN", LocalDate.of(2018, Month.FEBRUARY, 28), false);
//        task44.setUser(user2);
//        tasks.save(task44);
    }
}
