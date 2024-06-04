package com.example.edusphere.controller.model.request;

import java.util.UUID;

public class SubjectRequest {

    private UUID id;
    private String name;

    public SubjectRequest() {
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
}
