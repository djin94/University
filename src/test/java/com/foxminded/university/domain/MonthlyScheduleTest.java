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
import java.util.Optional;

import static org.junit.Assert.*;

public class MonthlyScheduleTest {
    private University university;
    private Faculty faituFaculty;
    private Audience audience313;
    private Department acsDepartment;
    private Group group3033;
    private Subject plicSubject;
    private Student kabatovStudent;
    private Teacher holopovTeacher;
    private Lesson plicLesson;
    private MonthlySchedule monthlyScheduleForUniversity;
    private DailySchedule september10DailySchedule;

    private List<DailySchedule> monthlyScheduleForHolopov;
    private List<DailySchedule> monthlyScheduleForKabatov;
    private List<DailySchedule> monthlyScheduleForGroup3033;
    private Teacher anikeevTeacher;
    private List<DailySchedule> monthlyScheduleForAnikeev;
    private Student ivanovStudent;
    private List<DailySchedule> monthlyScheduleForIvanov;
    private Group group2070;
    private List<DailySchedule> monthlyScheduleForGroup2070;
    private List<Lesson> dailyScheduleForHolopov;
    private List<Lesson> dailyScheduleForKabatov;
    private List<Lesson> dailyScheduleForGroup3033;
    private List<Lesson> dailyScheduleForAnikeev;
    private List<Lesson> dailyScheduleForIvanov;
    private List<Lesson> dailyScheduleForGroup2070;

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

        plicLesson = new Lesson();
        plicLesson.setSubject(plicSubject);
        plicLesson.setGroup(group3033);
        plicLesson.setTeacher(holopovTeacher);
        plicLesson.setAudience(audience313);
        plicLesson.setTimeStart(LocalTime.of(9, 55));

        september10DailySchedule = new DailySchedule();
        september10DailySchedule.setDate(LocalDate.of(2018, 9, 10));
        september10DailySchedule.addLesson(plicLesson);

        monthlyScheduleForUniversity = new MonthlySchedule();
        monthlyScheduleForUniversity.setMonth(9);
        monthlyScheduleForUniversity.setYear(2018);
        monthlyScheduleForUniversity.addDailySchedule(september10DailySchedule);

        monthlyScheduleForHolopov = new ArrayList<>();
        monthlyScheduleForHolopov.add(september10DailySchedule);

        monthlyScheduleForKabatov = new ArrayList<>();
        monthlyScheduleForKabatov.add(september10DailySchedule);

        monthlyScheduleForGroup3033 = new ArrayList<>();
        monthlyScheduleForGroup3033.add(september10DailySchedule);

        anikeevTeacher = new Teacher();
        anikeevTeacher.setFirstName("Sergey");
        anikeevTeacher.setPatronym("Vladimirovich");
        anikeevTeacher.setLastName("Anikeev");

        DailySchedule emptyDailySchedule = new DailySchedule();
        emptyDailySchedule.setDate(LocalDate.of(2018, 9, 10));

        monthlyScheduleForAnikeev = new ArrayList<>();
        monthlyScheduleForAnikeev.add(emptyDailySchedule);

        ivanovStudent = new Student();
        ivanovStudent.setFirstName("Ivan");
        ivanovStudent.setPatronym("Ivanovich");
        ivanovStudent.setLastName("Ivanov");

        monthlyScheduleForIvanov = new ArrayList<>();
        monthlyScheduleForIvanov.add(emptyDailySchedule);

        group2070 = new Group();
        group2070.setName("2070");

        monthlyScheduleForGroup2070 = new ArrayList<>();
        monthlyScheduleForGroup2070.add(emptyDailySchedule);

        dailyScheduleForHolopov = september10DailySchedule.getLessons();
        dailyScheduleForKabatov = september10DailySchedule.getLessons();
        dailyScheduleForGroup3033 = september10DailySchedule.getLessons();

