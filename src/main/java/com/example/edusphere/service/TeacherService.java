package com.example.edusphere.service;

import com.example.edusphere.controller.model.request.TeacherRequest;
import com.example.edusphere.dao.entity.Student;
import com.example.edusphere.dao.entity.Teacher;
import com.example.edusphere.dto.model.TeacherDto;

import java.util.List;
import java.util.UUID;

public interface TeacherService {

    TeacherDto create(TeacherRequest request);

    List<TeacherDto> read();

    TeacherDto update(TeacherRequest request);

    void delete(UUID id);

    TeacherDto findById(UUID id);
}
