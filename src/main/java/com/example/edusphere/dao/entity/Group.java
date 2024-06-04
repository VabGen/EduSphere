package com.example.edusphere.dao.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "student_group")
public class Group implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid-generator")
    private UUID id;

    @Column(name = "name", nullable = false)
    @NotNull(message = "The name cannot be null")
    @NotBlank(message = "The name cannot be empty")
    private String name;

    @Column(name = "course", nullable = false)
    @NotNull(message = "The course cannot be null")
    @NotBlank(message = "The course cannot be empty")
    private Integer course;

    @Column(name = "leader_id")
    private UUID leaderId;

    @ManyToOne
    @JoinColumn(name = "leader_id", insertable = false, updatable = false)
    private Student leader;

    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Lesson> lessons;

    @Column(name = "curator_id")
    private UUID curatorId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curator_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Teacher curator;

    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Student> students;

    public Group() {
    }

    public Group(String name, Integer course, UUID leaderId, UUID curatorId, List<Lesson> lessons) {
        this.name = name;
        this.course = course;
        this.leaderId = leaderId;
        this.curatorId = curatorId;
        this.lessons = lessons;
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

    public Student getLeader() {
        return leader;
    }

    public void setLeader(Student prefect) {
        this.leader = prefect;
    }

    public UUID getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(UUID leaderId) {
        this.leaderId = leaderId;
    }

    public Teacher getCurator() {
        return curator;
    }

    public void setCurator(Teacher curator) {
        this.curator = curator;
    }

    public UUID getCuratorId() {
        return curatorId;
    }

    public void setCuratorId(UUID curatorId) {
        this.curatorId = curatorId;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}
