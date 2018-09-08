package com.foxminded.university.domain;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person {
    private int employeeId;
    private List<Subject> subjects = new ArrayList<>();

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public void removeSubject(Subject subject) {
        subjects.remove(subject);
    }

    public void update(Teacher teacher) {
        this.employeeId = teacher.employeeId;
        this.subjects.clear();
        this.subjects.addAll(teacher.subjects);
    }

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
