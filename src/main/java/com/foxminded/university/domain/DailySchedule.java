package com.foxminded.university.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DailySchedule {
    private List<Lesson> lessons = new ArrayList<>();
    private LocalDate date;

    public void update(DailySchedule dailySchedule) {
        this.lessons = dailySchedule.lessons;
        this.date = dailySchedule.date;
    }

    public void addLesson(Lesson lesson) {
        lessons.add(lesson);
    }

    public void removeLesson(Lesson lesson) {
        lessons.remove(lesson);
    }

    public List<Lesson> getDailyScheduleForTeacher(Teacher teacher) {
        List<Lesson> lessonsForTeacher = new ArrayList<>();
        for (Lesson lesson : lessons) {
            if (lesson.getTeacher() == teacher)
                lessonsForTeacher.add(lesson);
        }
        return lessonsForTeacher;
    }

    public List<Lesson> getDailyScheduleForStudent(Student student) {
        List<Lesson> lessonsForStudent = new ArrayList<>();
        for (Lesson lesson : lessons) {
            if (lesson.getGroup().getStudents().contains(student))
                lessonsForStudent.add(lesson);
        }
        return lessonsForStudent;
    }

    public List<Lesson> getDailyScheduleForGroup(Group group) {
        List<Lesson> lessonsForGroup = new ArrayList<>();
        for (Lesson lesson : lessons) {
            if (lesson.getGroup() == group)
                lessonsForGroup.add(lesson);
        }
        return lessonsForGroup;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}
