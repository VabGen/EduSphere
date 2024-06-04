package com.example.edusphere.service;

import com.example.edusphere.controller.model.request.TeacherRequest;
import com.example.edusphere.dto.model.TeacherDto;
import com.example.edusphere.model.filter.TeacherFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface TeacherService {

    TeacherDto create(TeacherRequest request);

    List<TeacherDto> findAll();

    TeacherDto edit(TeacherRequest request);

    void delete(UUID id);

    TeacherDto findById(UUID id);

    Page<TeacherDto> findAll(TeacherFilter filter, Pageable pageable);
}
