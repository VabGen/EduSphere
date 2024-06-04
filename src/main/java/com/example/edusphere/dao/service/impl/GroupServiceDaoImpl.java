package com.example.edusphere.dao.service.impl;

import com.example.edusphere.dao.entity.Group;
import com.example.edusphere.dao.repository.GroupRepository;
import com.example.edusphere.dao.service.GroupServiceDao;
import com.example.edusphere.dao.specification.GroupSpecification;
import com.example.edusphere.model.filter.GroupFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class GroupServiceDaoImpl implements GroupServiceDao {

    private final GroupRepository repository;
    private final GroupSpecification spec;

    @Autowired
    public GroupServiceDaoImpl(GroupRepository repository, GroupSpecification spec) {
        this.repository = repository;
        this.spec = spec;
    }

    @Override
    @Transactional
    public Group create(Group entity) {
        return repository.save(entity);
    }

    @Override
    public List<Group> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Group edit(Group entity) {
        return repository.save(entity);
    }

    @Override
    public Group findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Group not found"));
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public Page<Group> findAll(GroupFilter filter, Pageable pageable) {
        return repository.findAll(spec.filterByCriteria(filter), pageable);
    }
}
