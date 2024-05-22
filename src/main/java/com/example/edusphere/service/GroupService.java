package com.example.edusphere.service;

import com.example.edusphere.controller.model.request.GroupRequest;
import com.example.edusphere.dao.entity.Group;
import com.example.edusphere.dto.model.GroupDto;

import java.util.List;
import java.util.UUID;

public interface GroupService {

    GroupDto create(GroupRequest request);

    List<GroupDto> read();

    GroupDto update(GroupRequest request);

    void delete(UUID id);

    Group findById(UUID id);

//    List<GroupDto> filter(GroupFilter filter, Pageable pageable);
}
