package com.foxminded.university.domain.university;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Group {
    private String name;
    private List<Student> students = new ArrayList<>();

    public void add(Student student) {
        students.add(student);
    }

    public void remove(Student student) {
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

    public Optional<Student> findStudent(int numberMarkBook) {
        for (Student student : students) {
            if (student.getNumberOfMarkBook() == numberMarkBook) {
                return Optional.of(student);
            }
        }
        return Optional.empty();
    }

    public String showListStudents() {
        String listStudents = name + "\n";
        for (int i = 0; i < students.size(); i++)
            listStudents += String.valueOf(i + 1) + " - " + students.get(i) + "\n";
        return listStudents;
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

    @Override
    public String toString() {
        return name;
    }


}
