package com.foxminded.university.console;

import com.foxminded.university.domain.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean stop;
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();
        System.out.println("Hello! Whose and what schedule do you want to see?");
        do {
            try {
                List<DailySchedule> userSchedule = main.getScheduleForUser();
                main.printSchedule(userSchedule);
            } catch (Exception e) {
                System.out.println("Enter only the specified numbers");
            } finally {
                System.out.println("Do you want to continue? (y/n)");
                stop = !scanner.next().equals("y");
            }
        } while (!stop);
    }

    private List<DailySchedule> getScheduleForUser() {
        List<DailySchedule> scheduleForUser = new ArrayList<>();
        int choiceTypeSchedule = getChoiceTypeScheduleFromConsole();
        if (choiceTypeSchedule == 1) {
            scheduleForUser.addAll(getMonthlyScheduleForUser());
        }
        if (choiceTypeSchedule == 2) {
            scheduleForUser.add(getDailyScheduleForUser());
        }
        return scheduleForUser;
    }

    private int getChoiceTypeScheduleFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose type schedule: 1 - For month, 2 - For day");
        return scanner.nextInt();
    }

    private List<DailySchedule> getMonthlyScheduleForUser() {
        int choiceForWho = getChoiceForWhoScheduleFromConsole();
        int choiceFaculty = getChoiceFacultyFromConsole();
        int choiceDepartment = getChoiceDepartmentFromConsole(UniversityStorage.getInstance().getRsreuUniversity().getFaculties().get(choiceFaculty - 1));
        Department chosenDepartment = UniversityStorage.getInstance().getRsreuUniversity().getFaculties().get(choiceFaculty - 1).getDepartments().get(choiceDepartment - 1);
        if (choiceForWho == 1) {
            Teacher teacher = chosenDepartment.getTeachers().get(getChoiceTeacherFromConsole(chosenDepartment) - 1);
            return UniversityStorage.getInstance().getMonthlyScheduleForSeptember().getMonthlyScheduleForTeacher(teacher);
        }
        if (choiceForWho == 2) {
            Group group = chosenDepartment.getGroups().get(getChoiceGroupFromConsole(chosenDepartment) - 1);
            Student student = group.getStudents().get(getChoiceStudentFromConsole(group) - 1);
            return UniversityStorage.getInstance().getMonthlyScheduleForSeptember().getMonthlyScheduleForStudent(student);
        }
        if (choiceForWho == 3) {
            Group group = chosenDepartment.getGroups().get(getChoiceGroupFromConsole(chosenDepartment) - 1);
            return UniversityStorage.getInstance().getMonthlyScheduleForSeptember().getMonthlyScheduleForGroup(group);
        }
        return Collections.emptyList();
    }

    private int getChoiceForWhoScheduleFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose and write: 1 - Teacher, 2 - Student, 3 - Group");
        return scanner.nextInt();
    }

    private int getChoiceFacultyFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose faculty:");
        System.out.println(UniversityStorage.getInstance().getRsreuUniversity());
        return scanner.nextInt();
    }

    private int getChoiceDepartmentFromConsole(Faculty faculty) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose department:");
        System.out.println(faculty);
        return scanner.nextInt();
    }

    private int getChoiceTeacherFromConsole(Department department) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose teacher:");
        for (int i = 0; i < department.getTeachers().size(); i++) {
            System.out.print(String.valueOf(i + 1) + " - " + department.getTeachers().get(i).getLastName() + " ");
            System.out.println(department.getTeachers().get(i).getFirstName() + " " + department.getTeachers().get(i).getPatronym());
        }
        return scanner.nextInt();
    }

    private int getChoiceGroupFromConsole(Department department) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose group:");
        for (int i = 0; i < department.getTeachers().size(); i++) {
            System.out.println(String.valueOf(i + 1) + " - " + department.getGroups().get(i).getName());
        }
        return scanner.nextInt();
    }

    private int getChoiceStudentFromConsole(Group group) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose student:");
        System.out.println(group);
        return scanner.nextInt();
    }

    private DailySchedule getDailyScheduleForUser() {
        int choiceForWho = getChoiceForWhoScheduleFromConsole();
        int choiceDay = getChoiceDayFromConsole();
        int choiceFaculty = getChoiceFacultyFromConsole();
        int choiceDepartment = getChoiceDepartmentFromConsole(UniversityStorage.getInstance().getRsreuUniversity().getFaculties().get(choiceFaculty - 1));
        Department department = UniversityStorage.getInstance().getRsreuUniversity().getFaculties().get(choiceFaculty - 1).getDepartments().get(choiceDepartment - 1);
        if (choiceForWho == 1) {
            Teacher teacher = department.getTeachers().get(getChoiceTeacherFromConsole(department) - 1);
            return UniversityStorage.getInstance().getDailyScheduleForTeacher(teacher, choiceDay);
        }
        if (choiceForWho == 2) {
            Group group = department.getGroups().get(getChoiceGroupFromConsole(department) - 1);
            Student student = group.getStudents().get(getChoiceStudentFromConsole(group) - 1);
            return UniversityStorage.getInstance().getDailyScheduleForStudent(student, choiceDay);
        }
        if (choiceForWho == 3) {
            Group group = department.getGroups().get(getChoiceGroupFromConsole(department) - 1);
            return UniversityStorage.getInstance().getDailyScheduleForGroup(group, choiceDay);
        }
        return DailySchedule.EMPTY_DAILYSCHEDULE;
    }

    private int getChoiceDayFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a day");
        return scanner.nextInt();
    }

    private void printSchedule(List<DailySchedule> dailySchedules) {
        dailySchedules.stream().flatMap(dailySchedule -> dailySchedule.getLessons().stream())
                .peek(lesson -> System.out.println("Time: " + lesson.getTimeStart().toString()))
                .peek(lesson -> System.out.println("Subject: " + lesson.getSubject().getName()))
                .peek(lesson -> System.out.println("Group: " + lesson.getGroup().getName()))
                .peek(lesson -> System.out.println("Teacher: " + lesson.getTeacher().getLastName()))
                .forEach(lesson -> System.out.println("Audience: " + lesson.getAudience().getNumber() + "u" + lesson.getAudience().getBuilding() + "\n"));
    }
}
