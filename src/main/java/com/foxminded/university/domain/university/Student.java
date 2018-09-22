package com.foxminded.university.domain.university;

public class Student extends Person {
    private int numberOfMarkBook;

    public int getNumberOfMarkBook() {
        return numberOfMarkBook;
    }

    public void setNumberOfMarkBook(int numberOfMarkBook) {
        this.numberOfMarkBook = numberOfMarkBook;
    }

    public void update(Student student) {
        this.setLastName(student.getLastName());
        this.setFirstName(student.getFirstName());
        this.setPatronym(student.getPatronym());
        this.numberOfMarkBook = student.getNumberOfMarkBook();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) {
            return false;
        }
        Student student = (Student) o;
        return numberOfMarkBook == student.numberOfMarkBook;
    }

    @Override
    public int hashCode() {
        return numberOfMarkBook;
    }

    @Override
    public String toString() {
        return getLastName() + " " + getFirstName() + " " + getPatronym();
    }
}
