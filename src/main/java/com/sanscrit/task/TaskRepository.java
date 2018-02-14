package com.sanscrit.task;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {

    @RestResource(rel="title-contains", path="containsTitle")
    Page<Task> findByTitleContaining(@Param("title") String title, Pageable page);

    @Query("select t from Task t where t.user.id=:#{principal.id}")
    List<Task> findAll();
}
