package com.example.edusphere.dao.service;

import com.example.edusphere.dao.entity.Lesson;
import com.example.edusphere.model.filter.LessonFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface LessonServiceDao {

    Lesson create(Lesson lesson);

    List<Lesson> findAll();

    Lesson edit(Lesson lesson);

    void delete(UUID id);

    Lesson findById(UUID id);

    Page<Lesson> findAll(LessonFilter filter, Pageable pageable);
}
