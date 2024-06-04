package com.example.edusphere.model.filter;

import com.example.edusphere.dao.specification.TeacherSpecification.FetchType;
import com.example.edusphere.model.enums.GenderType;

import java.time.Instant;

public class TeacherFilter {

    private String fullName;
    private boolean dismissed;
    private GenderType genderType;
    private Instant startDate;
    private Instant endDate;
    private FetchType[] fetches = new FetchType[0];

    public TeacherFilter() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isDismissed() {
        return dismissed;
    }

    public void setDismissed(boolean dismissed) {
        this.dismissed = dismissed;
    }

    public GenderType getGenderType() {
        return genderType;
    }

    public void setGenderType(GenderType genderType) {
        this.genderType = genderType;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public void setStartDate(Instant startDate) {
        this.startDate = startDate;
    }

    public Instant getEndDate() {
        return endDate;
    }

    public void setEndDate(Instant endDate) {
        this.endDate = endDate;
    }

    public FetchType[] getFetches() {
        return fetches;
    }

    public void setFetches(FetchType[] fetches) {
        this.fetches = fetches;
    }
}
