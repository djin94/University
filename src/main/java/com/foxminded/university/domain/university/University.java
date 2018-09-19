package com.foxminded.university.domain.university;

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

    public String getListFaculties() {
        String listFaculties = name + "\n";
        for (int i = 0; i < faculties.size(); i++) {
            listFaculties += String.valueOf(i + 1) + " - " + faculties.get(i) + "\n";
        }
        return listFaculties;
    }

    public String getUniversityStructure() {
        String universityStructure = "Structure " + name + ":\n";
        for (Faculty faculty : faculties) {
            universityStructure += "Faculty: " + faculty + "\n";
            universityStructure += getListFacultyDepartments(faculty);
        }
        return universityStructure;
    }

    private String getListFacultyDepartments(Faculty faculty) {
        String listDepartments = "";
        for (Department department : faculty.getDepartments())
            listDepartments += " Department: " + department + "\n";
        return listDepartments;
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

    @Override
    public String toString() {
        return name;
    }
}
