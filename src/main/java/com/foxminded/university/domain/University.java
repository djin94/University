package com.foxminded.university.domain;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private List<Faculty> faculties = new ArrayList<>();

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public void removeFaculty(Faculty faculty) {
        faculties.remove(faculty);
    }

    public void update(University university) {
        this.name = university.name;
        this.faculties.clear();
        this.faculties.addAll(university.faculties);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof University)) {
            return false;
        }

        University that = (University) o;

        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
