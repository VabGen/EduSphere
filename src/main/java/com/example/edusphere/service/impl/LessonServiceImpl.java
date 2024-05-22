package com.example.edusphere.service.impl;

import com.example.edusphere.controller.model.request.LessonRequest;
import com.example.edusphere.dao.entity.Lesson;
import com.example.edusphere.dto.model.LessonDto;
import com.example.edusphere.service.LessonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LessonServiceImpl implements LessonService {

    @Override
    public LessonDto create(LessonRequest request) {
        return null;
    }

    @Override
    public List<LessonDto> read() {
        return null;
    }

    @Override
    public LessonDto update(LessonRequest request) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public LessonDto findById(UUID id) {
        return null;
    }
}
