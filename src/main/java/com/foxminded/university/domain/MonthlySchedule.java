package com.foxminded.university.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
        return DailySchedule.EMPTY_DAILYSCHEDULE;
    }

    public List<DailySchedule> getMonthlyScheduleForTeacher(Teacher teacher) {
        List<DailySchedule> monthlyScheduleForTeacher = new ArrayList<>();
        for (DailySchedule dailySchedule : dailySchedules) {
            monthlyScheduleForTeacher.add(makeDailyScheduleForTeacher(teacher, dailySchedule));
        }
        return monthlyScheduleForTeacher;
    }

    private DailySchedule makeDailyScheduleForTeacher(Teacher teacher, DailySchedule dailySchedule) {
        DailySchedule dailyScheduleForTeacher = new DailySchedule();
        dailyScheduleForTeacher.setDate(dailySchedule.getDate());
        dailyScheduleForTeacher.setLessons(dailySchedule.getDailyScheduleForTeacher(teacher));
        return dailyScheduleForTeacher;
    }

    public List<DailySchedule> getMonthlyScheduleForStudent(Student student) {
        List<DailySchedule> monthlyScheduleForStudent = new ArrayList<>();
        for (DailySchedule dailySchedule : dailySchedules) {
            monthlyScheduleForStudent.add(makeDailyScheduleForStudent(student, dailySchedule));
        }
        return monthlyScheduleForStudent;
    }

    private DailySchedule makeDailyScheduleForStudent(Student student, DailySchedule dailySchedule) {
        DailySchedule dailyScheduleForStudent = new DailySchedule();
        dailyScheduleForStudent.setDate(dailySchedule.getDate());
        dailyScheduleForStudent.setLessons(dailySchedule.getDailyScheduleForStudent(student));
        return dailyScheduleForStudent;
    }

    public List<DailySchedule> getMonthlyScheduleForGroup(Group group) {
        List<DailySchedule> monthlyScheduleForGroup = new ArrayList<>();
        for (DailySchedule dailySchedule : dailySchedules) {
            monthlyScheduleForGroup.add(makeDailyScheduleForGroup(group, dailySchedule));
        }
        return monthlyScheduleForGroup;
    }

    private DailySchedule makeDailyScheduleForGroup(Group group, DailySchedule dailySchedule) {
        DailySchedule dailyScheduleForGroup = new DailySchedule();
        dailyScheduleForGroup.setDate(dailySchedule.getDate());
        dailyScheduleForGroup.setLessons(dailySchedule.getDailyScheduleForGroup(group));
        return dailyScheduleForGroup;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MonthlySchedule)) {
            return false;
        }

        MonthlySchedule that = (MonthlySchedule) o;

        if (month != that.month) return false;
        if (year != that.year) return false;
        return dailySchedules.equals(that.dailySchedules);
    }

    @Override
    public int hashCode() {
        int result = dailySchedules != null ? dailySchedules.hashCode() : 0;
        result = 31 * result + month;
        return 31 * result + year;
    }
}
