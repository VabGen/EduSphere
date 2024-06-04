package com.example.edusphere.dao.entity;

import com.example.edusphere.model.enums.GenderType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "student")
public class Student implements Serializable {

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

    @Column(name = "leader", columnDefinition = "bool default false")
    private boolean leader;

    @CreationTimestamp
    private Instant enrollmentDate;

    @UpdateTimestamp
    private Instant modificationDate;

    @Column(name = "group_id")
    private UUID groupId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Group group;

    public Student() {
    }

    public Student(String firstName, String middleName, String lastName, GenderType gender, boolean dismissed,
                   boolean leader, Instant enrollmentDate, Instant modificationDate, UUID groupId) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.gender = gender;
        this.dismissed = dismissed;
        this.leader = leader;
        this.enrollmentDate = enrollmentDate;
        this.modificationDate = modificationDate;
        this.groupId = groupId;
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

    public Instant getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Instant enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public Instant getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Instant modificationDate) {
        this.modificationDate = modificationDate;
    }

    public UUID getGroupId() {
        return groupId;
    }

    public void setGroupId(UUID groupId) {
        this.groupId = groupId;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public boolean isLeader() {
        return leader;
    }

    public void setLeader(boolean leader) {
        this.leader = leader;
    }
}
