package com.example.edusphere.service.impl;

import com.example.edusphere.controller.model.request.TeacherRequest;
import com.example.edusphere.dao.entity.Teacher;
import com.example.edusphere.dao.service.TeacherServiceDao;
import com.example.edusphere.dao.specification.TeacherSpecification.FetchType;
import com.example.edusphere.dto.mapper.TeacherMapper;
import com.example.edusphere.dto.model.TeacherDto;
import com.example.edusphere.model.filter.TeacherFilter;
import com.example.edusphere.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherServiceDao teacherDAO;

    @Autowired
    public TeacherServiceImpl(TeacherServiceDao teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TeacherDto create(TeacherRequest request) {
        Teacher teacher = TeacherMapper.requestToEntity(request, new Teacher());
        teacherDAO.create(teacher);
        return TeacherMapper.entityToDto(teacher);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TeacherDto> findAll() {
        List<Teacher> teachers = teacherDAO.findAll();
        return teachers.stream().map(TeacherMapper::entityToDto).collect(Collectors.toList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TeacherDto edit(TeacherRequest request) {
        Teacher teacher = teacherDAO.findById(request.getId());
        if (teacher == null) {
            throw new RuntimeException("Teacher not found");
        }

        TeacherMapper.requestToEntity(request, teacher);
        teacherDAO.update(teacher);
        return TeacherMapper.entityToDto(teacher);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(UUID id) {
        teacherDAO.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public TeacherDto findById(UUID id) {
        Teacher teacher = teacherDAO.findById(id);
        return TeacherMapper.entityToDto(teacher, FetchType.GROUP);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<TeacherDto> findAll(TeacherFilter filter, Pageable pageable) {
        Page<Teacher> teacherPage = teacherDAO.findAll(filter, pageable);
        return teacherPage.map(e -> TeacherMapper.entityToDto(e, filter.getFetches()));
    }
}
