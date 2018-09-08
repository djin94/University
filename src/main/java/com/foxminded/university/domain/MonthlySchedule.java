package com.foxminded.university.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MonthlySchedule {
    private List<DailySchedule> dailySchedules = new ArrayList<>();
    private int month;
    private int year;

    public void addDailySchedule(DailySchedule dailySchedule) {
        dailySchedules.add(dailySchedule);
    }

    public void removeDailySchedule(DailySchedule dailySchedule) {
        dailySchedules.remove(dailySchedule);
    }

    public DailySchedule getDailySchedule(LocalDate date) {
        for (DailySchedule dailySchedule : dailySchedules) {
            if (dailySchedule.getDate().equals(date))
                return dailySchedule;
        }
        return new DailySchedule();
    }

    public List<DailySchedule> getMonthlyScheduleForTeacher(Teacher teacher) {
        List<DailySchedule> monthlyScheduleForTeacher = new ArrayList<>();
        for (DailySchedule dailySchedule : dailySchedules) {
            DailySchedule dailyScheduleForTeacher = new DailySchedule();
            dailyScheduleForTeacher.setDate(dailySchedule.getDate());
            dailyScheduleForTeacher.setLessons(dailySchedule.getDailyScheduleForTeacher(teacher));
            monthlyScheduleForTeacher.add(dailyScheduleForTeacher);
        }
        return monthlyScheduleForTeacher;
    }

    public List<DailySchedule> getMonthlyScheduleForStudent(Student student) {
        List<DailySchedule> monthlyScheduleForStudent = new ArrayList<>();
        for (DailySchedule dailySchedule : dailySchedules) {
            DailySchedule dailyScheduleForStudent = new DailySchedule();
            dailyScheduleForStudent.setDate(dailySchedule.getDate());
            dailyScheduleForStudent.setLessons(dailySchedule.getDailyScheduleForStudent(student));
            monthlyScheduleForStudent.add(dailyScheduleForStudent);
        }
        return monthlyScheduleForStudent;
    }

    public List<DailySchedule> getMonthlyScheduleForGroup(Group group) {
        List<DailySchedule> monthlyScheduleForGroup = new ArrayList<>();
        for (DailySchedule dailySchedule : dailySchedules) {
            DailySchedule dailyScheduleForGroup = new DailySchedule();
            dailyScheduleForGroup.setDate(dailySchedule.getDate());
            dailyScheduleForGroup.setLessons(dailySchedule.getDailyScheduleForGroup(group));
            monthlyScheduleForGroup.add(dailyScheduleForGroup);
        }
        return monthlyScheduleForGroup;
    }

    public void update(MonthlySchedule monthlySchedule) {
        this.month = monthlySchedule.month;
        this.year = monthlySchedule.year;
        this.dailySchedules.clear();
        this.dailySchedules.addAll(monthlySchedule.dailySchedules);
    }

    public List<DailySchedule> getDailySchedules() {
        return dailySchedules;
    }

    public void setDailySchedules(List<DailySchedule> dailySchedules) {
        this.dailySchedules = dailySchedules;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
