package com.example.edusphere.dao.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "teacher_subject")
public class TeacherSubject {

    @Id
    @GeneratedValue(generator = "uuid-generator")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Subject subject;
}

