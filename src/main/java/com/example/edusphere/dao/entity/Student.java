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
@Table(name = "students")
public class Student implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private GenderType genderType;

    @Column(name = "dismissed", columnDefinition = "bool default false")
    private boolean dismissed;

    @CreationTimestamp
    private Instant enrollmentDate;

    @UpdateTimestamp
    private Instant modificationDate;

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private Group group;

    public Student() {
    }

    public Student(String firstName, String middleName, String lastName, GenderType genderType,
                   boolean dismissed, Instant enrollmentDate, Instant modificationDate) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.genderType = genderType;
        this.dismissed = dismissed;
        this.enrollmentDate = enrollmentDate;
        this.modificationDate = modificationDate;
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

    public GenderType getGenderType() {
        return genderType;
    }

    public void setGenderType(GenderType genderType) {
        this.genderType = genderType;
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
}
