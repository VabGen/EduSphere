package com.example.edusphere.dao.service;

import com.example.edusphere.dao.entity.Student;
import com.example.edusphere.dao.entity.Teacher;

import java.util.List;
import java.util.UUID;

public interface TeacherServiceDao {

    Student create(Teacher teacher);

    List<Teacher> read();

    Teacher update(Teacher teacher);

    void delete(UUID id);

    Teacher findById(UUID id);
}
