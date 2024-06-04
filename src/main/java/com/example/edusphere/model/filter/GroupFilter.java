package com.example.edusphere.model.filter;

import com.example.edusphere.dao.specification.GroupSpecification.FetchType;

public class GroupFilter {

    private String name;
    private Integer course;
    private String leaderFullName;
    private String curatorFullName;
    private FetchType[] fetches = new FetchType[0];

    public GroupFilter() {
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

    public String getLeaderFullName() {
        return leaderFullName;
    }

    public void setLeaderFullName(String leaderFullName) {
        this.leaderFullName = leaderFullName;
    }

    public String getCuratorFullName() {
        return curatorFullName;
    }

    public void setCuratorFullName(String curatorFullName) {
        this.curatorFullName = curatorFullName;
    }

    public FetchType[] getFetches() {
        return fetches;
    }

    public void setFetches(FetchType[] fetches) {
        this.fetches = fetches;
    }
}
