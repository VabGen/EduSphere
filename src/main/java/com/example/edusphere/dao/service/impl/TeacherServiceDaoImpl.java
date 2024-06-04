package com.example.edusphere.dao.service.impl;

import com.example.edusphere.dao.entity.Teacher;
import com.example.edusphere.dao.repository.TeacherRepository;
import com.example.edusphere.dao.service.TeacherServiceDao;
import com.example.edusphere.dao.specification.TeacherSpecification;
import com.example.edusphere.model.filter.TeacherFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class TeacherServiceDaoImpl implements TeacherServiceDao {

    private final TeacherRepository repository;
    private final TeacherSpecification spec;

    @Autowired
    public TeacherServiceDaoImpl(TeacherRepository repository, TeacherSpecification spec) {
        this.repository = repository;
        this.spec = spec;
    }

    @Override
    @Transactional
    public Teacher create(Teacher entity) {
        return repository.save(entity);
    }

    @Override
    public List<Teacher> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Teacher update(Teacher entity) {
        return repository.save(entity);
    }

    @Override
    public Teacher findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public Page<Teacher> findAll(TeacherFilter filter, Pageable pageable) {
        return repository.findAll(spec.filterByCriteria(filter), pageable);
    }
}
