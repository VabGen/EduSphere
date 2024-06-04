package com.example.edusphere.dto.mapper;

import com.example.edusphere.controller.model.request.StudentRequest;
import com.example.edusphere.dao.entity.Student;
import com.example.edusphere.dao.specification.StudentSpecification.FetchType;
import com.example.edusphere.dto.model.StudentDto;

import java.util.ArrayList;
import java.util.List;

public class StudentMapper {

    public static StudentDto entityToDto(Student student) {
        if (student == null) {
            return null;
        }

        StudentDto dto = new StudentDto();
        dto.setId(student.getId());
        dto.setFirstName(student.getFirstName());
        dto.setMiddleName(student.getMiddleName());
        dto.setLastName(student.getLastName());
        dto.setGender(student.getGender());
        dto.setDismissed(student.isDismissed());
        dto.setLeader(student.isLeader());
        dto.setGroupId(student.getGroupId());
        dto.setEnrollmentDate(student.getEnrollmentDate());
        dto.setModificationDate(student.getModificationDate());

        return dto;
    }

    public static List<StudentDto> entityToDto(List<Student> students) {
        List<StudentDto> list = new ArrayList<>();
        for (Student student : students) {
            list.add(entityToDto(student));
        }

        return list;
    }

    public static StudentDto entityToDto(Student student, FetchType... fetchType) {
        StudentDto dto = entityToDto(student);
        for (FetchType type : fetchType) {
            if (type.equals(FetchType.GROUP)) {
                dto.setGroup(GroupMapper.entityToDto(student.getGroup()));
            }
        }

        return dto;
    }

    public static Student requestToEntity(StudentRequest request, Student student) {
        if (request == null) {
            return null;
        }

        student.setFirstName(request.getFirstName());
        student.setMiddleName(request.getMiddleName());
        student.setLastName(request.getLastName());
        student.setGender(request.getGender());
        student.setDismissed(request.isDismissed());
        student.setGroupId(request.getGroupId());
        student.setLeader(request.isLeader());

        return student;
    }
}
