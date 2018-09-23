package com.foxminded.university.domain.university;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DepartmentTest {
    private Department acsDepartment;
    private Group group3033;
    private Subject plicSubject;
    private Teacher holopovTeacher;

    private List<Teacher> storedTeachers;
    private List<Teacher> emptyStoredTeachers;
    private List<Group> storedGroups;
    private List<Group> emptyStoredGroups;
    private List<Subject> storedSubjects;
    private List<Subject> emptyStoredSubjects;
    private Department updateDepartment;

    @Before
    public void setUp() throws Exception {
        plicSubject = new Subject();
        plicSubject.setName("PLIS");
        plicSubject.setHoursInSemestr(120);

        group3033 = new Group();
        group3033.setName("3033");

        holopovTeacher = new Teacher();
        holopovTeacher.setFirstName("Sergey");
        holopovTeacher.setPatronym("Ivanovich");
        holopovTeacher.setLastName("Holopov");
        holopovTeacher.setEmployeeId(7852);
        holopovTeacher.addSubject(plicSubject);

        acsDepartment = new Department();
        acsDepartment.setName("ASU");
        acsDepartment.addGroup(group3033);
        acsDepartment.addTeacher(holopovTeacher);
        acsDepartment.addSubject(plicSubject);

        storedTeachers = new ArrayList<>();
        storedTeachers.add(holopovTeacher);

        emptyStoredTeachers = new ArrayList<>();

        storedGroups = new ArrayList<>();
        storedGroups.add(group3033);

        emptyStoredGroups = new ArrayList<>();

        storedSubjects = new ArrayList<>();
        storedSubjects.add(plicSubject);

        emptyStoredSubjects = new ArrayList<>();

        updateDepartment = new Department();
        updateDepartment.setName("High energy physics");
    }

    @Test
    public void shouldAddTeacherToDepartment_WhenAddTeacherToDepartment() {
        List<Teacher> expectedStoredTeachers = storedTeachers;
        List<Teacher> actualStoredTeachers = acsDepartment.getTeachers();

        assertEquals(expectedStoredTeachers, actualStoredTeachers);
    }

    @Test
    public void shouldRemoveTeacherFromDepartment_WhenRemoveTeacherFromDepartment() {
        acsDepartment.removeTeacher(holopovTeacher);

        List<Teacher> expectedStoredTeachers = emptyStoredTeachers;
        List<Teacher> actualStoredTeachers = acsDepartment.getTeachers();

        assertEquals(expectedStoredTeachers, actualStoredTeachers);
    }

    @Test
    public void shouldAddGroupToDepartment_WhenAddGroupToDepartment() {
        List<Group> expectedStoredGroups = storedGroups;
        List<Group> actualStoredGroups = acsDepartment.getGroups();

        assertEquals(expectedStoredGroups, actualStoredGroups);
    }

    @Test
    public void shouldRemoveGroupFromDepartment_WhenRemoveGroupFromDepartment() {
        acsDepartment.removeGroup(group3033);

        List<Group> expectedStoredGroups = emptyStoredGroups;
        List<Group> actualStoredGroups = acsDepartment.getGroups();

        assertEquals(expectedStoredGroups, actualStoredGroups);
    }

    @Test
    public void shouldAddSubjectToDepartment_WhenAddSubjectToDepartment() {
        List<Subject> expectedStoredSubjects = storedSubjects;
        List<Subject> actualStoredSubjects = acsDepartment.getSubjects();

        assertEquals(expectedStoredSubjects, actualStoredSubjects);
    }

    @Test
    public void shouldRemoveSubjectFromDepartment_WhenRemoveSubjectFromDepartment() {
        acsDepartment.removeSubject(plicSubject);

        List<Subject> expectedStoredSubjects = emptyStoredSubjects;
        List<Subject> actualStoredSubjects = acsDepartment.getSubjects();

        assertEquals(expectedStoredSubjects, actualStoredSubjects);
    }

    @Test
    public void shouldUpdateDepartment_WhenUpdateDepartment() {
        acsDepartment.update(updateDepartment);

        Department expectedDepartment = updateDepartment;
        Department actualDepartment = acsDepartment;

        assertEquals(expectedDepartment, actualDepartment);
    }
}