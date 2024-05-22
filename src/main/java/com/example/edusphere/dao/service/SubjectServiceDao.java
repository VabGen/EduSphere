package com.example.edusphere.dao.service;

import com.example.edusphere.dao.entity.Lesson;
import com.example.edusphere.dao.entity.Subject;

import java.util.List;
import java.util.UUID;

public interface SubjectServiceDao {

    Lesson create(Subject subject);

    List<Subject> read();

    Subject update(Subject subject);

    void delete(UUID id);

    Subject findById(UUID id);
}
