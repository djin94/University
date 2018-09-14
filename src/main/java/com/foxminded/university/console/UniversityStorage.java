package com.foxminded.university.console;

import com.foxminded.university.domain.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class UniversityStorage {
    private static UniversityStorage universityStorage;
    private University university;
    private MonthlySchedule monthlyScheduleForSeptember;

    private UniversityStorage() {
    }

    public static UniversityStorage getInstance() {
        if (universityStorage == null) {
            universityStorage = new UniversityStorage();
            universityStorage.university = universityStorage.createRsreuUniversity();
            universityStorage.monthlyScheduleForSeptember = universityStorage.createMonthlyScheduleForSeptember();
        }
        return universityStorage;
    }

    public University getRsreuUniversity() {
        return university;
    }

    public MonthlySchedule getMonthlyScheduleForSeptember() {
        return monthlyScheduleForSeptember;
    }

    private University createRsreuUniversity() {
        University university = new University();
        university.setName("RSREU");
        university.setFaculties(createRsreuFaculties());
        return university;
    }

    private List<Faculty> createRsreuFaculties() {
        List<Faculty> faculties = new ArrayList<>();
        faculties.add(createFaituFaculty());
        return faculties;
    }

    private Faculty createFaituFaculty() {
        Faculty faculty = new Faculty();
        faculty.setName("FAITU");
        faculty.setAudiences(createFaituAudiences());
        faculty.setDepartments(createFaituDepartments());
        return faculty;
    }

    private List<Audience> createFaituAudiences() {
        List<Audience> audiences = new ArrayList<>();
        audiences.add(createAudience313());
        return audiences;
    }

    private Audience createAudience313() {
        Audience audience = new Audience();
        audience.setNumber(313);
        audience.setBuilding(1);
        audience.setType("Laboratory");
        return audience;
    }

    private List<Department> createFaituDepartments() {
        List<Department> departments = new ArrayList<>();
        departments.add(createAsuDepartment());
        return departments;
    }

    private Department createAsuDepartment() {
        Department department = new Department();
        department.setName("ASU");
        department.setGroups(createAsuGroups());
        department.setTeachers(createAsuTeachers());
        department.setSubjects(createAsuSubjects());
        return department;
    }

    private List<Group> createAsuGroups() {
        List<Group> groups = new ArrayList<>();
        groups.add(createGroup3033());
        return groups;
    }

    private Group createGroup3033() {
        Group group = new Group();
        group.setName("3033");
        group.setStudents(createGroup3033Students());
        return group;
    }

    private List<Student> createGroup3033Students() {
        List<Student> students = new ArrayList<>();
        students.add(createKabatovStudent());
        return students;
    }

    private Student createKabatovStudent() {
        Student student = new Student();
        student.setFirstName("Evgeny");
        student.setPatronym("Nikolaevich");
        student.setLastName("Kabatov");
        student.setNumberOfMarkBook(230110);
        return student;
    }

    private List<Teacher> createAsuTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        teachers.add(createHolopovTeacher());
        return teachers;
    }

    private Teacher createHolopovTeacher() {
        Teacher teacher = new Teacher();
        teacher.setFirstName("Sergey");
        teacher.setPatronym("Ivanovich");
        teacher.setLastName("Holopov");
        teacher.setEmployeeId(7852);
        teacher.setSubjects(createHolopovSubjects());
        return teacher;
    }

    private List<Subject> createHolopovSubjects() {
        List<Subject> subjects = new ArrayList<>();
        subjects.add(createPlisSubject());
        subjects.add(createPoisSubject());
        return subjects;
    }

    private Subject createPlisSubject() {
        Subject subject = new Subject();
        subject.setName("PLIS");
        subject.setHoursInSemestr(120);
        return subject;
    }

    private Subject createPoisSubject() {
        Subject subject = new Subject();
        subject.setName("POIS");
        subject.setHoursInSemestr(116);
        return subject;
    }

    private List<Subject> createAsuSubjects() {
        List<Subject> subjects = new ArrayList<>();
        subjects.add(createPlisSubject());
        subjects.add(createPoisSubject());
        return subjects;
    }

    private MonthlySchedule createMonthlyScheduleForSeptember() {
        MonthlySchedule monthlySchedule = new MonthlySchedule();
        monthlySchedule.setMonth(9);
        monthlySchedule.setYear(2018);
        monthlySchedule.setDailySchedules(createSeptemberDailySchedules());
        return monthlySchedule;
    }

    private List<DailySchedule> createSeptemberDailySchedules() {
        List<DailySchedule> dailySchedules = new ArrayList<>();
        dailySchedules.add(createSeptember10DailySchedule());
        return dailySchedules;
    }

    private DailySchedule createSeptember10DailySchedule() {
        DailySchedule sep10DailySchedule = new DailySchedule();
        sep10DailySchedule.setDate(LocalDate.of(2018, 9, 10));
        sep10DailySchedule.setLessons(createSeptember10Lessons());
        return sep10DailySchedule;
    }

    private List<Lesson> createSeptember10Lessons() {
        List<Lesson> lessons = new ArrayList<>();
        lessons.add(createPlisLesson());
        lessons.add(createPoisLesson());
        return lessons;
    }

    private Lesson createPlisLesson() {
        Lesson plisLesson = new Lesson();
        plisLesson.setSubject(createPlisSubject());
        plisLesson.setGroup(createGroup3033());
        plisLesson.setTeacher(createHolopovTeacher());
        plisLesson.setAudience(createAudience313());
        plisLesson.setTimeStart(LocalTime.of(9, 55));
        return plisLesson;
    }

    private Lesson createPoisLesson() {
        Lesson poisLesson = new Lesson();
        poisLesson.setSubject(createPoisSubject());
        poisLesson.setGroup(createGroup3033());
        poisLesson.setTeacher(createHolopovTeacher());
        poisLesson.setAudience(createAudience313());
        poisLesson.setTimeStart(LocalTime.of(11, 40));
        return poisLesson;
    }
}
