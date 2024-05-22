package com.example.edusphere.dao.service;

import com.example.edusphere.dao.entity.Group;

import java.util.List;
import java.util.UUID;

public interface GroupServiceDao {

    Group create(Group group);

    List<Group> read();

    Group update(Group group);

    void delete(UUID id);

    Group findById(UUID id);

//    List<Group> filter(GroupFilter filter, Pageable pageable);
}
