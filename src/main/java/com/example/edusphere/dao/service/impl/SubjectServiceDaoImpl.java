package com.example.edusphere.dao.service.impl;

import com.example.edusphere.dao.entity.Subject;
import com.example.edusphere.dao.repository.SubjectRepository;
import com.example.edusphere.dao.service.SubjectServiceDao;
import com.example.edusphere.dao.specification.SubjectSpecification;
import com.example.edusphere.model.filter.SubjectFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class SubjectServiceDaoImpl implements SubjectServiceDao {

    private final SubjectRepository repository;
    private final SubjectSpecification spec;

    @Autowired
    public SubjectServiceDaoImpl(SubjectRepository repository, SubjectSpecification spec) {
        this.repository = repository;
        this.spec = spec;
    }

    @Override
    @Transactional
    public Subject create(Subject entity) {
        return repository.save(entity);
    }

    @Override
    public List<Subject> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Subject edit(Subject entity) {
        return repository.save(entity);
    }

    @Override
    public Subject findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subject not found"));
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public Page<Subject> findAll(SubjectFilter filter, Pageable pageable) {
        return repository.findAll(spec.filterByCriteria(filter), pageable);
    }
}
