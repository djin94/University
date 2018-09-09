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
}
