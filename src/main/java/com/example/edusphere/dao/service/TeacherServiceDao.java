package com.example.edusphere.dao.service;

import com.example.edusphere.dao.entity.Teacher;
import com.example.edusphere.model.filter.TeacherFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface TeacherServiceDao {

    Teacher create(Teacher teacher);

    List<Teacher> findAll();

    Teacher update(Teacher teacher);

    void delete(UUID id);

    Teacher findById(UUID id);

    Page<Teacher> findAll(TeacherFilter filter, Pageable pageable);
}
