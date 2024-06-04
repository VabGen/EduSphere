package com.example.edusphere.service.impl;

import com.example.edusphere.controller.model.request.GroupRequest;
import com.example.edusphere.dao.entity.Group;
import com.example.edusphere.dao.service.GroupServiceDao;
import com.example.edusphere.dao.specification.GroupSpecification.FetchType;
import com.example.edusphere.dto.mapper.GroupMapper;
import com.example.edusphere.dto.model.GroupDto;
import com.example.edusphere.model.filter.GroupFilter;
import com.example.edusphere.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class GroupServiceImpl implements GroupService {

    private final GroupServiceDao groupDAO;

    @Autowired
    public GroupServiceImpl(GroupServiceDao groupDAO) {
        this.groupDAO = groupDAO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public GroupDto create(GroupRequest request) {
        Group group = GroupMapper.requestToEntity(request, new Group());
        groupDAO.create(group);
        return GroupMapper.entityToDto(group);
    }

    @Override
    @Transactional(readOnly = true)
    public List<GroupDto> findAll() {
        List<Group> groups = groupDAO.findAll();
        return groups.stream().map(GroupMapper::entityToDto).collect(Collectors.toList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public GroupDto edit(GroupRequest request) {
        Group group = groupDAO.findById(request.getId());
        if (group == null) {
            throw new RuntimeException("Group not found");
        }
        GroupMapper.requestToEntity(request, group);
        groupDAO.edit(group);
        return GroupMapper.entityToDto(group);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(UUID id) {
        groupDAO.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public GroupDto findById(UUID id) {
        Group group = groupDAO.findById(id);
        return GroupMapper.entityToDto(group, FetchType.STUDENT, FetchType.CURATOR, FetchType.LEADER);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<GroupDto> findAll(GroupFilter filter, Pageable pageable) {
        Page<Group> groupPage = groupDAO.findAll(filter, pageable);
        return groupPage.map(e -> GroupMapper.entityToDto(e, filter.getFetches()));
    }
}
