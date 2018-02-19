package com.sanscrit.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Интерфейс класса User. Расширяет CrudRepository
 */
@RepositoryRestResource(exported = false)
public interface UserRepository extends CrudRepository<User, Long> {
  /**
   *  Функция осуществляет поиск по username
   * @param username - username Юзера
   * @return - Возвращает Юзера
   */
  User findByUsername(String username);
}
