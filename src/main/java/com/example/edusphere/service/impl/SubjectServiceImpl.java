package com.example.edusphere.service.impl;

import com.example.edusphere.controller.model.request.SubjectRequest;
import com.example.edusphere.dao.entity.Subject;
import com.example.edusphere.dto.model.SubjectDto;
import com.example.edusphere.service.SubjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Override
    public SubjectDto create(SubjectRequest request) {
        return null;
    }

    @Override
    public List<SubjectDto> read() {
        return null;
    }

    @Override
    public SubjectDto update(SubjectRequest request) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public SubjectDto findById(UUID id) {
        return null;
    }
}
