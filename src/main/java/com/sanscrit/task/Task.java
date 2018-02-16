package com.sanscrit.task;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import com.sanscrit.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Task {

    interface Details {
    }
    interface AdminDetails {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView({Details.class})
    private Long id;
    @NotNull
    @JsonView({Details.class})
    private String title;
    @NotNull
    @JsonView({Details.class})
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    @NotNull
    @JsonView({Details.class})
    private boolean status;
    @NotNull
    @JsonView({AdminDetails.class})
    @ManyToOne
    private User user;

    public Task() {};

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
