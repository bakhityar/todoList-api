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
//        User user2 = new User("qwerty", "sss", "bbb", "123123", new String[] {"ROLE_USER", "ROLE_ADMIN"});
//        users.save(user2);
//
//        Task task = new Task("Do testwork", LocalDate.of(2018, Month.FEBRUARY, 22), false);
//        task.setUser(user2);
//        tasks.save(task);
//
//        Task task2 = new Task("VVVVVVV", LocalDate.of(2018, Month.FEBRUARY, 16), true);
//        task2.setUser(user2);
//        tasks.save(task2);
//
//        Task task3 = new Task("FFFFFF", LocalDate.of(2018, Month.FEBRUARY, 11), false);
//        task3.setUser(user2);
//        tasks.save(task3);
//
//        Task task4 = new Task("NNNNNNN", LocalDate.of(2018, Month.FEBRUARY, 28), false);
//        task4.setUser(user2);
//        tasks.save(task4);
    }
}
