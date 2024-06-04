package com.example.edusphere.dto.mapper;

import com.example.edusphere.controller.model.request.SubjectRequest;
import com.example.edusphere.dao.entity.Lesson;
import com.example.edusphere.dao.entity.Subject;
import com.example.edusphere.dao.specification.SubjectSpecification.FetchType;
import com.example.edusphere.dto.model.LessonDto;
import com.example.edusphere.dto.model.SubjectDto;

import java.util.ArrayList;
import java.util.List;

public class SubjectMapper {

    public static SubjectDto entityToDto(Subject subject) {
        if (subject == null) {
            return null;
        }

        SubjectDto dto = new SubjectDto();
        dto.setId(subject.getId());
        dto.setName(subject.getName());

        return dto;
    }

    public static SubjectDto entityToDto(Subject subject, FetchType... fetchType) {
        SubjectDto dto = entityToDto(subject);
        for (FetchType type : fetchType) {
            if (type.equals(FetchType.LESSON)) {
                dto.setLessons(LessonMapper.entityToDto(subject.getLessons()));
            }
        }

        return dto;
    }

    public static List<LessonDto> lessonToDto(List<Lesson> lessons) {
        if (lessons == null) {
            return null;
        }

        List<LessonDto> list = new ArrayList<>();
        for (Lesson lesson : lessons) {
            LessonDto lessonDto = LessonMapper.entityToDto(lesson);
            list.add(lessonDto);
        }

        return list;
    }

    public static Subject requestToEntity(SubjectRequest request, Subject subject) {
        if (request == null) {
            return null;
        }

        subject.setName(request.getName());

        return subject;
    }
}
