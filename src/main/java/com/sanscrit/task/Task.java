package com.sanscrit.task;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import com.sanscrit.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * Класс Task(Задача) со свойствами <b>id</b>, <b>title</b>, <b>date</b>, <b>status</b>, <b>user</b>
 * @autor Бахтияр Сейдахметов
 * @version 2.1
 */
@Entity
public class Task {
    /**
     * Интерфейс определяющий данные, передающиеся в JSON для обычного пользователя
     */
    interface Details {
    }

    /**
     * Интерфейс определяющий данные, передающиеся в JSON для администратора
     */
    interface AdminDetails {
    }

    /**Свойство - id(идентификатор) задачи*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView({Details.class})
    private Long id;
    /**Свойство - Наименование задачи*/
    @NotNull
    @JsonView({Details.class})
    private String title;
    /**Свойство - Дата выполнения задачи*/
    @NotNull
    @JsonView({Details.class})
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    /**Свойство - Статус (boolean) задачи*/
    @NotNull
    @JsonView({Details.class})
    private boolean status;
    /**Свойство - Автор задачи*/
    @NotNull
    @JsonView({AdminDetails.class})
    @ManyToOne
    private User user;

    /**
     * Конструктор для создания пустого объекта. Использует Spring
     */
    public Task() {};

    /**
     * Конструктор для создания объекта с заданными параметрами
     * @param title - наименование
     * @param date - дата
     * @param status - статус
     */
    public Task(String title, LocalDate date, boolean status) {
        this.title = title;
        this.date = date;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
