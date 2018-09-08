package com.foxminded.university.domain;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person {
    private int employeeId;
    private List<Subject> subjects = new ArrayList<>();

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
