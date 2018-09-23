package com.foxminded.university.domain;

import com.foxminded.university.domain.schedule.DailySchedule;
import com.foxminded.university.domain.schedule.Lesson;
import com.foxminded.university.domain.schedule.MonthlySchedule;
import com.foxminded.university.domain.university.*;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UniversityTest {
    private University university;
    private Faculty faituFaculty;
    private Audience audience313;
    private Department acsDepartment;
    private Group group3033;
    private Subject plicSubject;
    private Student kabatovStudent;
    private Teacher holopovTeacher;

    private List<Faculty> storedFaculties;
    private List<Faculty> emptyStoredFaculties;
    private List<Department> storedDepartments;
    private List<Department> emptyStoredDepartments;
    private List<Audience> storedAudiences;
    private List<Audience> emptyStoredAudiences;
    private List<Teacher> storedTeachers;
    private List<Teacher> emptyStoredTeachers;
    private List<Group> storedGroups;
    private List<Group> emptyStoredGroups;
    private List<Subject> storedSubjects;
    private List<Subject> emptyStoredSubjects;
    private List<Student> storedStudents;
    private List<Student> emptyStoredStudents;

    private University updateUniversity;
    private Faculty updateFaculty;
    private Department updateDepartment;
    private Group updateGroup;
    private Student updateStudent;
    private Teacher updateTeacher;
    private Subject updateSubject;
    private Audience updateAudience;

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

        kabatovStudent = new Student();
        kabatovStudent.setFirstName("Evgeny");
        kabatovStudent.setPatronym("Nikolaevich");
        kabatovStudent.setLastName("Kabatov");
        kabatovStudent.setNumberOfMarkBook(230110);

        group3033 = new Group();
        group3033.setName("3033");
        group3033.addStudent(kabatovStudent);

        acsDepartment = new Department();
        acsDepartment.setName("ASU");
        acsDepartment.addGroup(group3033);
        acsDepartment.addTeacher(holopovTeacher);
        acsDepartment.addSubject(plicSubject);

        audience313 = new Audience();
        audience313.setNumber(313);
        audience313.setBuilding(1);
        audience313.setType("Laboratory");

        faituFaculty = new Faculty();
        faituFaculty.setName("FAITU");
        faituFaculty.addAudience(audience313);
        faituFaculty.addDepartment(acsDepartment);

        university = new University();
        university.setName("RSREU");
        university.addFaculty(faituFaculty);

        storedFaculties = new ArrayList<>();
        storedFaculties.add(faituFaculty);

        emptyStoredFaculties = new ArrayList<>();

        storedDepartments = new ArrayList<>();
        storedDepartments.add(acsDepartment);

        emptyStoredDepartments = new ArrayList<>();

        storedAudiences = new ArrayList<>();
        storedAudiences.add(audience313);

        emptyStoredAudiences = new ArrayList<>();

        storedTeachers = new ArrayList<>();
        storedTeachers.add(holopovTeacher);

        emptyStoredTeachers = new ArrayList<>();

        storedGroups = new ArrayList<>();
        storedGroups.add(group3033);

        emptyStoredGroups = new ArrayList<>();

        storedSubjects = new ArrayList<>();
        storedSubjects.add(plicSubject);

        emptyStoredSubjects = new ArrayList<>();

        storedStudents = new ArrayList<>();
        storedStudents.add(kabatovStudent);

        emptyStoredStudents = new ArrayList<>();

        updateUniversity = new University();
        updateUniversity.setName("Moscow Institute of Physics and Technology ");

        updateFaculty = new Faculty();
        updateFaculty.setName("General and applied physics");

        updateDepartment = new Department();
        updateDepartment.setName("High energy physics");

        updateGroup = new Group();
        updateGroup.setName("2070");

        updateStudent = new Student();
        updateStudent.setFirstName("Ivan");
        updateStudent.setPatronym("Ivanovich");

        updateTeacher = new Teacher();
        updateTeacher.setFirstName("Sergey");
        updateTeacher.setPatronym("Vladimirovich");
        updateTeacher.setLastName("Anikeev");

        updateSubject = new Subject();
        updateSubject.setName("The quantum physics");

        updateAudience = new Audience();
        updateAudience.setNumber(255);
        updateAudience.setBuilding(1);
    }
    @Test
    public void shouldAddFacultyToUniversity_WhenAddFacultyToUniversity() {
        List<Faculty> expectedFaculties = storedFaculties;
        List<Faculty> actualStoredFaculties = university.getFaculties();

        assertEquals(expectedFaculties, actualStoredFaculties);
    }

    @Test
    public void shouldRemoveFacultyFromUniversity_WhenRemoveFacultyFromUniversity() {
        university.removeFaculty(faituFaculty);

        List<Faculty> expectedFaculties = emptyStoredFaculties;
        List<Faculty> actualStoredFaculties = university.getFaculties();

        assertEquals(expectedFaculties, actualStoredFaculties);
    }

    @Test
    public void shouldAddAudienceToFaculty_WhenAddAudienceToFaculty() {
        List<Audience> expectedAudiences = storedAudiences;
        List<Audience> actualStoredAudiences = faituFaculty.getAudiences();

        assertEquals(expectedAudiences, actualStoredAudiences);
    }

    @Test
    public void shouldRemoveAudienceFromFaculty_WhenRemoveAudienceFromFaculty() {
        faituFaculty.removeAudience(audience313);

        List<Audience> expectedAudiences = emptyStoredAudiences;
        List<Audience> actualStoredAudiences = faituFaculty.getAudiences();

        assertEquals(expectedAudiences, actualStoredAudiences);
    }

    @Test
    public void shouldAddDepartmentToFaculty_WhenAddDepartmentToFaculty() {
        List<Department> expectedDepartments = storedDepartments;
        List<Department> actualStoredDepartments = faituFaculty.getDepartments();

        assertEquals(expectedDepartments, actualStoredDepartments);
    }

    @Test
    public void shouldRemoveDepartmentFromFaculty_WhenRemoveDepartmentFromFaculty() {
        faituFaculty.removeDepartment(acsDepartment);

        List<Department> expectedDepartments = emptyStoredDepartments;
        List<Department> actualStoredDepartments = faituFaculty.getDepartments();

        assertEquals(expectedDepartments, actualStoredDepartments);
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
    public void shouldAddStudentToDepartment_WhenAddStudentToDepartment() {
        List<Student> expectedStoredStudents = storedStudents;
        List<Student> actualStoredStudents = group3033.getStudents();

        assertEquals(expectedStoredStudents, actualStoredStudents);
    }

    @Test
    public void shouldRemoveStudentFromDepartment_WhenRemoveStudentFromDepartment() {
        group3033.removeStudent(kabatovStudent);

        List<Student> expectedStoredStudents = emptyStoredStudents;
        List<Student> actualStoredStudents = group3033.getStudents();

        assertEquals(expectedStoredStudents, actualStoredStudents);
    }

    @Test
    public void shouldAddSubjectToTeacher_WhenAddSubjectToTeacher() {
        List<Subject> expectedStoredSubjects = storedSubjects;
        List<Subject> actualStoredSubjects = acsDepartment.getSubjects();

        assertEquals(expectedStoredSubjects, actualStoredSubjects);
    }

    @Test
    public void shouldRemoveSubjectFromTeacher_WhenRemoveSubjectFromTeacher() {
        acsDepartment.removeSubject(plicSubject);

        List<Subject> expectedStoredSubjects = emptyStoredSubjects;
        List<Subject> actualStoredSubjects = acsDepartment.getSubjects();

        assertEquals(expectedStoredSubjects, actualStoredSubjects);
    }

    @Test
    public void shouldUpdateUniversity_WhenUpdateUniversity() {
        university.update(updateUniversity);

        University expectedUniversity = updateUniversity;
        University actualUniversity = university;

        assertEquals(expectedUniversity, actualUniversity);
    }

    @Test
    public void shouldUpdateFaculty_WhenUpdateFaculty() {
        faituFaculty.update(updateFaculty);

        Faculty expectedFaculty = updateFaculty;
        Faculty actualFaculty = faituFaculty;

        assertEquals(expectedFaculty, actualFaculty);
    }

    @Test
    public void shouldUpdateDepartment_WhenUpdateDepartment() {
        acsDepartment.update(updateDepartment);

        Department expectedDepartment = updateDepartment;
        Department actualDepartment = acsDepartment;

        assertEquals(expectedDepartment, actualDepartment);
    }

    @Test
    public void shouldUpdateGroup_WhenUpdateGroup() {
        group3033.update(updateGroup);

        Group expectedGroup = updateGroup;
        Group actualGroup = group3033;

        assertEquals(expectedGroup, actualGroup);
    }

    @Test
    public void shouldUpdateTeacher_WhenUpdateTeacher() {
        holopovTeacher.update(updateTeacher);

        Teacher expectedTeacher = updateTeacher;
        Teacher actualTeacher = holopovTeacher;

        assertEquals(expectedTeacher, actualTeacher);
    }

    @Test
    public void shouldUpdateStudent_WhenUpdateStudent() {
        kabatovStudent.update(updateStudent);

        Student expectedStudent = updateStudent;
        Student actualStudent = kabatovStudent;

        assertEquals(expectedStudent, actualStudent);
    }

    @Test
    public void shouldUpdateSubject_WhenUpdateSubject() {
        plicSubject.update(updateSubject);

        Subject expectedSubject = updateSubject;
        Subject actualSubject = plicSubject;

        assertEquals(expectedSubject, actualSubject);
    }

    @Test
    public void shouldUpdateAudience_WhenUpdateAudience() {
        audience313.update(updateAudience);

        Audience expectedAudience = updateAudience;
        Audience actualAudience = audience313;

        assertEquals(expectedAudience, actualAudience);
    }
}