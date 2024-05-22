package com.example.edusphere.dto.model;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

public class SubjectDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private UUID id;
    private String name;
}
