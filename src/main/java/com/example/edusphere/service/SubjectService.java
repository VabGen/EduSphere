package com.example.edusphere.service;

import com.example.edusphere.controller.model.request.SubjectRequest;
import com.example.edusphere.dto.model.SubjectDto;
import com.example.edusphere.model.filter.SubjectFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface SubjectService {

    SubjectDto create(SubjectRequest request);

    List<SubjectDto> findAll();

    SubjectDto edit(SubjectRequest request);

    void delete(UUID id);

    SubjectDto findById(UUID id);

    Page<SubjectDto> findAll(SubjectFilter filter, Pageable pageable);
}
