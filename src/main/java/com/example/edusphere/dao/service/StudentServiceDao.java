package com.example.edusphere.dao.service;

import com.example.edusphere.dao.entity.Student;
import com.example.edusphere.model.filter.StudentFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface StudentServiceDao {

    Student create(Student student);

    List<Student> findAll();

    Student edit(Student student);

    void delete(UUID id);

    Student findById(UUID id);

    Page<Student> findAll(StudentFilter filter, Pageable pageable);
}
