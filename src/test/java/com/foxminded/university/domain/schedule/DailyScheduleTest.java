package com.foxminded.university.domain.schedule;

import com.foxminded.university.domain.university.*;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class DailyScheduleTest {
    private Group group3033;
    private Student kabatovStudent;
    private Teacher holopovTeacher;
    private Lesson plicLesson;
    private MonthlySchedule monthlyScheduleForUniversity;
    private DailySchedule september10DailySchedule;

    private Teacher anikeevTeacher;
    private Student ivanovStudent;
    private Group group2070;
    private List<Lesson> dailyScheduleForHolopov;
    private List<Lesson> dailyScheduleForKabatov;
    private List<Lesson> dailyScheduleForGroup3033;
    private List<Lesson> dailyScheduleForAnikeev;
    private List<Lesson> dailyScheduleForIvanov;
    private List<Lesson> dailyScheduleForGroup2070;

    private List<Lesson> storedLessons;
    private List<Lesson> emptyStoredLessons;
    private DailySchedule updateDailySchedule;

    @Before
    public void setUp() throws Exception {
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

        plicLesson = new Lesson();
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

        anikeevTeacher = new Teacher();
        anikeevTeacher.setFirstName("Sergey");
        anikeevTeacher.setPatronym("Vladimirovich");
        anikeevTeacher.setLastName("Anikeev");

        DailySchedule emptyDailySchedule = new DailySchedule();
        emptyDailySchedule.setDate(LocalDate.of(2018, 9, 10));

        ivanovStudent = new Student();
        ivanovStudent.setFirstName("Ivan");
        ivanovStudent.setPatronym("Ivanovich");
        ivanovStudent.setLastName("Ivanov");

        group2070 = new Group();
        group2070.setName("2070");

        dailyScheduleForHolopov = september10DailySchedule.getLessons();
        dailyScheduleForKabatov = september10DailySchedule.getLessons();
        dailyScheduleForGroup3033 = september10DailySchedule.getLessons();

        dailyScheduleForAnikeev = emptyDailySchedule.getLessons();
        dailyScheduleForIvanov = emptyDailySchedule.getLessons();
        dailyScheduleForGroup2070 = emptyDailySchedule.getLessons();

        storedLessons = new ArrayList<>();
        storedLessons.add(plicLesson);

        emptyStoredLessons = new ArrayList<>();

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

        updateDailySchedule = new DailySchedule();
        updateDailySchedule.setDate(LocalDate.of(2018, 9, 11));
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
        List<Lesson> actualDailySchedule = september10DailySchedule.findDailySchedule(holopovTeacher);

        assertEquals(expectedDailySchedule, actualDailySchedule);
    }

    @Test
    public void shouldReturnDailyScheduleForStudent_WhenGetDailyScheduleForStudent() {
        List<Lesson> expectedDailySchedule = dailyScheduleForKabatov;
        List<Lesson> actualDailySchedule = september10DailySchedule.findDailySchedule(kabatovStudent);

        assertEquals(expectedDailySchedule, actualDailySchedule);
    }

    @Test
    public void shouldReturnDailyScheduleForGroup_WhenGetDailyScheduleForGroup() {
        List<Lesson> expectedDailySchedule = dailyScheduleForGroup3033;
        List<Lesson> actualDailySchedule = september10DailySchedule.findDailySchedule(group3033);

        assertEquals(expectedDailySchedule, actualDailySchedule);
    }

    @Test
    public void shouldReturnEmptyDailyScheduleForTeacher_WhenNotLessonsForTeacher() {
        List<Lesson> expectedDailySchedule = dailyScheduleForAnikeev;
        List<Lesson> actualDailySchedule = september10DailySchedule.findDailySchedule(anikeevTeacher);

        assertEquals(expectedDailySchedule, actualDailySchedule);
    }

    @Test
    public void shouldReturnEmptyDailyScheduleForStudent_WhenNotLessonsForStudent() {
        List<Lesson> expectedDailySchedule = dailyScheduleForIvanov;
        List<Lesson> actualDailySchedule = september10DailySchedule.findDailySchedule(ivanovStudent);

        assertEquals(expectedDailySchedule, actualDailySchedule);
    }

    @Test
    public void shouldReturnEmptyDailyScheduleForGroup_WhenNotLessonsForGroup() {
        List<Lesson> expectedMonthlySchedule = dailyScheduleForGroup2070;
        List<Lesson> actualMonthlySchedule = september10DailySchedule.findDailySchedule(group2070);

        assertEquals(expectedMonthlySchedule, actualMonthlySchedule);
    }

    @Test
    public void shouldAddLessonToDailySchedule_WhenAddLessonToDailySchedule() {
        List<Lesson> expectedStoredLessons = storedLessons;
        List<Lesson> actualStoredLessons = september10DailySchedule.getLessons();

        assertEquals(expectedStoredLessons, actualStoredLessons);
    }

    @Test
    public void shouldRemoveLessonFromDailySchedule_WhenRemoveLessonFromDailySchedule() {
        september10DailySchedule.remove(plicLesson);

        List<Lesson> expectedStoredLessons = emptyStoredLessons;
        List<Lesson> actualStoredLessons = september10DailySchedule.getLessons();

        assertEquals(expectedStoredLessons, actualStoredLessons);
    }

    @Test
    public void shouldUpdateDailySchedule_WhenUpdateDailySchedule() {
        september10DailySchedule.update(updateDailySchedule);

        DailySchedule expectedDailySchedule = updateDailySchedule;
        DailySchedule actualDailySchedule = september10DailySchedule;

        assertEquals(expectedDailySchedule, actualDailySchedule);
    }
}