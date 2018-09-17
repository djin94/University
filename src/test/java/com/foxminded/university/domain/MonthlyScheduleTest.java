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

public class MonthlyScheduleTest {
    private University university;
    private Faculty faituFaculty;
    private Audience audience313;
    private Department acsDepartment;
    private Group group3033;
    private Student kabatovStudent;
    private Teacher holopovTeacher;
    private Subject plicSubject;
    private MonthlySchedule monthlyScheduleForUniversity;
    private Lesson plicLesson;
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

        sep10DailySchedule = new DailySchedule();
        sep10DailySchedule.setDate(LocalDate.of(2018, 9, 10));
        sep10DailySchedule.addLesson(plicLesson);

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
    public void shouldReturnEmptyMonthlyScheduleForStudent_WhenNotLessonsForStudent() {
        List<DailySchedule> expectedMonthlySchedule = monthlyScheduleForIvanov;
        List<DailySchedule> actualMonthlySchedule = monthlyScheduleForUniversity.getMonthlyScheduleForStudent(ivanovStudent);

        assertArrayEquals(expectedMonthlySchedule.toArray(), actualMonthlySchedule.toArray());
    }

    @Test
    public void shouldReturnEmptyMonthlyScheduleForGroup_WhenNotLessonsForGroup() {
        List<DailySchedule> expectedMonthlySchedule = monthlyScheduleForGroup2070;
        List<DailySchedule> actualMonthlySchedule = monthlyScheduleForUniversity.getMonthlyScheduleForGroup(group2070);

        assertArrayEquals(expectedMonthlySchedule.toArray(), actualMonthlySchedule.toArray());
    }

    @Test
    public void shouldReturnDailySchedule_WhenInvokeDailyScheduleByDate() {
        DailySchedule expectedDailySchedule = sep10DailySchedule;
        DailySchedule actualDailySchedule = monthlyScheduleForUniversity.getDailySchedule(LocalDate.of(2018, 9, 10));

        assertEquals(expectedDailySchedule, actualDailySchedule);
    }

    @Test
    public void shouldReturnEmptyDailySchedule_WhenNotDailyScheduleForDate() {
        DailySchedule expectedDailySchedule = DailySchedule.EMPTY_DAILYSCHEDULE;
        DailySchedule actualDailySchedule = monthlyScheduleForUniversity.getDailySchedule(LocalDate.of(2018, 9, 11));

        assertEquals(expectedDailySchedule, actualDailySchedule);
    }
}