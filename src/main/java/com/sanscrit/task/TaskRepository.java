package com.sanscrit.task;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 * Интерфейс класса Task(Задача). Расширяет PagingAndSortingRepository
 */
public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {
    /**
     * Поиск по наименованию задачи
     * @param title - Наименование задачи
     * @param page - страницы
     * @return - Возвращает Задачу
     */
    @RestResource(rel="title-contains", path="containsTitle")
    Page<Task> findByTitleContaining(@Param("title") String title, Pageable page);

    /**
     *  Переписываем метод Delete по id
     *  Аннотация @PreAuthorize проверяет наличие роли Админа или является ли удаляющий автором задачи
     * @param id - id Задачи
     */
    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN') or @taskRepository.findOne(#id)?.user?.username == authentication.name")
    void delete(@Param("id") Long id);

    /**
     * Переписываем метод Delete сущности
     * Аннотация @PreAuthorize проверяет наличие роли Админа или является ли удаляющий автором задачи
     * @param entity - задача (Task)
     */
    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN') or #task.user?.username == authentication.name")
    void delete(@Param("task") Task entity);
}
