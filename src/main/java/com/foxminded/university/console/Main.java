package com.foxminded.university.console;

import com.foxminded.university.domain.schedule.DailySchedule;
import com.foxminded.university.domain.schedule.MonthlySchedule;
import com.foxminded.university.domain.university.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        boolean stop;
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();
        System.out.println("Hello! Whose and what schedule do you want to see?");
        do {
            try {
                main.printUniversityStructure();
                List<DailySchedule> userSchedule = main.getUserSchedule();
                main.printSchedule(userSchedule);
            } catch (Exception e) {
                System.out.println("Enter only the specified numbers");
            } finally {
                System.out.println("Do you want to continue? (y/n)");
                stop = scanner.next().equals("n");
            }
        } while (!stop);
    }

    private void printUniversityStructure() {
        System.out.println(UniversityStorage.getInstance().getUniversity().getUniversityStructure());
    }

    private List<DailySchedule> getUserSchedule() {
        List<DailySchedule> scheduleForUser = new ArrayList<>();
        int choice = getInt();
        if (choice == 1) {
            scheduleForUser.addAll(getUserMonthlySchedule());
        }
        if (choice == 2) {
            scheduleForUser.add(getUserDailySchedule().get());
        }
        return scheduleForUser;
    }

    private int getInt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose schedule type: 1 - For month, 2 - For day");
        return scanner.nextInt();
    }

    private List<DailySchedule> getUserMonthlySchedule() {
        University university = UniversityStorage.getInstance().getUniversity();
        MonthlySchedule monthlySchedule = UniversityStorage.getInstance().getMonthlyScheduleForSeptember();
        int choiceWhoseSchedule = getChoiceFromConsole("Choose and write: 1 - Teacher, 2 - Student, 3 - Group");
        int choiceFaculty = getChoiceFromConsole("Choose faculty:\n" + university.getListFaculties());
        int choiceDepartment = getChoiceDepartmentFromConsole(university.getFaculties().get(choiceFaculty - 1));
        Department chosenDepartment = university.getFaculties().get(choiceFaculty - 1).getDepartments().get(choiceDepartment - 1);
        if (choiceWhoseSchedule == 1) {
            Teacher teacher = chosenDepartment.getTeachers().get(getChoiceTeacherFromConsole(chosenDepartment) - 1);
            return monthlySchedule.getMonthlyScheduleForTeacher(teacher);
        }
        if (choiceWhoseSchedule == 2) {
            Group group = chosenDepartment.getGroups().get(getChoiceGroupFromConsole(chosenDepartment) - 1);
            Student student = group.getStudents().get(getChoiceStudentFromConsole(group) - 1);
            return monthlySchedule.getMonthlyScheduleForStudent(student);
        }
        if (choiceWhoseSchedule == 3) {
            Group group = chosenDepartment.getGroups().get(getChoiceGroupFromConsole(chosenDepartment) - 1);
            return monthlySchedule.getMonthlyScheduleForGroup(group);
        }
        return Collections.emptyList();
    }

    private int getChoiceFromConsole(String printString) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(printString);
        return scanner.nextInt();
    }

    private int getChoiceDepartmentFromConsole(Faculty faculty) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose department:");
        System.out.println(faculty.showListDepartment());
        return scanner.nextInt();
    }

    private int getChoiceTeacherFromConsole(Department department) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose teacher:");
        System.out.println(department.showListTeachers());
        return scanner.nextInt();
    }

    private int getChoiceGroupFromConsole(Department department) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose group:");
        System.out.println(department.showListGroups());
        return scanner.nextInt();
    }

    private int getChoiceStudentFromConsole(Group group) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose student:");
        System.out.println(group.showListStudents());
        return scanner.nextInt();
    }

    private Optional<DailySchedule> getUserDailySchedule() {
        University university = UniversityStorage.getInstance().getUniversity();
        int choiceWhoseSchedule = getChoiceFromConsole("Choose and write: 1 - Teacher, 2 - Student, 3 - Group");
        int choiceDay = getChoiceDayFromConsole();
        int choiceFaculty = getChoiceFromConsole("Choose faculty:\n" + university.getListFaculties());
        int choiceDepartment = getChoiceDepartmentFromConsole(university.getFaculties().get(choiceFaculty - 1));
        Department department = university.getFaculties().get(choiceFaculty - 1).getDepartments().get(choiceDepartment - 1);
        if (choiceWhoseSchedule == 1) {
            Teacher teacher = department.getTeachers().get(getChoiceTeacherFromConsole(department) - 1);
            return UniversityStorage.getInstance().getDailyScheduleForTeacher(teacher, choiceDay);
        }
        if (choiceWhoseSchedule == 2) {
            Group group = department.getGroups().get(getChoiceGroupFromConsole(department) - 1);
            Student student = group.getStudents().get(getChoiceStudentFromConsole(group) - 1);
            return UniversityStorage.getInstance().getDailyScheduleForStudent(student, choiceDay);
        }
        if (choiceWhoseSchedule == 3) {
            Group group = department.getGroups().get(getChoiceGroupFromConsole(department) - 1);
            return UniversityStorage.getInstance().getDailyScheduleForGroup(group, choiceDay);
        }
        return Optional.empty();
    }

    private int getChoiceDayFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a day");
        return scanner.nextInt();
    }

    private void printSchedule(List<DailySchedule> dailySchedules) {
        dailySchedules.stream().flatMap(dailySchedule -> dailySchedule.getLessons().stream())
                .forEach(System.out::println);
    }
}
