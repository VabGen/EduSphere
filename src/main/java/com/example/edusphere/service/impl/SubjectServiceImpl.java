package com.example.edusphere.service.impl;

import com.example.edusphere.controller.model.request.SubjectRequest;
import com.example.edusphere.dao.entity.Subject;
import com.example.edusphere.dao.service.SubjectServiceDao;
import com.example.edusphere.dao.specification.SubjectSpecification.FetchType;
import com.example.edusphere.dto.mapper.SubjectMapper;
import com.example.edusphere.dto.model.SubjectDto;
import com.example.edusphere.model.filter.SubjectFilter;
import com.example.edusphere.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectServiceDao subjectDAO;

    @Autowired
    public SubjectServiceImpl(SubjectServiceDao subjectDAO) {
        this.subjectDAO = subjectDAO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public SubjectDto create(SubjectRequest request) {
        Subject subject = SubjectMapper.requestToEntity(request, new Subject());
        subjectDAO.create(subject);
        return SubjectMapper.entityToDto(subject);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SubjectDto> findAll() {
        List<Subject> subjects = subjectDAO.findAll();
        return subjects.stream().map(SubjectMapper::entityToDto).collect(Collectors.toList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public SubjectDto edit(SubjectRequest request) {
        Subject subject = subjectDAO.findById(request.getId());
        if (subject == null) {
            throw new RuntimeException("Subject not found");
        }

        SubjectMapper.requestToEntity(request, subject);
        subjectDAO.edit(subject);
        return SubjectMapper.entityToDto(subject);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(UUID id) {
        subjectDAO.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public SubjectDto findById(UUID id) {
        Subject subject = subjectDAO.findById(id);
        return SubjectMapper.entityToDto(subject, FetchType.LESSON);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<SubjectDto> findAll(SubjectFilter filter, Pageable pageable) {
        Page<Subject> subjectPage = subjectDAO.findAll(filter, pageable);
        return subjectPage.map(e -> SubjectMapper.entityToDto(e, filter.getFetches()));
    }
}
