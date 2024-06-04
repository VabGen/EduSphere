package com.example.edusphere.model.filter;

import com.example.edusphere.dao.specification.SubjectSpecification.FetchType;

public class SubjectFilter {

    private String name;
    private FetchType[] fetches = new FetchType[0];

    public SubjectFilter() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FetchType[] getFetches() {
        return fetches;
    }

    public void setFetches(FetchType[] fetches) {
        this.fetches = fetches;
    }
}
