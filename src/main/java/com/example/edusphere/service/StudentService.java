package com.example.edusphere.service;

import com.example.edusphere.controller.model.request.StudentRequest;
import com.example.edusphere.dao.entity.Student;
import com.example.edusphere.dto.model.StudentDto;

import java.util.List;
import java.util.UUID;

public interface StudentService {

    StudentDto create(StudentRequest request);

    List<StudentDto> read();

    StudentDto update(StudentRequest request);

    void delete(UUID id);

    Student findById(UUID id);
}
