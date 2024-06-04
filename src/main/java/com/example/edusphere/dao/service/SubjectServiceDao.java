package com.example.edusphere.dao.service;

import com.example.edusphere.dao.entity.Subject;
import com.example.edusphere.model.filter.SubjectFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface SubjectServiceDao {

    Subject create(Subject subject);

    List<Subject> findAll();

    Subject edit(Subject subject);

    void delete(UUID id);

    Subject findById(UUID id);

    Page<Subject> findAll(SubjectFilter filter, Pageable pageable);
}
