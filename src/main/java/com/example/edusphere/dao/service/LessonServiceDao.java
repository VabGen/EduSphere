package com.example.edusphere.dao.service;

import com.example.edusphere.dao.entity.Lesson;

import java.util.List;
import java.util.UUID;

public interface LessonServiceDao {

    Lesson create(Lesson lesson);

    List<Lesson> read();

    Lesson update(Lesson lesson);

    void delete(UUID id);

    Lesson findById(UUID id);
}
