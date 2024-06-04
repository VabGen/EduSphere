package com.example.edusphere.model.filter;

import com.example.edusphere.dao.specification.LessonSpecification.FetchType;

import java.time.Instant;

public class LessonFilter {

    private String teacherFullName;
    private String subjectName;
    private String groupName;
    private Instant FromDate;
    private Instant toDate;
    private FetchType[] fetches = new FetchType[0];

    public LessonFilter() {
    }

    public String getTeacherFullName() {
        return teacherFullName;
    }

    public void setTeacherFullName(String teacherFullName) {
        this.teacherFullName = teacherFullName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
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

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public FetchType[] getFetches() {
        return fetches;
    }

    public void setFetches(FetchType[] fetches) {
        this.fetches = fetches;
    }
}
