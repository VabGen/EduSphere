package com.example.edusphere.service;

import com.example.edusphere.controller.model.request.StudentRequest;
import com.example.edusphere.dto.model.StudentDto;
import com.example.edusphere.model.filter.StudentFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface StudentService {

    StudentDto create(StudentRequest request);

    List<StudentDto> findAll();

    StudentDto edit(StudentRequest request);

    void delete(UUID id);

    StudentDto findById(UUID id);

    Page<StudentDto> findAll(StudentFilter filter, Pageable pageable);
}
