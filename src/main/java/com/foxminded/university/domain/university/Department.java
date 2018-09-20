package com.foxminded.university.domain.university;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Department {
    private String name;
    private List<Teacher> teachers = new ArrayList<>();
    private List<Group> groups = new ArrayList<>();
    private List<Subject> subjects = new ArrayList<>();

    public Optional<Teacher> getTeacherByEmployeeId(int employeeId) {
        for (Teacher teacher : teachers) {
            if (teacher.getEmployeeId() == employeeId)
                return Optional.of(teacher);
        }
        return Optional.empty();
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

    public String showListTeachers() {
        String listTeachers = name + "\n";
        for (int i = 0; i < teachers.size(); i++)
            listTeachers += String.valueOf(i + 1) + " - " + teachers.get(i) + "\n";
        return listTeachers;
    }

    public String showListGroups() {
        String listGroups = name + "\n";
        for (int i = 0; i < groups.size(); i++) {
            listGroups += String.valueOf(i + 1) + " - " + groups.get(i) + "\n";
        }
        return listGroups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) {
            return false;
        }
        Department that = (Department) o;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return name;
    }
}
