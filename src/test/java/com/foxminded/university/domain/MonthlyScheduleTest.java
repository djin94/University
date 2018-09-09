package com.foxminded.university.domain;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MonthlyScheduleTest {
    private University university;
    private Faculty faituFaculty;
    private Audience audience313;
    private Department asuDepartment;
    private Group group3033;
    private Student kabatovStudent;
    private Teacher holopovTeacher;
    private Subject plisSubject;
    private MonthlySchedule monthlyScheduleForUniversity;
    private Lesson plisLesson;
    private DailySchedule sep10DailySchedule;

    private List<DailySchedule> monthlyScheduleForHolopov;
    private List<DailySchedule> monthlyScheduleForKabatov;
    private List<DailySchedule> monthlyScheduleForGroup3033;
    private Teacher anikeevTeacher;
    private List<DailySchedule> monthlyScheduleForAnikeev;
    private Student ivanovStudent;
    private List<DailySchedule> monthlyScheduleForIvanov;
    private Group group2070;
    private List<DailySchedule> monthlyScheduleForGroup2070;
    private DailySchedule emptyDailySchedule;

    @Before
    public void setUp() {
        plisSubject = new Subject();
        plisSubject.setName("PLIS");
        plisSubject.setHoursInSemestr(120);

        holopovTeacher = new Teacher();
        holopovTeacher.setFirstName("Sergey");
        holopovTeacher.setPatronym("Ivanovich");
        holopovTeacher.setLastName("Holopov");
        holopovTeacher.addSubject(plisSubject);

        kabatovStudent = new Student();
        kabatovStudent.setFirstName("Evgeny");
        kabatovStudent.setPatronym("Nikolaevich");
        kabatovStudent.setLastName("Kabatov");
        kabatovStudent.setNumberOfMarkBook(230110);

        group3033 = new Group();
        group3033.setName("3033");
        group3033.addStudent(kabatovStudent);

        asuDepartment = new Department();
        asuDepartment.setName("ASU");
        asuDepartment.addGroup(group3033);
        asuDepartment.addTeacher(holopovTeacher);
        asuDepartment.addSubject(plisSubject);

        audience313 = new Audience();
        audience313.setNumber(313);
        audience313.setBuilding(1);
        audience313.setType("Laboratory");

        faituFaculty = new Faculty();
        faituFaculty.setName("FAITU");
        faituFaculty.addAudience(audience313);
        faituFaculty.addDepartment(asuDepartment);

        university = new University();
        university.setName("RSREU");
        university.addFaculty(faituFaculty);

        plisLesson = new Lesson();
        plisLesson.setSubject(plisSubject);
        plisLesson.setGroup(group3033);
        plisLesson.setTeacher(holopovTeacher);
        plisLesson.setAudience(audience313);
        plisLesson.setTimeStart(LocalTime.of(9, 55));

        sep10DailySchedule = new DailySchedule();
        sep10DailySchedule.setDate(LocalDate.of(2018, 9, 10));
        sep10DailySchedule.addLesson(plisLesson);

        monthlyScheduleForUniversity = new MonthlySchedule();
        monthlyScheduleForUniversity.setMonth(9);
        monthlyScheduleForUniversity.setYear(2018);
        monthlyScheduleForUniversity.addDailySchedule(sep10DailySchedule);

        monthlyScheduleForHolopov = new ArrayList<>();
        monthlyScheduleForHolopov.add(sep10DailySchedule);

        monthlyScheduleForKabatov = new ArrayList<>();
        monthlyScheduleForKabatov.add(sep10DailySchedule);

        monthlyScheduleForGroup3033 = new ArrayList<>();
        monthlyScheduleForGroup3033.add(sep10DailySchedule);

        anikeevTeacher = new Teacher();
        anikeevTeacher.setFirstName("Sergey");
        anikeevTeacher.setPatronym("Vladimirovich");
        anikeevTeacher.setLastName("Anikeev");

        emptyDailySchedule = new DailySchedule();
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
    }

    @Test
    public void shouldReturnMonthlyScheduleForTeacher_WhenInvokeMonthlyScheduleForTeacher() {
        List<DailySchedule> expectedMonthlySchedule = monthlyScheduleForHolopov;
        List<DailySchedule> actualMonthlySchedule = monthlyScheduleForUniversity.getMonthlyScheduleForTeacher(holopovTeacher);

        assertArrayEquals(expectedMonthlySchedule.toArray(), actualMonthlySchedule.toArray());
    }

    @Test
    public void shouldReturnMonthlyScheduleForStudent_WhenInvokeMonthlyScheduleForStudent() {
        List<DailySchedule> expectedMonthlySchedule = monthlyScheduleForKabatov;
        List<DailySchedule> actualMonthlySchedule = monthlyScheduleForUniversity.getMonthlyScheduleForStudent(kabatovStudent);

        assertArrayEquals(expectedMonthlySchedule.toArray(), actualMonthlySchedule.toArray());
    }

    @Test
    public void shouldReturnMonthlyScheduleForGroup_WhenInvokeMonthlyScheduleForGroup() {
        List<DailySchedule> expectedMonthlySchedule = monthlyScheduleForGroup3033;
        List<DailySchedule> actualMonthlySchedule = monthlyScheduleForUniversity.getMonthlyScheduleForGroup(group3033);

        assertArrayEquals(expectedMonthlySchedule.toArray(), actualMonthlySchedule.toArray());
    }

    @Test
    public void shouldReturnEmptyMonthlyScheduleForTeacher_WhenNotLessonsForTeacher() {
        List<DailySchedule> expectedMonthlySchedule = monthlyScheduleForAnikeev;
        List<DailySchedule> actualMonthlySchedule = monthlyScheduleForUniversity.getMonthlyScheduleForTeacher(anikeevTeacher);

        assertArrayEquals(expectedMonthlySchedule.toArray(), actualMonthlySchedule.toArray());
    }

    @Test
    public void shouldReturnEmptyMonthlyScheduleForStudent_WhenNotLessonsForStudent(){
        List<DailySchedule> expectedMonthlySchedule = monthlyScheduleForIvanov;
        List<DailySchedule> actualMonthlySchedule = monthlyScheduleForUniversity.getMonthlyScheduleForStudent(ivanovStudent);

        assertArrayEquals(expectedMonthlySchedule.toArray(), actualMonthlySchedule.toArray());
    }

    @Test
    public void shouldReturnEmptyMonthlyScheduleForGroup_WhenNotLessonsForGroup(){
        List<DailySchedule> expectedMonthlySchedule = monthlyScheduleForGroup2070;
        List<DailySchedule> actualMonthlySchedule = monthlyScheduleForUniversity.getMonthlyScheduleForGroup(group2070);

        assertArrayEquals(expectedMonthlySchedule.toArray(), actualMonthlySchedule.toArray());
    }
}