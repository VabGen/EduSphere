package com.example.edusphere.model.filter;

import com.example.edusphere.dao.specification.StudentSpecification.FetchType;
import com.example.edusphere.model.enums.GenderType;

import java.time.Instant;

public class StudentFilter {

    private String fullName;
    private boolean dismissed;
    private GenderType genderType;
    private Instant FromDate;
    private Instant toDate;
    private FetchType[] fetches = new FetchType[0];

    public StudentFilter() {
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

    public Instant getFromDate() {
        return FromDate;
    }

    public void setFromDate(Instant fromDate) {
        FromDate = fromDate;
    }

    public Instant getToDate() {
        return toDate;
    }

    public void setToDate(Instant toDate) {
        this.toDate = toDate;
    }

    public FetchType[] getFetches() {
        return fetches;
    }

    public void setFetches(FetchType[] fetches) {
        this.fetches = fetches;
    }
}
