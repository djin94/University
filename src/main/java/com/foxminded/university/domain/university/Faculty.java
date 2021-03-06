package com.foxminded.university.domain.university;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private String name;
    private List<Department> departments = new ArrayList<>();
    private List<Audience> audiences = new ArrayList<>();

    public void update(Faculty faculty) {
        this.name = faculty.name;
        this.departments.clear();
        this.departments.addAll(faculty.departments);
        this.audiences.clear();
        this.audiences.addAll(faculty.audiences);
    }

    public void add(Department department) {
        departments.add(department);
    }

    public void remove(Department department) {
        departments.remove(department);
    }

    public void add(Audience audience) {
        audiences.add(audience);
    }

    public void remove(Audience audience) {
        audiences.remove(audience);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<Audience> getAudiences() {
        return audiences;
    }

    public void setAudiences(List<Audience> audiences) {
        this.audiences = audiences;
    }

    public String showListDepartment() {
        String listDepartments = name + "\n";
        for (int i = 0; i < departments.size(); i++) {
            listDepartments += String.valueOf(i + 1) + " - " + departments.get(i) + "\n";
        }
        return listDepartments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Faculty)) {
            return false;
        }
        Faculty faculty = (Faculty) o;
        return name != null ? name.equals(faculty.name) : faculty.name == null;
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