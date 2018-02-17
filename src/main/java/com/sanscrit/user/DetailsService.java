package com.sanscrit.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Реализация UserDetailsService
 */
@Component
public class DetailsService  implements UserDetailsService{
  /**
   * Автозаполнение bean-a
   */
  @Autowired
  private UserRepository users;

  /**
   * Функция поиска и загрузки Юзера для Spring Security
   * @param username - username Юзера
   * @return - Возвращает Юзера со всеми необходимыми атрибутами
   * @throws UsernameNotFoundException - Исключение не найденного пользователя
   */
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = users.findByUsername(username);
    if (user == null) {
      throw new UsernameNotFoundException(username + " was not found");
    }
    return new org.springframework.security.core.userdetails.User(
        user.getUsername(),
        user.getPassword(),
        AuthorityUtils.createAuthorityList(user.getRoles())
    );
  }
}
