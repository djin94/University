package com.foxminded.university.domain;

public class Student extends Person {
    public static final Student EMPTY_STUDENT = new Student();
    private int numberOfMarkBook;

    public int getNumberOfMarkBook() {
        return numberOfMarkBook;
    }

    public void setNumberOfMarkBook(int numberOfMarkBook) {
        this.numberOfMarkBook = numberOfMarkBook;
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
}
