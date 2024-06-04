package com.example.edusphere.dao.service.impl;

import com.example.edusphere.dao.entity.Student;
import com.example.edusphere.dao.repository.StudentRepository;
import com.example.edusphere.dao.service.StudentServiceDao;
import com.example.edusphere.dao.specification.StudentSpecification;
import com.example.edusphere.model.filter.StudentFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class StudentServiceDaoImpl implements StudentServiceDao {

    private final StudentRepository repository;
    private final StudentSpecification spec;

    @Autowired
    public StudentServiceDaoImpl(StudentRepository repository, StudentSpecification spec) {
        this.repository = repository;
        this.spec = spec;
    }

    @Override
    @Transactional
    public Student create(Student entity) {
        return repository.save(entity);
    }

    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Student edit(Student entity) {
        return repository.save(entity);
    }

    @Override
    public Student findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public Page<Student> findAll(StudentFilter filter, Pageable pageable) {
        return repository.findAll(spec.filterByCriteria(filter), pageable);
    }
}
