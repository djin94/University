package com.foxminded.university.domain.schedule;

import com.foxminded.university.domain.university.Group;
import com.foxminded.university.domain.university.Student;
import com.foxminded.university.domain.university.Teacher;

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
        List<DailySchedule> teacherMonthlySchedule = new ArrayList<>();
        for (DailySchedule dailySchedule : dailySchedules) {
            teacherMonthlySchedule.add(makeDailyScheduleForTeacher(teacher, dailySchedule));
        }
        return teacherMonthlySchedule;
    }

    private DailySchedule makeDailyScheduleForTeacher(Teacher teacher, DailySchedule allLessonsForDay) {
        DailySchedule teacherDailySchedule = new DailySchedule();
        teacherDailySchedule.setDate(allLessonsForDay.getDate());
        teacherDailySchedule.setLessons(allLessonsForDay.getDailyScheduleForTeacher(teacher));
        return teacherDailySchedule;
    }

    public List<DailySchedule> getMonthlyScheduleForStudent(Student student) {
        List<DailySchedule> studentMonthlySchedule = new ArrayList<>();
        for (DailySchedule dailySchedule : dailySchedules) {
            studentMonthlySchedule.add(makeDailyScheduleForStudent(student, dailySchedule));
        }
        return studentMonthlySchedule;
    }

    private DailySchedule makeDailyScheduleForStudent(Student student, DailySchedule allLessonsForDay) {
        DailySchedule studentDailySchedule = new DailySchedule();
        studentDailySchedule.setDate(allLessonsForDay.getDate());
        studentDailySchedule.setLessons(allLessonsForDay.getDailyScheduleForStudent(student));
        return studentDailySchedule;
    }

    public List<DailySchedule> getMonthlyScheduleForGroup(Group group) {
        List<DailySchedule> groupMonthlySchedule = new ArrayList<>();
        for (DailySchedule dailySchedule : dailySchedules) {
            groupMonthlySchedule.add(makeDailyScheduleForGroup(group, dailySchedule));
        }
        return groupMonthlySchedule;
    }

    private DailySchedule makeDailyScheduleForGroup(Group group, DailySchedule allLessonsForDay) {
        DailySchedule groupDailySchedule = new DailySchedule();
        groupDailySchedule.setDate(allLessonsForDay.getDate());
        groupDailySchedule.setLessons(allLessonsForDay.getDailyScheduleForGroup(group));
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
