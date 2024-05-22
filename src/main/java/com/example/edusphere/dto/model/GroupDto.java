package com.example.edusphere.dto.model;

import com.example.edusphere.dao.entity.Student;
import com.example.edusphere.dao.entity.Teacher;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

public class GroupDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private UUID id;
    private String name;
    private Integer course;
    private Student prefect;
    private Teacher curator;
}
