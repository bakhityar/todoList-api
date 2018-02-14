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
//        User user1 = new User("qwerty1", "sss", "bbb", "123123", new String[] {"ROLE_USER", "ROLE_ADMIN"});
//        users.save(user1);
//
//        Task task = new Task("Do testwork", LocalDate.of(2018, Month.FEBRUARY, 15), false);
//        task.setUser(user1);
//        tasks.save(task);
//        Task task2 = new Task("VVVVVVV", LocalDate.of(2018, Month.FEBRUARY, 15), true);
//        task2.setUser(user1);
//        tasks.save(task2);
//        Task task3 = new Task("FFFFFF", LocalDate.of(2018, Month.FEBRUARY, 17), false);
//        task3.setUser(user1);
//        tasks.save(task3);
//        Task task4 = new Task("NNNNNNN", LocalDate.of(2018, Month.FEBRUARY, 19), false);
//        task4.setUser(user1);
//        tasks.save(task4);

    }
}
