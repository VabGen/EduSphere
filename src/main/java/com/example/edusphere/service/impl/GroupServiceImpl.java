package com.example.edusphere.service.impl;

import com.example.edusphere.controller.model.request.GroupRequest;
import com.example.edusphere.dao.entity.Group;
import com.example.edusphere.dto.model.GroupDto;
import com.example.edusphere.service.GroupService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GroupServiceImpl implements GroupService {

    @Override
    public GroupDto create(GroupRequest request) {
        return null;
    }

    @Override
    public List<GroupDto> read() {
        return null;
    }

    @Override
    public GroupDto update(GroupRequest request) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public Group findById(UUID id) {
        return null;
    }
}
