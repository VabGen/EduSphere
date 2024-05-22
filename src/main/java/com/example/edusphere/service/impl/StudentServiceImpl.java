package com.example.edusphere.service.impl;

import com.example.edusphere.controller.model.request.StudentRequest;
import com.example.edusphere.dao.entity.Student;
import com.example.edusphere.dto.model.StudentDto;
import com.example.edusphere.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {

    @Override
    public StudentDto create(StudentRequest request) {
        return null;
    }

    @Override
    public List<StudentDto> read() {
        return null;
    }

    @Override
    public StudentDto update(StudentRequest request) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public Student findById(UUID id) {
        return null;
    }
}
