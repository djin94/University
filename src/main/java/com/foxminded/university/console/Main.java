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
        University university = main.getRsreuUniversity();
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
                    System.out.println("Audience: " + lesson.getAudience().getNumber()+"\n");
    });
    }

    private University getRsreuUniversity() {
        Faculty faituFaculty = getFaituFaculty();
        University university = new University();
        university.setName("RSREU");
        university.addFaculty(faituFaculty);
        return university;
    }

    private Faculty getFaituFaculty() {
        Audience audience313 = getAudience313();
        Department asuDepartment = getAsuDepartment();
        Faculty faituFaculty = new Faculty();
        faituFaculty.setName("FAITU");
        faituFaculty.addAudience(audience313);
        faituFaculty.addDepartment(asuDepartment);
        return faituFaculty;
    }

    private Audience getAudience313() {
        Audience audience313 = new Audience();
        audience313.setNumber(313);
        audience313.setBuilding(1);
        audience313.setType("Laboratory");
        return audience313;
    }

    private Department getAsuDepartment() {
        Group group3033 = getGroup3033();
        Teacher holopovTeacher = getHolopovTeacher();
        Subject plisSubject = getPlisSubject();
        Department asuDepartment = new Department();
        asuDepartment.setName("ASU");
        asuDepartment.addGroup(group3033);
        asuDepartment.addTeacher(holopovTeacher);
        asuDepartment.addSubject(plisSubject);
        return asuDepartment;
    }

    private Group getGroup3033() {
        Student kabatovStudent = getKabatovStudent();
        Group group3033 = new Group();
        group3033.setName("3033");
        group3033.addStudent(kabatovStudent);
        return group3033;
    }

    private Student getKabatovStudent() {
        Student kabatovStudent = new Student();
        kabatovStudent.setFirstName("Evgeny");
        kabatovStudent.setPatronym("Nikolaevich");
        kabatovStudent.setLastName("Kabatov");
        kabatovStudent.setNumberOfMarkBook(230110);
        return kabatovStudent;
    }

    private Teacher getHolopovTeacher() {
        Subject plisSubject = getPlisSubject();
        Teacher holopovTeacher = new Teacher();
        holopovTeacher.setFirstName("Sergey");
        holopovTeacher.setPatronym("Ivanovich");
        holopovTeacher.setLastName("Holopov");
        holopovTeacher.setEmployeeId(7852);
        holopovTeacher.addSubject(plisSubject);
        return holopovTeacher;
    }

    private Subject getPlisSubject() {
        Subject plisSubject = new Subject();
        plisSubject.setName("PLIS");
        plisSubject.setHoursInSemestr(120);
        return plisSubject;
    }

    private Subject getPoisSubject(){
        Subject poisSubject = new Subject();
        poisSubject.setName("POIS");
        poisSubject.setHoursInSemestr(116);
        return poisSubject;
    }

    private MonthlySchedule getMonthlySchedyle() {
        Lesson plisLesson = getPlisLesson();
        DailySchedule sep10DailySchedule = getSeptember10DailySchedule();
        MonthlySchedule monthlyScheduleForUniversity = new MonthlySchedule();
        monthlyScheduleForUniversity.setMonth(9);
        monthlyScheduleForUniversity.setYear(2018);
        monthlyScheduleForUniversity.addDailySchedule(sep10DailySchedule);
        return monthlyScheduleForUniversity;
    }

    private DailySchedule getSeptember10DailySchedule() {
        Lesson plisLesson = getPlisLesson();
        DailySchedule sep10DailySchedule;
        sep10DailySchedule = new DailySchedule();
        sep10DailySchedule.setDate(LocalDate.of(2018, 9, 10));
        sep10DailySchedule.addLesson(plisLesson);
        sep10DailySchedule.addLesson(getPoisLesson());
        return sep10DailySchedule;
    }

    private Lesson getPlisLesson() {
        Lesson plisLesson = new Lesson();
        plisLesson.setSubject(getPlisSubject());
        plisLesson.setGroup(getGroup3033());
        plisLesson.setTeacher(getHolopovTeacher());
        plisLesson.setAudience(getAudience313());
        plisLesson.setTimeStart(LocalTime.of(9, 55));
        return plisLesson;
    }

    private Lesson getPoisLesson(){
        Lesson poisLesson = new Lesson();
        poisLesson.setSubject(getPoisSubject());
        poisLesson.setGroup(getGroup3033());
        poisLesson.setTeacher(getHolopovTeacher());
        poisLesson.setAudience(getAudience313());
        poisLesson.setTimeStart(LocalTime.of(11, 40));
        return poisLesson;
    }
}
