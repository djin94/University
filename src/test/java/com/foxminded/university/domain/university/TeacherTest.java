package com.foxminded.university.domain.university;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TeacherTest {
    private Teacher holopovTeacher;
    private Subject plicSubject;
    private List<Subject> storedSubjects;
    private List<Subject> emptyStoredSubjects;
    private Teacher updateTeacher;

    @Before
    public void setUp() {
        plicSubject = new Subject();
        plicSubject.setName("PLIS");
        plicSubject.setHoursInSemestr(120);

        holopovTeacher = new Teacher();
        holopovTeacher.setFirstName("Sergey");
        holopovTeacher.setPatronym("Ivanovich");
        holopovTeacher.setLastName("Holopov");
        holopovTeacher.setEmployeeId(7852);
        holopovTeacher.addSubject(plicSubject);

        storedSubjects = new ArrayList<>();
        storedSubjects.add(plicSubject);

        emptyStoredSubjects = new ArrayList<>();

        updateTeacher = new Teacher();
        updateTeacher.setFirstName("Sergey");
        updateTeacher.setPatronym("Vladimirovich");
        updateTeacher.setLastName("Anikeev");
    }

    @Test
    public void shouldAddSubjectToTeacher_WhenAddSubjectToTeacher() {
        List<Subject> expectedStoredSubjects = storedSubjects;
        List<Subject> actualStoredSubjects = holopovTeacher.getSubjects();

        assertEquals(expectedStoredSubjects, actualStoredSubjects);
    }

    @Test
    public void shouldRemoveSubjectFromTeacher_WhenRemoveSubjectFromTeacher() {
        holopovTeacher.removeSubject(plicSubject);

        List<Subject> expectedStoredSubjects = emptyStoredSubjects;
        List<Subject> actualStoredSubjects = holopovTeacher.getSubjects();

        assertEquals(expectedStoredSubjects, actualStoredSubjects);
    }

    @Test
    public void shouldUpdateTeacher_WhenUpdateTeacher() {
        holopovTeacher.update(updateTeacher);

        Teacher expectedTeacher = updateTeacher;
        Teacher actualTeacher = holopovTeacher;

        assertEquals(expectedTeacher, actualTeacher);
    }
}