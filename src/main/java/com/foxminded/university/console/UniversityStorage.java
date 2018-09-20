package com.foxminded.university.console;

import com.foxminded.university.domain.schedule.DailySchedule;
import com.foxminded.university.domain.schedule.MonthlySchedule;
import com.foxminded.university.domain.university.*;

import java.util.List;
import java.util.Optional;

public class UniversityStorage {
    private static UniversityStorage universityStorage;
    private University university;
    private MonthlySchedule monthlyScheduleForSeptember;

    private UniversityStorage() {
    }

    public static UniversityStorage getInstance() {
        if (universityStorage == null) {
            universityStorage = new UniversityStorage();
            UniversityCreator universityCreator = new UniversityCreator();
            universityStorage.university = universityCreator.createRyazanStateRadioengineeringUniversity();
            universityStorage.monthlyScheduleForSeptember = universityCreator.createSeptemberMonthlySchedule();
        }
        return universityStorage;
    }

    public University getUniversity() {
        return university;
    }

    public MonthlySchedule getMonthlyScheduleForSeptember() {
        return monthlyScheduleForSeptember;
    }

    public Optional<DailySchedule> getDailyScheduleForTeacher(Teacher teacher, int day) {
        return monthlyScheduleForSeptember.getMonthlyScheduleForTeacher(teacher).stream()
                .filter(dailySchedule -> dailySchedule.getDate().getDayOfMonth() == day)
                .findFirst();
    }

    public Optional<DailySchedule> getDailyScheduleForStudent(Student student, int day) {
        return monthlyScheduleForSeptember.getMonthlyScheduleForStudent(student).stream()
                .filter(dailySchedule -> dailySchedule.getDate().getDayOfMonth() == day)
                .findFirst();
    }

    public Optional<DailySchedule> getDailyScheduleForGroup(Group group, int day) {
        return monthlyScheduleForSeptember.getMonthlyScheduleForGroup(group).stream()
                .filter(dailySchedule -> dailySchedule.getDate().getDayOfMonth() == day)
                .findFirst();
    }
}