package com.foxminded.university.domain.schedule;

import com.foxminded.university.domain.university.Group;
import com.foxminded.university.domain.university.Student;
import com.foxminded.university.domain.university.Teacher;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Optional<DailySchedule> getDailySchedule(LocalDate date) {
        for (DailySchedule dailySchedule : dailySchedules) {
            if (dailySchedule.getDate().equals(date))
                return Optional.of(dailySchedule);
        }
        return Optional.empty();
    }

    public List<DailySchedule> findMonthlySchedule(Teacher teacher) {
        List<DailySchedule> teacherMonthlySchedule = new ArrayList<>();
        for (DailySchedule dailySchedule : dailySchedules) {
            teacherMonthlySchedule.add(createDailySchedule(teacher, dailySchedule));
        }
        return teacherMonthlySchedule;
    }

    private DailySchedule createDailySchedule(Teacher teacher, DailySchedule allLessonsForDay) {
        DailySchedule teacherDailySchedule = new DailySchedule();
        teacherDailySchedule.setDate(allLessonsForDay.getDate());
        teacherDailySchedule.setLessons(allLessonsForDay.findDailySchedule(teacher));
        return teacherDailySchedule;
    }

    public List<DailySchedule> findMonthlySchedule(Student student) {
        List<DailySchedule> studentMonthlySchedule = new ArrayList<>();
        for (DailySchedule dailySchedule : dailySchedules) {
            studentMonthlySchedule.add(createDailySchedule(student, dailySchedule));
        }
        return studentMonthlySchedule;
    }

    private DailySchedule createDailySchedule(Student student, DailySchedule allLessonsForDay) {
        DailySchedule studentDailySchedule = new DailySchedule();
        studentDailySchedule.setDate(allLessonsForDay.getDate());
        studentDailySchedule.setLessons(allLessonsForDay.findDailySchedule(student));
        return studentDailySchedule;
    }

    public List<DailySchedule> findMonthlySchedule(Group group) {
        List<DailySchedule> groupMonthlySchedule = new ArrayList<>();
        for (DailySchedule dailySchedule : dailySchedules) {
            groupMonthlySchedule.add(createDailySchedule(group, dailySchedule));
        }
        return groupMonthlySchedule;
    }

    private DailySchedule createDailySchedule(Group group, DailySchedule allLessonsForDay) {
        DailySchedule groupDailySchedule = new DailySchedule();
        groupDailySchedule.setDate(allLessonsForDay.getDate());
        groupDailySchedule.setLessons(allLessonsForDay.findDailySchedule(group));
        return groupDailySchedule;
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
