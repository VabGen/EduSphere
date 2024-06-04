package com.example.edusphere.dto.model;

import com.example.edusphere.dao.entity.TeacherSubject;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public class SubjectDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private UUID id;
    private String name;
    private List<LessonDto> lessons;
    private List<TeacherSubject> teachers;

    public SubjectDto() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TeacherSubject> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<TeacherSubject> teachers) {
        this.teachers = teachers;
    }

    public List<LessonDto> getLessons() {
        return lessons;
    }

    public void setLessons(List<LessonDto> lessons) {
        this.lessons = lessons;
    }
}
