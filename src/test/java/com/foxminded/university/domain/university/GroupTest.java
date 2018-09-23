package com.foxminded.university.domain.university;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GroupTest {
    private Group group3033;
    private Student kabatovStudent;

    private List<Student> storedStudents;
    private List<Student> emptyStoredStudents;

    private Group updateGroup;

    @Before
    public void setUp() {
        kabatovStudent = new Student();
        kabatovStudent.setFirstName("Evgeny");
        kabatovStudent.setPatronym("Nikolaevich");
        kabatovStudent.setLastName("Kabatov");
        kabatovStudent.setNumberOfMarkBook(230110);

        group3033 = new Group();
        group3033.setName("3033");
        group3033.addStudent(kabatovStudent);

        storedStudents = new ArrayList<>();
        storedStudents.add(kabatovStudent);

        emptyStoredStudents = new ArrayList<>();

        updateGroup = new Group();
        updateGroup.setName("2070");
    }

    @Test
    public void shouldAddStudentToGroup_WhenAddStudentToGroup() {
        List<Student> expectedStoredStudents = storedStudents;
        List<Student> actualStoredStudents = group3033.getStudents();

        assertEquals(expectedStoredStudents, actualStoredStudents);
    }

    @Test
    public void shouldRemoveStudentFromGroup_WhenRemoveStudentFromGroup() {
        group3033.removeStudent(kabatovStudent);

        List<Student> expectedStoredStudents = emptyStoredStudents;
        List<Student> actualStoredStudents = group3033.getStudents();

        assertEquals(expectedStoredStudents, actualStoredStudents);
    }

    @Test
    public void shouldUpdateGroup_WhenUpdateGroup() {
        group3033.update(updateGroup);

        Group expectedGroup = updateGroup;
        Group actualGroup = group3033;

        assertEquals(expectedGroup, actualGroup);
    }
}