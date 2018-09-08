package com.foxminded.university.domain;

public class Subject {
    private String name;
    private int hoursInSemestr;

    public void update(Subject subject) {
        this.name = subject.name;
        this.hoursInSemestr = subject.hoursInSemestr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHoursInSemestr() {
        return hoursInSemestr;
    }

    public void setHoursInSemestr(int hoursInSemestr) {
        this.hoursInSemestr = hoursInSemestr;
    }
}
