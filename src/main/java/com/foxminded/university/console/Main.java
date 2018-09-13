package com.foxminded.university.console;

import com.foxminded.university.domain.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean stop = false;
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();
        UniversityModel universityModel = new UniversityModel();
        University university = universityModel.getRsreuUniversity();
        MonthlySchedule monthlyScheduleForUniversity = main.getMonthlySchedyle();
        UniversityController universityController = new UniversityController();
        universityController.setUniversity(university);
        MonthlyScheduleController monthlyScheduleController = new MonthlyScheduleController();
        monthlyScheduleController.setMonthlySchedule(monthlyScheduleForUniversity);
        System.out.println("Hello! Whose schedule do you want to see?");
        do {
            try {
                String lastName = "";
                String firstName = "";
                String patronym = "";
                String name = "";
                System.out.println("Choose and write: 1 - Teacher, 2 - Student, 3 - Group");
                int choiceForWho = scanner.nextInt();
                System.out.println("Choose type schedule: 1 - For month, 2 - For day");
                int choiceTypeSchedule = scanner.nextInt();
                int choiceDay = 0;
                if (choiceTypeSchedule == 2) {
                    System.out.println("Enter a day");
                    choiceDay = scanner.nextInt();
                }
                if (choiceForWho == 1 || choiceForWho == 2) {
                    System.out.println("Enter a last name");
                    lastName = scanner.next();
                    System.out.println("Enter a first name");
                    firstName = scanner.next();
                    System.out.println("Enter a patronym");
                    patronym = scanner.next();
                }
                if (choiceForWho == 3) {
                    System.out.println("Enter a name");
                    name = scanner.next();
                }
                List<DailySchedule> scheduleForUser = new ArrayList<>();
                if (choiceTypeSchedule == 1) {
                    if (choiceForWho == 1) {
                        Teacher teacher = universityController.getTeacherByName(lastName, firstName, patronym);
                        scheduleForUser.addAll(monthlyScheduleForUniversity.getMonthlyScheduleForTeacher(teacher));
                    }
                    if (choiceForWho == 2) {
                        Student student = universityController.getStudentByName(lastName, firstName, patronym);
                        scheduleForUser.addAll(monthlyScheduleForUniversity.getMonthlyScheduleForStudent(student));
                    }
                    if (choiceForWho == 3) {
                        Group group = universityController.getGroupByName(name);
                        scheduleForUser.addAll(monthlyScheduleForUniversity.getMonthlyScheduleForGroup(group));
                    }
                }
                if (choiceTypeSchedule == 2) {
                    if (choiceForWho == 1) {
                        Teacher teacher = universityController.getTeacherByName(lastName, firstName, patronym);
                        scheduleForUser.add(monthlyScheduleController.getDailyScheduleForTeacher(teacher, choiceDay));
                    }
                    if (choiceForWho == 2) {
                        Student student = universityController.getStudentByName(lastName, firstName, patronym);
                        scheduleForUser.add(monthlyScheduleController.getDailyScheduleForStudent(student, choiceDay));
                    }
                    if (choiceForWho == 3) {
                        Group group = universityController.getGroupByName(name);
                        scheduleForUser.add(monthlyScheduleController.getDailyScheduleForGroup(group, choiceDay));
                    }
                }
                main.printSchedule(scheduleForUser);
                System.out.println("Do you want to continue? (y/n)");
                stop = !scanner.next().equals("y");
            } catch (Exception e) {
                System.out.println("");
            }
        } while (!stop);
    }

    private List<DailySchedule> getScheduleForUser(int choiceForWho, int choiceTypeSchedule) {

    }

    private Teacher getPersonFromConsole(University university) {
        String lastName = getLastNameFromConsole();
        String firstName = getFirstNameFromConsole();
        String patronym = getPatronymFromConsole();
        return universityController.getTeacherByName(lastName, firstName, patronym);
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

    private void printSchedule(List<DailySchedule> dailySchedules) {
        dailySchedules.stream().flatMap(dailySchedule -> dailySchedule.getLessons().stream())
                .peek(lesson -> {
                    System.out.println("Time: " + lesson.getTimeStart().toString());
                })
                .peek(lesson -> {
                    System.out.println("Subject: " + lesson.getSubject().getName());
                })
                .peek(lesson -> {
                    System.out.println("Group: " + lesson.getGroup().getName());
                })
                .peek(lesson -> {
                    System.out.println("Teacher: " + lesson.getTeacher().getLastName());
                })
                .forEach(lesson -> {
                    System.out.println("Audience: " + lesson.getAudience().getNumber() + "u" + lesson.getAudience().getBuilding() + "\n");
                });
    }

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
