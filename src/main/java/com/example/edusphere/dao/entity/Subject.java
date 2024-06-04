package com.example.edusphere.dao.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "subject")
public class Subject implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid-generator")
    private UUID id;

    @Column(name = "name", nullable = false)
    @NotBlank(message = "The title cannot be empty")
    private String name;

    @OneToMany(mappedBy = "subject", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Lesson> lessons;

    @OneToMany(mappedBy = "subject", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<TeacherSubject> teachers;

    public Subject() {
    }

    public Subject(String name, List<TeacherSubject> teachers, List<Lesson> lessons) {
        this.name = name;
        this.teachers = teachers;
        this.lessons = lessons;
    }

    public Subject(String name) {
        this.name = name;
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

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}
