package com.foxminded.university.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DailySchedule {
    public static final DailySchedule EMPTY_DAILYSCHEDULE = new DailySchedule();
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
        List<Lesson> lessonsForTeacher = lessons.stream()
                .filter(lesson -> lesson.getTeacher().equals(teacher))
                .collect(Collectors.toList());
        return lessonsForTeacher;
    }

    public List<Lesson> getDailyScheduleForStudent(Student student) {
        List<Lesson> lessonsForStudent = lessons.stream()
                .filter(lesson -> lesson.getGroup().getStudents()
                        .stream()
                        .anyMatch(studentInGroup -> studentInGroup.equals(student)))
                .collect(Collectors.toList());
        return lessonsForStudent;
    }

    public List<Lesson> getDailyScheduleForGroup(Group group) {
        List<Lesson> lessonsForGroup = lessons.stream()
                .filter(lesson -> lesson.getGroup().equals(group))
                .collect(Collectors.toList());
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DailySchedule)) {
            return false;
        }
        DailySchedule that = (DailySchedule) o;
        return Objects.equals(lessons, that.lessons) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lessons, date);
    }
}
