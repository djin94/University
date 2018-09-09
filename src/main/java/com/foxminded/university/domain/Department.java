package com.foxminded.university.domain;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Teacher> teachers = new ArrayList<>();
    private List<Group> groups = new ArrayList<>();
    private List<Subject> subjects = new ArrayList<>();

    public Teacher getTeacherByEmployeeId(int employeeId) {
        for (Teacher teacher : teachers) {
            if (teacher.getEmployeeId() == employeeId)
                return teacher;
        }
        return Teacher.EMPTY_TEACHER;
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void removeTeacher(Teacher teacher) {
        teachers.remove(teacher);
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    public void removeGroup(Group group) {
        groups.remove(group);
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public void removeSubject(Subject subject) {
        subjects.remove(subject);
    }

    public void update(Department department) {
        this.name = department.name;
        this.teachers.clear();
        this.teachers.addAll(department.teachers);
        this.groups.clear();
        this.groups.addAll(department.groups);
        this.subjects.clear();
        this.subjects.addAll(subjects);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
