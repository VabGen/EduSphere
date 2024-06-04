package com.example.edusphere.model.enums;

public enum GenderType {

    MALE("Мужской"),
    FEMALE("Женский"),
    OTHER("Другой");

    private final String value;

    GenderType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
