package com.example.edusphere.dto.model;

import com.example.edusphere.dao.entity.Group;
import com.example.edusphere.dao.entity.Subject;
import com.example.edusphere.dao.entity.Teacher;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

public class LessonDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private UUID id;
    private String name;
    private Teacher teacher;
    private Subject subject;
    private Instant lessonTime;
    private Group group;
}
