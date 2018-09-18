package com.foxminded.university.domain.university;

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

    public void update(Audience audience) {
        this.number = audience.number;
        this.building = audience.building;
        this.type = audience.type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Audience)) {
            return false;
        }
        Audience audience = (Audience) o;
        if (number != audience.number) return false;
        return building == audience.building;
    }

    @Override
    public int hashCode() {
        return 31 * number + building;
    }

    @Override
    public String toString() {
        return number + "u" + building;
    }
}
