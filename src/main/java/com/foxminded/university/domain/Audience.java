package com.foxminded.university.domain;

public class Audience {
    private int number;
    private int building;
    private String type;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getBuilding() {
        return building;
    }

    public void setBuilding(int building) {
        this.building = building;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void update(Audience audience){
        this.number = audience.getNumber();
        this.building = audience.getBuilding();
        this.type = audience.getType();
    }
}
