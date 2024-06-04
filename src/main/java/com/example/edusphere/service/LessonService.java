package com.example.edusphere.service;

import com.example.edusphere.controller.model.request.LessonRequest;
import com.example.edusphere.dto.model.LessonDto;
import com.example.edusphere.model.filter.LessonFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface LessonService {

    LessonDto create(LessonRequest request);

    List<LessonDto> findAll();

    LessonDto edit(LessonRequest request);

    void delete(UUID id);

    LessonDto findById(UUID id);

    Page<LessonDto> findAll(LessonFilter filter, Pageable pageable);
}
