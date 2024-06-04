package com.example.edusphere.dto.model;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public class GroupDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private UUID id;
    private String name;
    private Integer course;
    private StudentDto leader;
    private TeacherDto curator;
    private UUID leaderId;
    private UUID curatorId;
    private List<StudentDto> students;

    public GroupDto() {
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

    public TeacherDto getCurator() {
        return curator;
    }

    public void setCurator(TeacherDto curator) {
        this.curator = curator;
    }

    public UUID getCuratorId() {
        return curatorId;
    }

    public void setCuratorId(UUID curatorId) {
        this.curatorId = curatorId;
    }

    public List<StudentDto> getStudents() {
        return students;
    }

    public void setStudents(List<StudentDto> students) {
        this.students = students;
    }

    public StudentDto getLeader() {
        return leader;
    }

    public void setLeader(StudentDto leader) {
        this.leader = leader;
    }

    public UUID getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(UUID leaderId) {
        this.leaderId = leaderId;
    }
}
