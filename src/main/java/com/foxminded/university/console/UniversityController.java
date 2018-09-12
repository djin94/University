package com.foxminded.university.console;

import com.foxminded.university.domain.*;

public class UniversityController {
    private University university;

    public Teacher getTeacherByName(String lastName, String firstName, String patronym) {
        return university.getFaculties().stream()
                .flatMap(faculty -> faculty.getDepartments().stream())
                .flatMap(department -> department.getTeachers().stream())
                .filter(teacher -> teacher.getLastName().equals(lastName) &&
                        teacher.getFirstName().equals(firstName) &&
                        teacher.getPatronym().equals(patronym)).findFirst().get();
    }

    public Student getStudentByName(String lastName, String firstName, String patronym) {
        return university.getFaculties().stream()
                .flatMap(faculty -> faculty.getDepartments().stream())
                .flatMap(department -> department.getGroups().stream())
                .flatMap(group -> group.getStudents().stream())
                .filter(student -> student.getLastName().equals(lastName) &&
                        student.getFirstName().equals(firstName) &&
                        student.getPatronym().equals(patronym)).findFirst().get();
    }

    public Group getGroupByName(String name) {
        return university.getFaculties().stream()
                .flatMap(faculty -> faculty.getDepartments().stream())
                .flatMap(department -> department.getGroups().stream())
                .filter(group -> group.getName().equals(name)).findFirst().get();
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }
}
