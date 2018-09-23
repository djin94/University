package com.foxminded.university.domain.university;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {
    private Student kabatovStudent;
    private Student updateStudent;

    @Before
    public void setUp() {
        kabatovStudent = new Student();
        kabatovStudent.setFirstName("Evgeny");
        kabatovStudent.setPatronym("Nikolaevich");
        kabatovStudent.setLastName("Kabatov");
        kabatovStudent.setNumberOfMarkBook(230110);

        updateStudent = new Student();
        updateStudent.setFirstName("Ivan");
        updateStudent.setPatronym("Ivanovich");
        updateStudent.setLastName("Ivanov");
    }

    @Test
    public void shouldUpdateStudent_WhenUpdateStudent() {
        kabatovStudent.update(updateStudent);

        Student expectedStudent = updateStudent;
        Student actualStudent = kabatovStudent;

        assertEquals(expectedStudent, actualStudent);
    }
}