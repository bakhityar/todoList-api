package com.sanscrit.task;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {

    @RestResource(rel="title-contains", path="containsTitle")
    Page<Task> findByTitleContaining(@Param("title") String title, Pageable page);
}
