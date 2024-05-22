package com.example.edusphere.service.impl;

import com.example.edusphere.controller.model.request.TeacherRequest;
import com.example.edusphere.dto.model.TeacherDto;
import com.example.edusphere.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Override
    public TeacherDto create(TeacherRequest request) {
        return null;
    }

    @Override
    public List<TeacherDto> read() {
        return null;
    }

    @Override
    public TeacherDto update(TeacherRequest request) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public TeacherDto findById(UUID id) {
        return null;
    }
}
