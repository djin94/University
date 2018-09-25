package com.foxminded.university.domain.schedule;

import com.foxminded.university.domain.university.*;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MonthlyScheduleTest {
    private Group group3033;
    private Student kabatovStudent;
    private Teacher holopovTeacher;
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

    private List<DailySchedule> storedDailySchedules;
    private List<DailySchedule> emptyStoredDailySchedules;
    ;
    private MonthlySchedule updateMonthlySchedule;

    @Before
    public void setUp() {
        Subject plicSubject = new Subject();
        plicSubject.setName("PLIS");
        plicSubject.setHoursInSemestr(120);

        holopovTeacher = new Teacher();
        holopovTeacher.setFirstName("Sergey");
        holopovTeacher.setPatronym("Ivanovich");
        holopovTeacher.setLastName("Holopov");
        holopovTeacher.setEmployeeId(7852);
        holopovTeacher.add(plicSubject);

        kabatovStudent = new Student();
        kabatovStudent.setFirstName("Evgeny");
        kabatovStudent.setPatronym("Nikolaevich");
        kabatovStudent.setLastName("Kabatov");
        kabatovStudent.setNumberOfMarkBook(230110);

        group3033 = new Group();
        group3033.setName("3033");
        group3033.add(kabatovStudent);

        Department acsDepartment = new Department();
        acsDepartment.setName("ASU");
        acsDepartment.add(group3033);
        acsDepartment.add(holopovTeacher);
        acsDepartment.add(plicSubject);

        Audience audience313 = new Audience();
        audience313.setNumber(313);
        audience313.setBuilding(1);
        audience313.setType("Laboratory");

        Faculty faituFaculty = new Faculty();
        faituFaculty.setName("FAITU");
        faituFaculty.add(audience313);
        faituFaculty.add(acsDepartment);

        University university = new University();
        university.setName("RSREU");
        university.add(faituFaculty);

        Lesson plicLesson = new Lesson();
        plicLesson.setSubject(plicSubject);
        plicLesson.setGroup(group3033);
        plicLesson.setTeacher(holopovTeacher);
        plicLesson.setAudience(audience313);
        plicLesson.setTimeStart(LocalTime.of(9, 55));

        september10DailySchedule = new DailySchedule();
        september10DailySchedule.setDate(LocalDate.of(2018, 9, 10));
        september10DailySchedule.add(plicLesson);

        monthlyScheduleForUniversity = new MonthlySchedule();
        monthlyScheduleForUniversity.setMonth(9);
        monthlyScheduleForUniversity.setYear(2018);
        monthlyScheduleForUniversity.add(september10DailySchedule);

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

        storedDailySchedules = new ArrayList<>();
        storedDailySchedules.add(september10DailySchedule);

        emptyStoredDailySchedules = new ArrayList<>();

        University updateUniversity = new University();
        updateUniversity.setName("Moscow Institute of Physics and Technology ");

        Faculty updateFaculty = new Faculty();
        updateFaculty.setName("General and applied physics");

        Department updateDepartment = new Department();
        updateDepartment.setName("High energy physics");

        Group updateGroup = group2070;
        Teacher updateTeacher = anikeevTeacher;

        Subject updateSubject = new Subject();
        updateSubject.setName("The quantum physics");

        Audience updateAudience = new Audience();
        updateAudience.setNumber(255);
        updateAudience.setBuilding(1);

        updateMonthlySchedule = new MonthlySchedule();
    }

    @Test
    public void shouldReturnMonthlyScheduleForTeacher_WhenGetMonthlyScheduleForTeacher() {
        List<DailySchedule> expectedMonthlySchedule = monthlyScheduleForHolopov;
        List<DailySchedule> actualMonthlySchedule = monthlyScheduleForUniversity.findMonthlySchedule(holopovTeacher);

        assertEquals(expectedMonthlySchedule, actualMonthlySchedule);
    }

    @Test
    public void shouldReturnMonthlyScheduleForStudent_WhenGetMonthlyScheduleForStudent() {
        List<DailySchedule> expectedMonthlySchedule = monthlyScheduleForKabatov;
        List<DailySchedule> actualMonthlySchedule = monthlyScheduleForUniversity.findMonthlySchedule(kabatovStudent);

        assertEquals(expectedMonthlySchedule, actualMonthlySchedule);
    }

    @Test
    public void shouldReturnMonthlyScheduleForGroup_WhenGetMonthlyScheduleForGroup() {
        List<DailySchedule> expectedMonthlySchedule = monthlyScheduleForGroup3033;
        List<DailySchedule> actualMonthlySchedule = monthlyScheduleForUniversity.findMonthlySchedule(group3033);

        assertEquals(expectedMonthlySchedule, actualMonthlySchedule);
    }

    @Test
    public void shouldReturnEmptyMonthlyScheduleForTeacher_WhenNotLessonsForTeacher() {
        List<DailySchedule> expectedMonthlySchedule = monthlyScheduleForAnikeev;
        List<DailySchedule> actualMonthlySchedule = monthlyScheduleForUniversity.findMonthlySchedule(anikeevTeacher);

        assertEquals(expectedMonthlySchedule, actualMonthlySchedule);
    }

    @Test
    public void shouldReturnEmptyMonthlyScheduleForStudent_WhenNotLessonsForStudent() {
        List<DailySchedule> expectedMonthlySchedule = monthlyScheduleForIvanov;
        List<DailySchedule> actualMonthlySchedule = monthlyScheduleForUniversity.findMonthlySchedule(ivanovStudent);

        assertEquals(expectedMonthlySchedule, actualMonthlySchedule);
    }

    @Test
    public void shouldReturnEmptyMonthlyScheduleForGroup_WhenNotLessonsForGroup() {
        List<DailySchedule> expectedMonthlySchedule = monthlyScheduleForGroup2070;
        List<DailySchedule> actualMonthlySchedule = monthlyScheduleForUniversity.findMonthlySchedule(group2070);

        assertEquals(expectedMonthlySchedule, actualMonthlySchedule);
    }

    @Test
    public void shouldAddDailyScheduleToMonthlySchedule_WhenAddDailyScheduleToMonthlySchedule() {
        List<DailySchedule> expectedStoredDailySchedule = storedDailySchedules;
        List<DailySchedule> actualStoredDailySchedules = monthlyScheduleForUniversity.getDailySchedules();

        assertEquals(expectedStoredDailySchedule, actualStoredDailySchedules);
    }

    @Test
    public void shouldRemoveDailyScheduleFromMonthlySchedule_WhenRemoveDailyScheduleFromMonthlySchedule() {
        monthlyScheduleForUniversity.remove(september10DailySchedule);

        List<DailySchedule> expectedStoredDailySchedule = emptyStoredDailySchedules;
        List<DailySchedule> actualStoredDailySchedules = monthlyScheduleForUniversity.getDailySchedules();

        assertEquals(expectedStoredDailySchedule, actualStoredDailySchedules);
    }

    @Test
    public void shouldUpdateMonthlySchedule_WhenUpdateMonthlySchedule() {
        monthlyScheduleForUniversity.update(updateMonthlySchedule);

        MonthlySchedule expectedMonthlySchedule = updateMonthlySchedule;
        MonthlySchedule actualMonthlySchedule = monthlyScheduleForUniversity;

        assertEquals(expectedMonthlySchedule, actualMonthlySchedule);
    }
}