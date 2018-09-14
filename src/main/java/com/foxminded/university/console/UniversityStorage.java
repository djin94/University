package com.foxminded.university.console;

import com.foxminded.university.domain.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class UniversityStorage {
    private UniversityStorage universityStorage;
    private University university;
    private MonthlySchedule monthlyScheduleForSeptember;

    private UniversityStorage() {
    }

    public UniversityStorage getInstance() {
        if (universityStorage == null) {
            universityStorage = new UniversityStorage();
            universityStorage.createRsreuUniversity();
            universityStorage.createMonthlyScheduleForSeptember();
        }
        return universityStorage;
    }

    private University createRsreuUniversity() {
        university = new University();
        university.setName("RSREU");
        university.setFaculties(createFaculties());
        return university;
    }

    private List<Faculty> createFaculties() {
        List<Faculty> faculties = new ArrayList<>();
        faculties.add(createFaituFaculty());
        return faculties;
    }

    private Faculty createFaituFaculty() {
        Faculty faituFaculty = new Faculty();
        faituFaculty.setName("FAITU");
        faituFaculty.setAudiences(createFaituAudiences());
        faituFaculty.setDepartments(createFaituDepartments());
        return faituFaculty;
    }

    private List<Audience> createFaituAudiences() {
        List<Audience> audiences = new ArrayList<>();
        audiences.add(createAudience313());
        return audiences;
    }

    private Audience createAudience313() {
        Audience audience313 = new Audience();
        audience313.setNumber(313);
        audience313.setBuilding(1);
        audience313.setType("Laboratory");
        return audience313;
    }

    private List<Department> createFaituDepartments() {
        List<Department> departments = new ArrayList<>();
        departments.add(createAsuDepartment());
        return departments;
    }

    private Department createAsuDepartment() {
        Department asuDepartment = new Department();
        asuDepartment.setName("ASU");
        asuDepartment.setGroups(createAsuGroups());
        asuDepartment.setTeachers(createAsuTeachers());
        asuDepartment.setSubjects(createAsuSubjects());
        return asuDepartment;
    }

    private List<Group> createAsuGroups() {
        List<Group> groups = new ArrayList<>();
        groups.add(createGroup3033());
        return groups;
    }

    private Group createGroup3033() {
        Group group3033 = new Group();
        group3033.setName("3033");
        group3033.setStudents(createGroup3033Students());
        return group3033;
    }

    private List<Student> createGroup3033Students() {
        List<Student> students = new ArrayList<>();
        students.add(createKabatovStudent());
        return students;
    }

    private Student createKabatovStudent() {
        Student kabatovStudent = new Student();
        kabatovStudent.setFirstName("Evgeny");
        kabatovStudent.setPatronym("Nikolaevich");
        kabatovStudent.setLastName("Kabatov");
        kabatovStudent.setNumberOfMarkBook(230110);
        return kabatovStudent;
    }

    private List<Teacher> createAsuTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        teachers.add(createHolopovTeacher());
        return teachers;
    }

    private Teacher createHolopovTeacher() {
        Teacher holopovTeacher = new Teacher();
        holopovTeacher.setFirstName("Sergey");
        holopovTeacher.setPatronym("Ivanovich");
        holopovTeacher.setLastName("Holopov");
        holopovTeacher.setEmployeeId(7852);
        holopovTeacher.setSubjects(createHolopovSubjects());
        return holopovTeacher;
    }

    private List<Subject> createHolopovSubjects(){
        List<Subject> subjects = new ArrayList<>();
        subjects.add(createPlisSubject());
        subjects.add(createPoisSubject());
        return subjects;
    }

    private Subject createPlisSubject() {
        Subject plisSubject = new Subject();
        plisSubject.setName("PLIS");
        plisSubject.setHoursInSemestr(120);
        return plisSubject;
    }

    private Subject createPoisSubject() {
        Subject poisSubject = new Subject();
        poisSubject.setName("POIS");
        poisSubject.setHoursInSemestr(116);
        return poisSubject;
    }

    private List<Subject> createAsuSubjects(){
        List<Subject> subjects = new ArrayList<>();
        subjects.add(createPlisSubject());
        subjects.add(createPoisSubject());
        return subjects;
    }

    private MonthlySchedule createMonthlyScheduleForSeptember() {
        MonthlySchedule monthlyScheduleForUniversity = new MonthlySchedule();
        monthlyScheduleForUniversity.setMonth(9);
        monthlyScheduleForUniversity.setYear(2018);
        monthlyScheduleForUniversity.setDailySchedules(createSeptemberDailySchedules());
        return monthlyScheduleForUniversity;
    }

    private List<DailySchedule> createSeptemberDailySchedules(){
        List<DailySchedule> dailySchedules = new ArrayList<>();
        dailySchedules.add(createSeptember10DailySchedule());
        return dailySchedules;
    }

    private DailySchedule createSeptember10DailySchedule() {
        DailySchedule sep10DailySchedule= new DailySchedule();
        sep10DailySchedule.setDate(LocalDate.of(2018, 9, 10));
        sep10DailySchedule.setLessons(createSeptember10Lessons());
        return sep10DailySchedule;
    }

    private List<Lesson> createSeptember10Lessons(){
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
