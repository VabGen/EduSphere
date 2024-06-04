package com.example.edusphere.dao.service.impl;

import com.example.edusphere.dao.entity.Lesson;
import com.example.edusphere.dao.repository.LessonRepository;
import com.example.edusphere.dao.service.LessonServiceDao;
import com.example.edusphere.dao.specification.LessonSpecification;
import com.example.edusphere.model.filter.LessonFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class LessonServiceDaoImpl implements LessonServiceDao {

    private final LessonRepository repository;
    private final LessonSpecification spec;

    @Autowired
    public LessonServiceDaoImpl(LessonRepository repository, LessonSpecification spec) {
        this.repository = repository;
        this.spec = spec;
    }

    @Override
    @Transactional
    public Lesson create(Lesson entity) {
        return repository.save(entity);
    }

    @Override
    public List<Lesson> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Lesson edit(Lesson entity) {
        return repository.save(entity);
    }

    @Override
    public Lesson findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lesson not found"));
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public Page<Lesson> findAll(LessonFilter filter, Pageable pageable) {
        return repository.findAll(spec.filterByCriteria(filter), pageable);
    }
}