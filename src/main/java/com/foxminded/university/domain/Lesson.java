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
}
