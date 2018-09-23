package com.foxminded.university.console;

import com.foxminded.university.domain.schedule.DailySchedule;
import com.foxminded.university.domain.schedule.Lesson;
import com.foxminded.university.domain.schedule.MonthlySchedule;
import com.foxminded.university.domain.university.*;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.Assert.*;

public class UniversityStorageTest {
    private Group group3033;
    private Student kabatovStudent;
    private Teacher holopovTeacher;
    private Teacher anikeevTeacher;
    private Student ivanovStudent;
    private Group group2070;

    private DailySchedule dailyScheduleForTeacher;
    private DailySchedule dailyScheduleForStudent;
    private DailySchedule dailyScheduleForGroup;

    private DailySchedule emptyDailySchedule;

    @Before
    public void setUp() {
        Subject programmingOfLogicIntegratedCircuitsSubject = new Subject();
        programmingOfLogicIntegratedCircuitsSubject.setName("Programming of logic integrated circuits");
        programmingOfLogicIntegratedCircuitsSubject.setHoursInSemestr(120);

        holopovTeacher = new Teacher();
        holopovTeacher.setFirstName("Sergey");
        holopovTeacher.setPatronym("Ivanovich");
        holopovTeacher.setLastName("Holopov");
        holopovTeacher.setEmployeeId(7852);
        holopovTeacher.addSubject(programmingOfLogicIntegratedCircuitsSubject);

        kabatovStudent = new Student();
        kabatovStudent.setFirstName("Evgeny");
        kabatovStudent.setPatronym("Nikolaevich");
        kabatovStudent.setLastName("Kabatov");
        kabatovStudent.setNumberOfMarkBook(230110);

        group3033 = new Group();
        group3033.setName("3033");
        group3033.addStudent(kabatovStudent);

        Department acsDepartment = new Department();
        acsDepartment.setName("ASU");
        acsDepartment.addGroup(group3033);
        acsDepartment.addTeacher(holopovTeacher);
        acsDepartment.addSubject(programmingOfLogicIntegratedCircuitsSubject);

        Audience audience313 = new Audience();
        audience313.setNumber(313);
        audience313.setBuilding(1);
        audience313.setType("Laboratory");

        Faculty faituFaculty = new Faculty();
        faituFaculty.setName("FAITU");
        faituFaculty.addAudience(audience313);
        faituFaculty.addDepartment(acsDepartment);

        University university = new University();
        university.setName("RSREU");
        university.addFaculty(faituFaculty);

        Lesson plicLesson = new Lesson();
        plicLesson.setSubject(programmingOfLogicIntegratedCircuitsSubject);
        plicLesson.setGroup(group3033);
        plicLesson.setTeacher(holopovTeacher);
        plicLesson.setAudience(audience313);
        plicLesson.setTimeStart(LocalTime.of(9, 55));

        Subject informationSystemsSoftwareSubject = new Subject();
        informationSystemsSoftwareSubject.setName("Information systems software");
        informationSystemsSoftwareSubject.setHoursInSemestr(116);

        Lesson informationSystemsSoftwareLesson = new Lesson();
        informationSystemsSoftwareLesson.setSubject(informationSystemsSoftwareSubject);
        informationSystemsSoftwareLesson.setGroup(group3033);
        informationSystemsSoftwareLesson.setTeacher(holopovTeacher);
        informationSystemsSoftwareLesson.setAudience(audience313);
        informationSystemsSoftwareLesson.setTimeStart(LocalTime.of(11, 40));

        DailySchedule september10DailySchedule = new DailySchedule();
        september10DailySchedule.setDate(LocalDate.of(2018, 9, 10));
        september10DailySchedule.addLesson(plicLesson);
        september10DailySchedule.addLesson(informationSystemsSoftwareLesson);

        dailyScheduleForTeacher = september10DailySchedule;
        dailyScheduleForGroup = september10DailySchedule;
        dailyScheduleForStudent = september10DailySchedule;

        anikeevTeacher = new Teacher();
        anikeevTeacher.setFirstName("Sergey");
        anikeevTeacher.setPatronym("Vladimirovich");
        anikeevTeacher.setLastName("Anikeev");
        anikeevTeacher.setEmployeeId(7456);

        ivanovStudent = new Student();
        ivanovStudent.setFirstName("Ivan");
        ivanovStudent.setPatronym("Ivanovich");
        ivanovStudent.setLastName("Ivanov");
        ivanovStudent.setNumberOfMarkBook(254782);

        group2070 = new Group();
        group2070.setName("2070");

        emptyDailySchedule = new DailySchedule();
        emptyDailySchedule.setDate(LocalDate.of(2018, 9, 10));
    }

    @Test
    public void shouldReturnDailyScheduleForTeacher_WhenGetDailyScheduleForTeacher() {
        DailySchedule expectedDailySchedule = dailyScheduleForTeacher;
        DailySchedule actualDailySchedule = UniversityStorage.getInstance().getDailyScheduleForTeacher(holopovTeacher, 10).get();

        assertEquals(expectedDailySchedule, actualDailySchedule);
    }

    @Test
    public void shouldReturnDailyScheduleForStudent_WhenGetDailyScheduleForStudent() {
        DailySchedule expectedDailySchedule = dailyScheduleForStudent;
        DailySchedule actualDailySchedule = UniversityStorage.getInstance().getDailyScheduleForStudent(kabatovStudent, 10).get();

        assertEquals(expectedDailySchedule, actualDailySchedule);
    }

    @Test
    public void shouldReturnDailyScheduleForGroup_WhenGetDailyScheduleForGroup() {
        DailySchedule expectedDailySchedule = dailyScheduleForGroup;
        DailySchedule actualDailySchedule = UniversityStorage.getInstance().getDailyScheduleForGroup(group3033, 10).get();

        assertEquals(expectedDailySchedule, actualDailySchedule);
    }

    @Test
    public void shouldReturnEmptyDailyScheduleForTeacher_WhenNotLessonsForTeacher() {
        DailySchedule expectedDailySchedule = emptyDailySchedule;
        DailySchedule actualDailySchedule = UniversityStorage.getInstance().getDailyScheduleForTeacher(anikeevTeacher, 10).get();

        assertEquals(expectedDailySchedule, actualDailySchedule);
    }

    @Test
    public void shouldReturnEmptyDailyScheduleForStudent_WhenNotLessonsForStudent() {
        DailySchedule expectedDailySchedule = emptyDailySchedule;
        DailySchedule actualDailySchedule = UniversityStorage.getInstance().getDailyScheduleForStudent(ivanovStudent, 10).get();

        assertEquals(expectedDailySchedule, actualDailySchedule);
    }

    @Test
    public void shouldReturnEmptyDailyScheduleForGroup_WhenNotLessonsForGroup() {
        DailySchedule expectedDailySchedule = emptyDailySchedule;
        DailySchedule actualDailySchedule = UniversityStorage.getInstance().getDailyScheduleForGroup(group2070, 10).get();

        assertEquals(expectedDailySchedule, actualDailySchedule);
    }
}