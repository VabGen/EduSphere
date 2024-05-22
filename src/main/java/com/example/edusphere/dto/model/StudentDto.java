package com.example.edusphere.dto.model;

import com.example.edusphere.dao.entity.Group;
import com.example.edusphere.model.enums.GenderType;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

public class StudentDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private UUID id;
    private String firstName;
    private String middleName;
    private String lastName;
    private GenderType genderType;
    private boolean dismissed;
    private Instant enrollmentDate;
    private Instant modificationDate;
    private Group group;
}
