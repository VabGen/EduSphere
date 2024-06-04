package com.example.edusphere.dto.mapper;

import com.example.edusphere.controller.model.request.GroupRequest;
import com.example.edusphere.dao.entity.Group;
import com.example.edusphere.dao.specification.GroupSpecification.FetchType;
import com.example.edusphere.dto.model.GroupDto;

import java.util.ArrayList;
import java.util.List;

public class GroupMapper {

    public static GroupDto entityToDto(Group group) {
        if (group == null) {
            return null;
        }

        GroupDto dto = new GroupDto();
        dto.setId(group.getId());
        dto.setName(group.getName());
        dto.setCourse(group.getCourse());
        dto.setCuratorId(group.getCuratorId());
        dto.setLeaderId(group.getLeaderId());

        return dto;
    }

    public static GroupDto entityToDto(Group group, FetchType... fetchType) {
        GroupDto dto = entityToDto(group);
        for (FetchType type : fetchType) {
            switch (type) {
                case STUDENT -> dto.setStudents(StudentMapper.entityToDto(group.getStudents()));
                case CURATOR -> dto.setCurator(TeacherMapper.entityToDto(group.getCurator()));
                case LEADER -> dto.setLeader(StudentMapper.entityToDto(group.getLeader()));
            }
        }

        return dto;
    }

    public static List<GroupDto> entityToDto(List<Group> groups) {
        if (groups == null) {
            return null;
        }

        List<GroupDto> list = new ArrayList<>();
        for (Group group : groups) {
            list.add(entityToDto(group));
        }

        return list;
    }

    public static Group requestToEntity(GroupRequest request, Group group) {
        if (request == null) {
            return null;
        }

        group.setName(request.getName());
        group.setCourse(request.getCourse());
        group.setCuratorId(request.getCuratorId());
        group.setLeaderId(request.getLeaderId());

        return group;
    }
}


