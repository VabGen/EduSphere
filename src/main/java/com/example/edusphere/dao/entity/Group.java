package com.example.edusphere.dao.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "groups")
public class Group implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "name", nullable = false)
    @NotBlank(message = "The name cannot be empty")
    private String name;

    @Column(nullable = false)
    @NotBlank(message = "The course cannot be empty")
    private Integer course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prefect_id", referencedColumnName = "id")
    private Student prefect;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curator_id", referencedColumnName = "id")
    private Teacher curator;

    public Group() {
    }

    public Group(String name, Integer course) {
        this.name = name;
        this.course = course;
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
}
