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
    private MonthlySchedule monthlySchedule;
    private Lesson plisLesson;
    private DailySchedule sep10DailySchedule;

    private List<DailySchedule> monthlyScheduleForHolopov;
    private List<DailySchedule> monthlyScheduleForKabatov;

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

        monthlySchedule = new MonthlySchedule();
        monthlySchedule.setMonth(9);
        monthlySchedule.setYear(2018);
        monthlySchedule.addDailySchedule(sep10DailySchedule);

        monthlyScheduleForHolopov = new ArrayList<>();
        monthlyScheduleForHolopov.add(sep10DailySchedule);

        monthlyScheduleForKabatov = new ArrayList<>();
        monthlyScheduleForKabatov.add(sep10DailySchedule);
    }

    @Test
    public void shouldReturnMonthlyScheduleForTeacher_WhenInvokeMonthlyScheduleForTeacher() {
        List<DailySchedule> expectedMonthlySchedule = monthlyScheduleForHolopov;
        List<DailySchedule> actualMonthlySchedule = monthlySchedule.getMonthlyScheduleForTeacher(holopovTeacher);

        assertArrayEquals(expectedMonthlySchedule.toArray(), actualMonthlySchedule.toArray());
    }

    @Test
    public void shouldReturnMonthlyScheduleForStudent_WhenInvokeMonthlyScheduleForStudent(){
        List<DailySchedule> expectedMonthlySchedule = monthlyScheduleForKabatov;
        List<DailySchedule> actualMonthlySchedule = monthlySchedule.getMonthlyScheduleForStudent(kabatovStudent);

        assertArrayEquals(expectedMonthlySchedule.toArray(),actualMonthlySchedule.toArray());
    }
}