package com.sanscrit.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.validation.Validator;

/**
 * Класс, активирующий валидацию объектов
 */
@Configuration
public class RestConfig extends RepositoryRestConfigurerAdapter {
  /**
   * Автозаполнение bean-a
   */
  @Autowired
  private Validator validator;

  /**
   * Функция, валидирующая данные перед созданием и перед сохраненем
   * @param validatingListener - параметр ValidatingRepositoryEventListener
   */
  @Override
  public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener validatingListener) {
    validatingListener.addValidator("beforeCreate", validator);
    validatingListener.addValidator("beforeSave", validator);
  }
}