        dailyScheduleForAnikeev = emptyDailySchedule.getLessons();
        dailyScheduleForIvanov = emptyDailySchedule.getLessons();
        dailyScheduleForGroup2070 = emptyDailySchedule.getLessons();

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
    }

    @Test
    public void shouldReturnMonthlyScheduleForTeacher_WhenGetMonthlyScheduleForTeacher() {
        List<DailySchedule> expectedMonthlySchedule = monthlyScheduleForHolopov;
        List<DailySchedule> actualMonthlySchedule = monthlyScheduleForUniversity.getMonthlyScheduleForTeacher(holopovTeacher);

        assertEquals(expectedMonthlySchedule, actualMonthlySchedule);
    }

    @Test
    public void shouldReturnMonthlyScheduleForStudent_WhenGetMonthlyScheduleForStudent() {
        List<DailySchedule> expectedMonthlySchedule = monthlyScheduleForKabatov;
        List<DailySchedule> actualMonthlySchedule = monthlyScheduleForUniversity.getMonthlyScheduleForStudent(kabatovStudent);

        assertEquals(expectedMonthlySchedule, actualMonthlySchedule);
    }

    @Test
    public void shouldReturnMonthlyScheduleForGroup_WhenGetMonthlyScheduleForGroup() {
        List<DailySchedule> expectedMonthlySchedule = monthlyScheduleForGroup3033;
        List<DailySchedule> actualMonthlySchedule = monthlyScheduleForUniversity.getMonthlyScheduleForGroup(group3033);

        assertEquals(expectedMonthlySchedule, actualMonthlySchedule);
    }

    @Test
    public void shouldReturnEmptyMonthlyScheduleForTeacher_WhenNotLessonsForTeacher() {
        List<DailySchedule> expectedMonthlySchedule = monthlyScheduleForAnikeev;
        List<DailySchedule> actualMonthlySchedule = monthlyScheduleForUniversity.getMonthlyScheduleForTeacher(anikeevTeacher);

        assertEquals(expectedMonthlySchedule, actualMonthlySchedule);
    }

    @Test
    public void shouldReturnEmptyMonthlyScheduleForStudent_WhenNotLessonsForStudent() {
        List<DailySchedule> expectedMonthlySchedule = monthlyScheduleForIvanov;
        List<DailySchedule> actualMonthlySchedule = monthlyScheduleForUniversity.getMonthlyScheduleForStudent(ivanovStudent);

        assertEquals(expectedMonthlySchedule, actualMonthlySchedule);
    }

    @Test
    public void shouldReturnEmptyMonthlyScheduleForGroup_WhenNotLessonsForGroup() {
        List<DailySchedule> expectedMonthlySchedule = monthlyScheduleForGroup2070;
        List<DailySchedule> actualMonthlySchedule = monthlyScheduleForUniversity.getMonthlyScheduleForGroup(group2070);

        assertEquals(expectedMonthlySchedule, actualMonthlySchedule);
    }

    @Test
    public void shouldReturnDailySchedule_WhenGetDailyScheduleByDate() {
        DailySchedule expectedDailySchedule = september10DailySchedule;
        DailySchedule actualDailySchedule = monthlyScheduleForUniversity.getDailySchedule(LocalDate.of(2018, 9, 10)).get();

        assertEquals(expectedDailySchedule, actualDailySchedule);
    }

    @Test
    public void shouldReturnEmptyDailySchedule_WhenNotDailyScheduleForDate() {
        Optional<DailySchedule> expectedDailySchedule = Optional.empty();
        Optional<DailySchedule> actualDailySchedule = monthlyScheduleForUniversity.getDailySchedule(LocalDate.of(2018, 9, 11));

        assertEquals(expectedDailySchedule, actualDailySchedule);
    }

    @Test
    public void shouldReturnDailyScheduleForTeacher_WhenGetDailyScheduleForTeacher() {
        List<Lesson> expectedDailySchedule = dailyScheduleForHolopov;
        List<Lesson> actualDailySchedule = september10DailySchedule.getDailyScheduleForTeacher(holopovTeacher);

        assertEquals(expectedDailySchedule, actualDailySchedule);
    }

    @Test
    public void shouldReturnDailyScheduleForStudent_WhenGetDailyScheduleForStudent() {
        List<Lesson> expectedDailySchedule = dailyScheduleForKabatov;
        List<Lesson> actualDailySchedule = september10DailySchedule.getDailyScheduleForStudent(kabatovStudent);

        assertEquals(expectedDailySchedule, actualDailySchedule);
    }

    @Test
    public void shouldReturnDailyScheduleForGroup_WhenGetDailyScheduleForGroup() {
        List<Lesson> expectedDailySchedule = dailyScheduleForGroup3033;
        List<Lesson> actualDailySchedule = september10DailySchedule.getDailyScheduleForGroup(group3033);

        assertEquals(expectedDailySchedule, actualDailySchedule);
    }

    @Test
    public void shouldReturnEmptyDailyScheduleForTeacher_WhenNotLessonsForTeacher() {
        List<Lesson> expectedDailySchedule = dailyScheduleForAnikeev;
        List<Lesson> actualDailySchedule = september10DailySchedule.getDailyScheduleForTeacher(anikeevTeacher);

        assertEquals(expectedDailySchedule, actualDailySchedule);
    }

    @Test
    public void shouldReturnEmptyDailyScheduleForStudent_WhenNotLessonsForStudent() {
        List<Lesson> expectedDailySchedule = dailyScheduleForIvanov;
        List<Lesson> actualDailySchedule = september10DailySchedule.getDailyScheduleForStudent(ivanovStudent);

        assertEquals(expectedDailySchedule, actualDailySchedule);
    }

    @Test
    public void shouldReturnEmptyDailyScheduleForGroup_WhenNotLessonsForGroup() {
        List<Lesson> expectedMonthlySchedule = dailyScheduleForGroup2070;
        List<Lesson> actualMonthlySchedule = september10DailySchedule.getDailyScheduleForGroup(group2070);

        assertEquals(expectedMonthlySchedule, actualMonthlySchedule);
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
}