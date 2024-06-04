package com.example.edusphere.dto.mapper;

import com.example.edusphere.controller.model.request.TeacherRequest;
import com.example.edusphere.dao.entity.Teacher;
import com.example.edusphere.dao.specification.TeacherSpecification.FetchType;
import com.example.edusphere.dto.model.TeacherDto;

import java.util.ArrayList;
import java.util.List;

public class TeacherMapper {

    public static TeacherDto entityToDto(Teacher teacher) {
        if (teacher == null) {
            return null;
        }

        TeacherDto dto = new TeacherDto();
        dto.setId(teacher.getId());
        dto.setFirstName(teacher.getFirstName());
        dto.setMiddleName(teacher.getMiddleName());
        dto.setLastName(teacher.getLastName());
        dto.setGender(teacher.getGender());
        dto.setDismissed(teacher.isDismissed());
        dto.setCurator(teacher.isCurator());
        dto.setSubjectId(teacher.getSubjectId());

        return dto;
    }

    public static List<TeacherDto> entityToDto(List<Teacher> teachers) {
        List<TeacherDto> list = new ArrayList<>();
        for (Teacher teacher : teachers) {
            list.add(entityToDto(teacher));
        }

        return list;
    }

    public static TeacherDto entityToDto(Teacher teacher, FetchType... fetchType) {
        TeacherDto dto = entityToDto(teacher);
        for (FetchType type : fetchType) {
            if (type.equals(FetchType.GROUP)) {
                dto.setGroups(GroupMapper.entityToDto(teacher.getGroups()));
            }
        }

        return dto;
    }

    public static Teacher requestToEntity(TeacherRequest request, Teacher teacher) {
        if (request == null) {
            return null;
        }

        teacher.setFirstName(request.getFirstName());
        teacher.setLastName(request.getLastName());
        teacher.setMiddleName(request.getMiddleName());
        teacher.setGender(request.getGender());
        teacher.setDismissed(request.isDismissed());
        teacher.setSubjectId(request.getSubjectId());
        teacher.setCurator(request.isCurator());

        return teacher;
    }
}
