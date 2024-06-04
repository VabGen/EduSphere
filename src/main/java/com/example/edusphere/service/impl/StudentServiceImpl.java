package com.example.edusphere.service.impl;

import com.example.edusphere.controller.model.request.StudentRequest;
import com.example.edusphere.dao.entity.Student;
import com.example.edusphere.dao.service.StudentServiceDao;
import com.example.edusphere.dto.mapper.StudentMapper;
import com.example.edusphere.dto.model.StudentDto;
import com.example.edusphere.model.filter.StudentFilter;
import com.example.edusphere.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentServiceDao studentDAO;

    @Autowired
    public StudentServiceImpl(StudentServiceDao studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public StudentDto create(StudentRequest request) {
        Student student = StudentMapper.requestToEntity(request, new Student());
        studentDAO.create(student);
        return StudentMapper.entityToDto(student);
    }

    @Override
    @Transactional(readOnly = true)
    public List<StudentDto> findAll() {
        List<Student> students = studentDAO.findAll();
        return students.stream().map(StudentMapper::entityToDto).collect(Collectors.toList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public StudentDto edit(StudentRequest request) {
        Student student = studentDAO.findById(request.getId());
        if (student == null) {
            throw new RuntimeException("Student not found");
        }

        StudentMapper.requestToEntity(request, student);
        studentDAO.edit(student);
        return StudentMapper.entityToDto(student);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(UUID id) {
        studentDAO.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public StudentDto findById(UUID id) {
        Student student = studentDAO.findById(id);
        return StudentMapper.entityToDto(student);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<StudentDto> findAll(StudentFilter filter, Pageable pageable) {
        Page<Student> studentPage = studentDAO.findAll(filter, pageable);
        return studentPage.map(e -> StudentMapper.entityToDto(e, filter.getFetches()));
    }
}
