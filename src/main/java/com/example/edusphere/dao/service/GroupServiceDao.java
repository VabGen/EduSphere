package com.example.edusphere.dao.service;

import com.example.edusphere.dao.entity.Group;
import com.example.edusphere.model.filter.GroupFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface GroupServiceDao {

    Group create(Group group);

    List<Group> findAll();

    Group edit(Group group);

    void delete(UUID id);

    Group findById(UUID id);

    Page<Group> findAll(GroupFilter filter, Pageable pageable);
}
