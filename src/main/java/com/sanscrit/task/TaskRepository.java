package com.sanscrit.task;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.prepost.PreAuthorize;

public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {

    @RestResource(rel="title-contains", path="containsTitle")
    Page<Task> findByTitleContaining(@Param("title") String title, Pageable page);

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN') or @taskRepository.findOne(#id)?.user?.username == authentication.name")
    void delete(@Param("id") Long id);

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN') or #task.user?.username == authentication.name")
    void delete(@Param("task") Task entity);
}
