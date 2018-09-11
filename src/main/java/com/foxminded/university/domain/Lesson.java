package com.foxminded.university.domain;

import java.time.LocalTime;

public class Lesson {
    private Subject subject;
    private Teacher teacher;
    private Group group;
    private Audience audience;
    private LocalTime timeStart;

    public void update(Lesson lesson) {
        this.subject = lesson.subject;
        this.teacher = lesson.teacher;
        this.group = lesson.group;
        this.audience = lesson.audience;
        this.timeStart = lesson.timeStart;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Audience getAudience() {
        return audience;
    }

    public void setAudience(Audience audience) {
        this.audience = audience;
    }

    public LocalTime getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(LocalTime timeStart) {
        this.timeStart = timeStart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher)) {
            return false;
        }
        Lesson lesson = (Lesson) o;
        if (!subject.equals(lesson.subject)) return false;
        if (!teacher.equals(lesson.teacher)) return false;
        if (!group.equals(lesson.group)) return false;
        if (!audience.equals(lesson.audience)) return false;
        return timeStart.equals(lesson.timeStart);
    }

    @Override
    public int hashCode() {
        int result = subject != null ? subject.hashCode() : 0;
        result = 31 * result + (teacher != null ? teacher.hashCode() : 0);
        result = 31 * result + (group != null ? group.hashCode() : 0);
        result = 31 * result + (audience != null ? audience.hashCode() : 0);
        result = 31 * result + (timeStart != null ? timeStart.hashCode() : 0);
        return result;
    }
}
