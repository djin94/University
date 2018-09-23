package com.foxminded.university.domain.university;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SubjectTest {
    private Subject plicSubject;
    private Subject updateSubject;

    @Before
    public void setUp() {
        plicSubject = new Subject();
        plicSubject.setName("PLIS");
        plicSubject.setHoursInSemestr(120);

        updateSubject = new Subject();
        updateSubject.setName("The quantum physics");
    }

    @Test
    public void shouldUpdateSubject_WhenUpdateSubject() {
        plicSubject.update(updateSubject);

        Subject expectedSubject = updateSubject;
        Subject actualSubject = plicSubject;

        assertEquals(expectedSubject, actualSubject);
    }
}