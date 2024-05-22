package com.example.edusphere.dao.service;

import com.example.edusphere.dao.entity.Student;

import java.util.List;
import java.util.UUID;

public interface StudentServiceDao {

    Student create(Student student);

    List<Student> read();

    Student update(Student student);

    void delete(UUID id);

    Student findById(UUID id);
}
