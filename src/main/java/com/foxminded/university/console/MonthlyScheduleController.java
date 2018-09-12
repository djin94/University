package com.foxminded.university.console;

import com.foxminded.university.domain.*;

public class MonthlyScheduleController {
    private MonthlySchedule monthlySchedule;

    public DailySchedule getDailyScheduleForTeacher(Teacher teacher, int day) {
        return monthlySchedule.getMonthlyScheduleForTeacher(teacher).stream()
                .filter(dailySchedule -> dailySchedule.getDate().getDayOfMonth() == day).findFirst().get();
    }

    public DailySchedule getDailyScheduleForStudent(Student student, int day) {
        return monthlySchedule.getMonthlyScheduleForStudent(student).stream()
                .filter(dailySchedule -> dailySchedule.getDate().getDayOfMonth() == day).findFirst().get();
    }

    public DailySchedule getDailyScheduleForGroup(Group group, int day) {
        return monthlySchedule.getMonthlyScheduleForGroup(group).stream()
                .filter(dailySchedule -> dailySchedule.getDate().getDayOfMonth() == day).findFirst().get();
    }

    public MonthlySchedule getMonthlySchedule() {
        return monthlySchedule;
    }

    public void setMonthlySchedule(MonthlySchedule monthlySchedule) {
        this.monthlySchedule = monthlySchedule;
    }
}
