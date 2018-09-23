package com.foxminded.university.domain.schedule;

import com.foxminded.university.domain.university.Audience;
import com.foxminded.university.domain.university.Group;
import com.foxminded.university.domain.university.Subject;
import com.foxminded.university.domain.university.Teacher;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalTime;

import static org.junit.Assert.*;

public class LessonTest {
    private Lesson plicLesson;

    private Lesson updateLesson;

    @Before
    public void setUp() throws Exception {
        Subject plicSubject = new Subject();
        plicSubject.setName("PLIS");
        plicSubject.setHoursInSemestr(120);

        Teacher holopovTeacher = new Teacher();
        holopovTeacher.setFirstName("Sergey");
        holopovTeacher.setPatronym("Ivanovich");
        holopovTeacher.setLastName("Holopov");
        holopovTeacher.setEmployeeId(7852);
        holopovTeacher.addSubject(plicSubject);

        Group group3033 = new Group();
        group3033.setName("3033");

        Audience audience313 = new Audience();
        audience313.setNumber(313);
        audience313.setBuilding(1);
        audience313.setType("Laboratory");

        plicLesson = new Lesson();
        plicLesson.setTimeStart(LocalTime.of(11, 40));
        plicLesson.setTeacher(holopovTeacher);
        plicLesson.setGroup(group3033);
        plicLesson.setAudience(audience313);
        plicLesson.setSubject(plicSubject);

        Subject updateSubject = new Subject();
        updateSubject.setName("The quantum physics");

        Teacher updateTeacher = new Teacher();
        updateTeacher.setFirstName("Sergey");
        updateTeacher.setPatronym("Vladimirovich");
        updateTeacher.setLastName("Anikeev");

        Audience updateAudience = new Audience();
        updateAudience.setNumber(255);
        updateAudience.setBuilding(1);

        Group updateGroup = new Group();
        updateGroup.setName("2070");

        updateLesson = new Lesson();
        updateLesson.setTimeStart(LocalTime.of(9, 55));
        updateLesson.setSubject(updateSubject);
        updateLesson.setAudience(updateAudience);
        updateLesson.setGroup(updateGroup);
        updateLesson.setTeacher(updateTeacher);
    }

    @Test
    public void shouldUpdateLesson_WhenUpdateLesson() {
        plicLesson.update(updateLesson);

        Lesson expectedLesson = updateLesson;
        Lesson actualLesson = plicLesson;

        assertEquals(expectedLesson, actualLesson);
    }
}