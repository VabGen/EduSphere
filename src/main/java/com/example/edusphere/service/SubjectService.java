package com.example.edusphere.service;

import com.example.edusphere.controller.model.request.SubjectRequest;
import com.example.edusphere.dao.entity.Lesson;
import com.example.edusphere.dao.entity.Subject;
import com.example.edusphere.dto.model.SubjectDto;

import java.util.List;
import java.util.UUID;

public interface SubjectService {

    SubjectDto create(SubjectRequest request);

    List<SubjectDto> read();

    SubjectDto update(SubjectRequest request);

    void delete(UUID id);

    SubjectDto findById(UUID id);
}
