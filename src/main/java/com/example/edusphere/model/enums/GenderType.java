package com.example.edusphere.model.enums;

public enum GenderType {

    MALE("Мужской"),
    FEMALE("Женский"),
    OTHER("Другой");

    private final String displayValue;

    GenderType(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
