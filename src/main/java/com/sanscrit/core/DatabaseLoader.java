package com.sanscrit.core;

import com.sanscrit.task.Task;
import com.sanscrit.task.TaskRepository;
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

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Task task = new Task("Do testwork", LocalDate.of(2018, Month.FEBRUARY, 15), false);
        tasks.save(task);
        Task task2 = new Task("Buy smth", LocalDate.of(2018, Month.FEBRUARY, 17), false);
        tasks.save(task2);
        Task task3 = new Task("Read book", LocalDate.of(2018, Month.FEBRUARY, 18), false);
        tasks.save(task3);
    }
}
