package com.example.edusphere.controller.model.request;

import java.util.UUID;

public class GroupRequest {

    private UUID id;
    private UUID curatorId;
    private UUID leaderId;
    private String name;
    private Integer course;

    public GroupRequest() {
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

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public UUID getCuratorId() {
        return curatorId;
    }

    public void setCuratorId(UUID curatorId) {
        this.curatorId = curatorId;
    }

    public UUID getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(UUID leaderId) {
        this.leaderId = leaderId;
    }
}
