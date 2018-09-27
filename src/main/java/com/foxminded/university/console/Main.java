package com.foxminded.university.console;

import com.foxminded.university.domain.schedule.*;
import com.foxminded.university.domain.university.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        boolean stop;
        Main main = new Main();
        System.out.println("Hello! Whose and what schedule do you want to see?");
        do {
            try {
                main.printUniversityStructure();
                List<DailySchedule> userSchedule = main.createUserSchedule();
                main.printSchedule(userSchedule);
            } catch (Exception e) {
                System.out.println("Enter only the specified numbers");
            } finally {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Do you want to continue? (y/n)");
                stop = scanner.next().equals("n");
            }
        } while (!stop);
    }

    private void printUniversityStructure() {
        System.out.println(UniversityStorage.getInstance().getUniversity().getUniversityStructure());
    }

    private List<DailySchedule> createUserSchedule() {
        int choice = getChoiceFromConsole("Choose schedule type: 1 - For month, 2 - For day");
        List<DailySchedule> userSchedule = new ArrayList<>();
        if (choice == 1) {
            userSchedule.addAll(getUserMonthlySchedule());
        }
        if (choice == 2) {
            userSchedule.add(getUserDailySchedule().get());
        }
        return userSchedule;
    }

    private int getChoiceFromConsole(String printString) {
        System.out.println(printString);
        return getNumberFromConsole();
    }

    private int getNumberFromConsole() {
        return getNumberFromConsole();
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
            return monthlySchedule.findMonthlySchedule(teacher);
        }
        if (choiceWhoseSchedule == 2) {
            Group group = chosenDepartment.getGroups().get(getChoiceGroupFromConsole(chosenDepartment) - 1);
            Student student = group.getStudents().get(getChoiceStudentFromConsole(group) - 1);
            return monthlySchedule.findMonthlySchedule(student);
        }
        if (choiceWhoseSchedule == 3) {
            Group group = chosenDepartment.getGroups().get(getChoiceGroupFromConsole(chosenDepartment) - 1);
            return monthlySchedule.findMonthlySchedule(group);
        }
        return Collections.emptyList();
    }

    private int getChoiceDepartmentFromConsole(Faculty faculty) {
        System.out.println("Choose department:");
        System.out.println(faculty.showListDepartment());
        return getNumberFromConsole();
    }

    private int getChoiceTeacherFromConsole(Department department) {
        System.out.println("Choose teacher:");
        System.out.println(department.showListTeachers());
        return getNumberFromConsole();
    }

    private int getChoiceGroupFromConsole(Department department) {
        System.out.println("Choose group:");
        System.out.println(department.showListGroups());
        return getNumberFromConsole();
    }

    private int getChoiceStudentFromConsole(Group group) {
        System.out.println("Choose student:");
        System.out.println(showListStudents(group));
        return getNumberFromConsole();
    }

    public String showListStudents(Group group) {
        String listStudents = group.getName() + "\n";
        for (int i = 0; i < group.getStudents().size(); i++)
            listStudents += String.valueOf(i + 1) + " - " + group.getStudents().get(i) + "\n";
        return listStudents;
    }

    private Optional<DailySchedule> getUserDailySchedule() {
        University university = UniversityStorage.getInstance().getUniversity();
        int choiceWhoseSchedule = getChoiceFromConsole("Choose and write: 1 - Teacher, 2 - Student, 3 - Group");
        int choiceDay = getDayFromConsole();
        int choiceFaculty = getChoiceFromConsole("Choose faculty:\n" + university.getListFaculties());
        int choiceDepartment = getChoiceDepartmentFromConsole(university.getFaculties().get(choiceFaculty - 1));
        Department department = university.getFaculties().get(choiceFaculty - 1).getDepartments().get(choiceDepartment - 1);
        if (choiceWhoseSchedule == 1) {
            Teacher teacher = department.getTeachers().get(getChoiceTeacherFromConsole(department) - 1);
            return UniversityStorage.getInstance().findDailyScheduleForTeacher(teacher, choiceDay);
        }
        if (choiceWhoseSchedule == 2) {
            Group group = department.getGroups().get(getChoiceGroupFromConsole(department) - 1);
            Student student = group.getStudents().get(getChoiceStudentFromConsole(group) - 1);
            return UniversityStorage.getInstance().findDailyScheduleForStudent(student, choiceDay);
        }
        if (choiceWhoseSchedule == 3) {
            Group group = department.getGroups().get(getChoiceGroupFromConsole(department) - 1);
            return UniversityStorage.getInstance().findDailyScheduleForGroup(group, choiceDay);
        }
        return Optional.empty();
    }

    private int getDayFromConsole() {
        System.out.println("Enter a day");
        return getNumberFromConsole();
    }

    private void printSchedule(List<DailySchedule> dailySchedules) {
        dailySchedules.stream()
                .flatMap(dailySchedule -> dailySchedule.getLessons().stream())
                .forEach(System.out::println);
    }
}
