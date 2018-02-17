package com.sanscrit.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Класс User со свойствами <b>id</b>, <b>firstName</b>, <b>lastName</b>, <b>username</b>, <b>password</b>, <b>roles</b>
 * @autor Бахтияр Сейдахметов
 * @version 2.1
 */
@Entity
public class User {
  /**Свойство - id(идентификатор) Юзера*/
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  /**Свойство - имя Юзера*/
  private String firstName;
  /**Свойство - фамилия Юзера*/
  private String lastName;
  @NotNull
  /**Свойство - username Юзера*/
  @Column(unique = true)
  private String username;
  /**Свойство - пароль Юзера*/
  @NotNull
  @JsonIgnore
  private String password;
  /**Свойство - роли Юзера*/
  @NotNull
  @JsonIgnore
  private String[] roles;

  /**
   * Конструктор для создания пустого объекта. Использует Spring
   */
  public User() {};

  /**
   * Конструктор для создания объекта с заданными параметрами
   * @param username - username Юзера
   * @param firstName - имя Юзера
   * @param lastName - фамилия Юзера
   * @param password - пароль
   * @param roles - роли Юзера
   */
  public User(String username, String firstName, String lastName, String password, String[] roles) {
    this();
    this.firstName = firstName;
    this.lastName = lastName;
    this.username = username;
    this.password = password;
    this.roles = roles;
  }

  public Long getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String[] getRoles() {
    return roles;
  }

  public void setRoles(String[] roles) {
    this.roles = roles;
  }
}
