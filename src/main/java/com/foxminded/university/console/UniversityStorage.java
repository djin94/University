package com.foxminded.university.console;

import com.foxminded.university.domain.schedule.DailySchedule;
import com.foxminded.university.domain.schedule.MonthlySchedule;
import com.foxminded.university.domain.university.*;

import java.util.List;
import java.util.Optional;

public class UniversityStorage {
    private static UniversityStorage universityStorage;
    private University university;
    private List<Faculty> faculties;
    private List<Department> departments;
    private MonthlySchedule monthlyScheduleForSeptember;

    private UniversityStorage() {
    }

    public static UniversityStorage getInstance() {
        if (universityStorage == null) {
            universityStorage = new UniversityStorage();
            UniversityCreator universityCreator = new UniversityCreator();
            universityStorage.university = universityCreator.createRyazanStateRadioengineeringUniversity();
            universityStorage.faculties = universityStorage.university.getFaculties();
            universityStorage.departments = universityCreator.createAllDepartments();
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

    public static UniversityStorage getUniversityStorage() {
        return universityStorage;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public List<Department> getDepartments() {
        return departments;
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