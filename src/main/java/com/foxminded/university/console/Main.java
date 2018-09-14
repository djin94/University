package com.foxminded.university.console;

import com.foxminded.university.domain.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean stop = false;
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();
        System.out.println("Hello! Whose and what schedule do you want to see?");
        do {
            try {
                List<DailySchedule> scheduleForUser = main.getScheduleForUser();
                main.printSchedule(scheduleForUser);
                System.out.println("Do you want to continue? (y/n)");
                stop = !scanner.next().equals("y");
            } catch (Exception e) {
                System.out.println("");
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
        if (choiceForWho == 1) {
            Teacher teacher = getTeacherFromConsole();
            return UniversityStorage.getInstance().getMonthlyScheduleForSeptember().getMonthlyScheduleForTeacher(teacher);
        }
        if (choiceForWho == 2) {
            Student student = getStudentFromConsole();
            return UniversityStorage.getInstance().getMonthlyScheduleForSeptember().getMonthlyScheduleForStudent(student);
        }
        if (choiceForWho == 3) {
            Group group = getGroupFromConsole();
            return UniversityStorage.getInstance().getMonthlyScheduleForSeptember().getMonthlyScheduleForGroup(group);
        }
        return Collections.emptyList();
    }

    private int getChoiceForWhoScheduleFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose and write: 1 - Teacher, 2 - Student, 3 - Group");
        return scanner.nextInt();
    }

    private Teacher getTeacherFromConsole() {
        String lastName = getLastNameFromConsole();
        String firstName = getFirstNameFromConsole();
        String patronym = getPatronymFromConsole();
        return UniversityStorage.getInstance().getTeacherByName(lastName, firstName, patronym);
    }

    private String getLastNameFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a last name");
        return scanner.next();
    }

    private String getFirstNameFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a first name");
        return scanner.next();
    }

    private String getPatronymFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a patronym");
        return scanner.next();
    }

    private Student getStudentFromConsole() {
        String lastName = getLastNameFromConsole();
        String firstName = getFirstNameFromConsole();
        String patronym = getPatronymFromConsole();
        return UniversityStorage.getInstance().getStudentByName(lastName, firstName, patronym);
    }

    private Group getGroupFromConsole() {
        return UniversityStorage.getInstance().getGroupByName(getNameForGroup());
    }

    private String getNameForGroup() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a name");
        return scanner.next();
    }

    private DailySchedule getDailyScheduleForUser() {
        int choiceForWho = getChoiceForWhoScheduleFromConsole();
        int choiceDay = getChoiceDayFromConsole();
        if (choiceForWho == 1) {
            Teacher teacher = getTeacherFromConsole();
            return UniversityStorage.getInstance().getDailyScheduleForTeacher(teacher, choiceDay);
        }
        if (choiceForWho == 2) {
            Student student = getStudentFromConsole();
            return UniversityStorage.getInstance().getDailyScheduleForStudent(student, choiceDay);
        }
        if (choiceForWho == 3) {
            Group group = getGroupFromConsole();
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
