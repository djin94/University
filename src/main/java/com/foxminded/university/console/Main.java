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
        UniversityModel universityModel = new UniversityModel();
        University university = universityModel.getRsreuUniversity();
        MonthlySchedule monthlyScheduleForUniversity = universityModel.getMonthlySchedyle();
        System.out.println("Hello! Whose and what schedule do you want to see?");
        do {
            try {
                List<DailySchedule> scheduleForUser = main.getScheduleForUser(university, monthlyScheduleForUniversity);
                main.printSchedule(scheduleForUser);
                System.out.println("Do you want to continue? (y/n)");
                stop = !scanner.next().equals("y");
            } catch (Exception e) {
                System.out.println("");
            }
        } while (!stop);
    }

    private List<DailySchedule> getScheduleForUser(University university, MonthlySchedule monthlySchedule) {
        List<DailySchedule> scheduleForUser = new ArrayList<>();
        int choiceTypeSchedule = getChoiceTypeScheduleFromConsole();
        if (choiceTypeSchedule == 1) {
            scheduleForUser.addAll(getMonthlyScheduleForUser(university, monthlySchedule));
        }
        if (choiceTypeSchedule == 2) {
            scheduleForUser.add(getDailyScheduleForUser(university, monthlySchedule));
        }
        return scheduleForUser;
    }

    private int getChoiceTypeScheduleFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose type schedule: 1 - For month, 2 - For day");
        return scanner.nextInt();
    }

    private List<DailySchedule> getMonthlyScheduleForUser(University university, MonthlySchedule monthlySchedule) {
        int choiceForWho = getChoiceForWhoScheduleFromConsole();
        if (choiceForWho == 1) {
            Teacher teacher = getTeacherFromConsole(university);
            return monthlySchedule.getMonthlyScheduleForTeacher(teacher);
        }
        if (choiceForWho == 2) {
            Student student = getStudentFromConsole(university);
            return monthlySchedule.getMonthlyScheduleForStudent(student);
        }
        if (choiceForWho == 3) {
            Group group = getGroupFromConsole(university);
            return monthlySchedule.getMonthlyScheduleForGroup(group);
        }
        return Collections.emptyList();
    }

    private int getChoiceForWhoScheduleFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose and write: 1 - Teacher, 2 - Student, 3 - Group");
        return scanner.nextInt();
    }

    private Teacher getTeacherFromConsole(University university) {
        String lastName = getLastNameFromConsole();
        String firstName = getFirstNameFromConsole();
        String patronym = getPatronymFromConsole();
        return getTeacherByName(university, lastName, firstName, patronym);
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

    public Teacher getTeacherByName(University university, String lastName, String firstName, String patronym) {
        return university.getFaculties().stream()
                .flatMap(faculty -> faculty.getDepartments().stream())
                .flatMap(department -> department.getTeachers().stream())
                .filter(teacher -> teacher.getLastName().equals(lastName) &&
                        teacher.getFirstName().equals(firstName) &&
                        teacher.getPatronym().equals(patronym)).findFirst().get();
    }

    private Student getStudentFromConsole(University university) {
        String lastName = getLastNameFromConsole();
        String firstName = getFirstNameFromConsole();
        String patronym = getPatronymFromConsole();
        return getStudentByName(university, lastName, firstName, patronym);
    }

    public Student getStudentByName(University university, String lastName, String firstName, String patronym) {
        return university.getFaculties().stream()
                .flatMap(faculty -> faculty.getDepartments().stream())
                .flatMap(department -> department.getGroups().stream())
                .flatMap(group -> group.getStudents().stream())
                .filter(student -> student.getLastName().equals(lastName) &&
                        student.getFirstName().equals(firstName) &&
                        student.getPatronym().equals(patronym)).findFirst().get();
    }

    private Group getGroupFromConsole(University university) {
        return getGroupByName(university, getNameForGroup());
    }

    private String getNameForGroup() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a name");
        return scanner.next();
    }

    public Group getGroupByName(University university, String name) {
        return university.getFaculties().stream()
                .flatMap(faculty -> faculty.getDepartments().stream())
                .flatMap(department -> department.getGroups().stream())
                .filter(group -> group.getName().equals(name)).findFirst().get();
    }

    private DailySchedule getDailyScheduleForUser(University university, MonthlySchedule monthlySchedule) {
        int choiceForWho = getChoiceForWhoScheduleFromConsole();
        int choiceDay = getChoiceDayFromConsole();
        if (choiceForWho == 1) {
            Teacher teacher = getTeacherFromConsole(university);
            return getDailyScheduleForTeacher(monthlySchedule, teacher, choiceDay);
        }
        if (choiceForWho == 2) {
            Student student = getStudentFromConsole(university);
            return getDailyScheduleForStudent(monthlySchedule, student, choiceDay);
        }
        if (choiceForWho == 3) {
            Group group = getGroupFromConsole(university);
            return getDailyScheduleForGroup(monthlySchedule, group, choiceDay);
        }
        return DailySchedule.EMPTY_DAILYSCHEDULE;
    }

    private int getChoiceDayFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a day");
        return scanner.nextInt();
    }

    public DailySchedule getDailyScheduleForTeacher(MonthlySchedule monthlySchedule, Teacher teacher, int day) {
        return monthlySchedule.getMonthlyScheduleForTeacher(teacher).stream()
                .filter(dailySchedule -> dailySchedule.getDate().getDayOfMonth() == day).findFirst().get();
    }

    public DailySchedule getDailyScheduleForStudent(MonthlySchedule monthlySchedule, Student student, int day) {
        return monthlySchedule.getMonthlyScheduleForStudent(student).stream()
                .filter(dailySchedule -> dailySchedule.getDate().getDayOfMonth() == day).findFirst().get();
    }

    public DailySchedule getDailyScheduleForGroup(MonthlySchedule monthlySchedule, Group group, int day) {
        return monthlySchedule.getMonthlyScheduleForGroup(group).stream()
                .filter(dailySchedule -> dailySchedule.getDate().getDayOfMonth() == day).findFirst().get();
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
}
