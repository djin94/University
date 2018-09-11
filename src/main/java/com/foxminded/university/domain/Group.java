package com.foxminded.university.domain;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String name;
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public void update(Group group) {
        this.name = group.name;
        this.students.clear();
        this.students.addAll(group.students);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Student getStudentByNumberOfMarkBook(int numberMarkBook) {
        for (Student student : students) {
            if (student.getNumberOfMarkBook() == numberMarkBook) {
                return student;
            }
        }
        return Student.EMPTY_STUDENT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group)) {
            return false;
        }
        Group group = (Group) o;
        return name != null ? name.equals(group.name) : group.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
