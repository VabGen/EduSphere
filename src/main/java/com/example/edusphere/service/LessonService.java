package com.example.edusphere.service;

import com.example.edusphere.controller.model.request.LessonRequest;
import com.example.edusphere.dto.model.LessonDto;

import java.util.List;
import java.util.UUID;

public interface LessonService {

    LessonDto create(LessonRequest request);

    List<LessonDto> read();

    LessonDto update(LessonRequest request);

    void delete(UUID id);

    LessonDto findById(UUID id);
}
