package com.example.edusphere.dto.mapper;

import com.example.edusphere.controller.model.request.LessonRequest;
import com.example.edusphere.dao.entity.Lesson;
import com.example.edusphere.dao.specification.LessonSpecification.FetchType;
import com.example.edusphere.dto.model.LessonDto;

import java.util.ArrayList;
import java.util.List;

public class LessonMapper {

    public static LessonDto entityToDto(Lesson lesson) {
        if (lesson == null) {
            return null;
        }

        LessonDto dto = new LessonDto();
        dto.setId(lesson.getId());
        dto.setLessonTime(lesson.getLessonTime());
        dto.setGroupId(lesson.getGroupId());
        dto.setSubjectId(lesson.getSubjectId());
        dto.setTeacherId(lesson.getTeacherId());

        return dto;
    }

    public static List<LessonDto> entityToDto(List<Lesson> lessons) {
        List<LessonDto> list = new ArrayList<>();
        for (Lesson lesson : lessons) {
            list.add(entityToDto(lesson));
        }

        return list;
    }

    public static LessonDto entityToDto(Lesson lesson, FetchType... fetchType) {
        LessonDto dto = entityToDto(lesson);
        for (FetchType type : fetchType) {
            switch (type) {
                case TEACHER -> dto.setTeacher(TeacherMapper.entityToDto(lesson.getTeacher()));
                case SUBJECT -> dto.setSubject(SubjectMapper.entityToDto(lesson.getSubject()));
                case GROUP -> dto.setGroup(GroupMapper.entityToDto(lesson.getGroup()));
            }

        }

        return dto;
    }

    public static Lesson requestToEntity(LessonRequest request, Lesson lesson) {
        if (request == null) {
            return null;
        }

        lesson.setId(request.getId());
        lesson.setGroupId(request.getGroupId());
        lesson.setSubjectId(request.getSubjectId());
        lesson.setSubjectId(request.getSubjectId());
        lesson.setTeacherId(request.getTeacherId());
        lesson.setLessonTime(request.getLessonTime());

        return lesson;
    }
}
