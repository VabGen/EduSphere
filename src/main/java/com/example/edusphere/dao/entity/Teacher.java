package com.example.edusphere.dao.entity;

import com.example.edusphere.model.enums.GenderType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "teacher")
public class Teacher implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid-generator")
    private UUID id;

    @Column(name = "first_name", nullable = false)
    @NotBlank(message = "The first name cannot be empty")
    private String firstName;

    @Column(name = "middle_name", nullable = false)
    @NotBlank(message = "The middle name cannot be empty")
    private String middleName;

    @Column(name = "last_name", nullable = false)
    @NotBlank(message = "The last name cannot be empty")
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender_type", nullable = false)
    @NotBlank(message = "The gender type cannot be empty")
    private GenderType gender;

    @Column(name = "dismissed", columnDefinition = "bool default false")
    private boolean dismissed;

    @Column(name = "curator", columnDefinition = "bool default false")
    private boolean curator;

    @CreationTimestamp
    private Instant hireDate;

    @UpdateTimestamp
    private Instant modificationDate;

    @OneToMany(mappedBy = "curator")
    private List<Group> groups;

    @Column(name = "subject_id")
    private UUID subjectId;

    @OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<TeacherSubject> subjects;

    public Teacher() {
    }

    public Teacher(String firstName, String middleName, String lastName, GenderType gender, boolean dismissed,
                   boolean curator, Instant hireDate, Instant modificationDate, UUID subjectId,
                   List<TeacherSubject> subjects) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.gender = gender;
        this.dismissed = dismissed;
        this.curator = curator;
        this.hireDate = hireDate;
        this.modificationDate = modificationDate;
        this.subjectId = subjectId;
        this.subjects = subjects;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType genderType) {
        this.gender = genderType;
    }

    public boolean isDismissed() {
        return dismissed;
    }

    public void setDismissed(boolean dismissed) {
        this.dismissed = dismissed;
    }

    public Instant getHireDate() {
        return hireDate;
    }

    public void setHireDate(Instant creationDate) {
        this.hireDate = creationDate;
    }

    public Instant getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Instant modificationDate) {
        this.modificationDate = modificationDate;
    }

    public UUID getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(UUID subjectId) {
        this.subjectId = subjectId;
    }

    public List<TeacherSubject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<TeacherSubject> subjects) {
        this.subjects = subjects;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public boolean isCurator() {
        return curator;
    }

    public void setCurator(boolean curator) {
        this.curator = curator;
    }
}