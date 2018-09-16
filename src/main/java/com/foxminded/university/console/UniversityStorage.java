package com.foxminded.university.console;

import com.foxminded.university.domain.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class UniversityStorage {
    private static UniversityStorage universityStorage;
    private University rsreuUniversity;
    private MonthlySchedule monthlyScheduleForSeptember;

    private UniversityStorage() {
    }

    public static UniversityStorage getInstance() {
        if (universityStorage == null) {
            universityStorage = new UniversityStorage();
            universityStorage.rsreuUniversity = universityStorage.createRsreuUniversity();
            universityStorage.monthlyScheduleForSeptember = universityStorage.createSeptemberMonthlySchedule();
        }
        return universityStorage;
    }

    public University getRsreuUniversity() {
        return rsreuUniversity;
    }

    public MonthlySchedule getMonthlyScheduleForSeptember() {
        return monthlyScheduleForSeptember;
    }

    private University createRsreuUniversity() {
        University rsreuUniversity = new University();
        rsreuUniversity.setName("Ryazan State Radioengineering University");
        rsreuUniversity.setFaculties(createRsreuFaculties());
        return rsreuUniversity;
    }

    private List<Faculty> createRsreuFaculties() {
        List<Faculty> rsreuFaculties = new ArrayList<>();
        rsreuFaculties.add(createFaituFaculty());
        rsreuFaculties.add(createFeFaculty());
        return rsreuFaculties;
    }

    private Faculty createFaituFaculty() {
        Faculty faituFaculty = new Faculty();
        faituFaculty.setName("Faculty of Automation and Information Technologies in System Management");
        faituFaculty.setAudiences(createFaituAudiences());
        faituFaculty.setDepartments(createFaituDepartments());
        return faituFaculty;
    }

    private List<Audience> createFaituAudiences() {
        List<Audience> faituAudiences = new ArrayList<>();
        faituAudiences.add(createAudience313());
        return faituAudiences;
    }

    private Audience createAudience313() {
        Audience audience313 = new Audience();
        audience313.setNumber(313);
        audience313.setBuilding(1);
        audience313.setType("Laboratory");
        return audience313;
    }

    private List<Department> createFaituDepartments() {
        List<Department> faituDepartments = new ArrayList<>();
        faituDepartments.add(createAcsDepartment());
        return faituDepartments;
    }

    private Department createAcsDepartment() {
        Department acsDepartment = new Department();
        acsDepartment.setName("Automated control systems");
        acsDepartment.setGroups(createAcsGroups());
        acsDepartment.setTeachers(createAcsTeachers());
        acsDepartment.setSubjects(createAcsSubjects());
        return acsDepartment;
    }

    private List<Group> createAcsGroups() {
        List<Group> acsGroups = new ArrayList<>();
        acsGroups.add(createGroup3033());
        return acsGroups;
    }

    private Group createGroup3033() {
        Group group3033 = new Group();
        group3033.setName("3033");
        group3033.setStudents(createGroup3033Students());
        return group3033;
    }

    private List<Student> createGroup3033Students() {
        List<Student> group3033Students = new ArrayList<>();
        group3033Students.add(createKabatovStudent());
        return group3033Students;
    }

    private Student createKabatovStudent() {
        Student kabatovStudent = new Student();
        kabatovStudent.setFirstName("Evgeny");
        kabatovStudent.setPatronym("Nikolaevich");
        kabatovStudent.setLastName("Kabatov");
        kabatovStudent.setNumberOfMarkBook(230110);
        return kabatovStudent;
    }

    private List<Teacher> createAcsTeachers() {
        List<Teacher> acsTeachers = new ArrayList<>();
        acsTeachers.add(createHolopovTeacher());
        return acsTeachers;
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

    private List<Subject> createHolopovSubjects() {
        List<Subject> holopovSubjects = new ArrayList<>();
        holopovSubjects.add(createPlicSubject());
        holopovSubjects.add(createIssSubject());
        return holopovSubjects;
    }

    private Subject createPlicSubject() {
        Subject plicSubject = new Subject();
        plicSubject.setName("Programming of logic integrated circuits");
        plicSubject.setHoursInSemestr(120);
        return plicSubject;
    }

    private Subject createIssSubject() {
        Subject issSubject = new Subject();
        issSubject.setName("Information systems software");
        issSubject.setHoursInSemestr(116);
        return issSubject;
    }

    private List<Subject> createAcsSubjects() {
        List<Subject> acsSubjects = new ArrayList<>();
        acsSubjects.add(createPlicSubject());
        acsSubjects.add(createIssSubject());
        return acsSubjects;
    }

    private Faculty createFeFaculty() {
        Faculty feFaculty = new Faculty();
        feFaculty.setName("Faculty electronics");
        feFaculty.setAudiences(createFeAudiences());
        feFaculty.setDepartments(createFeDepartments());
        return feFaculty;
    }

    private List<Audience> createFeAudiences() {
        List<Audience> feAudiences = new ArrayList<>();
        feAudiences.add(createAudience215());
        return feAudiences;
    }

    private Audience createAudience215() {
        Audience audience215 = new Audience();
        audience215.setNumber(215);
        audience215.setBuilding(1);
        audience215.setType("Lecture hall");
        return audience215;
    }

    private List<Department> createFeDepartments() {
        List<Department> feDepartments = new ArrayList<>();
        feDepartments.add(createEdDepartment());
        return feDepartments;
    }

    private Department createEdDepartment() {
        Department edDepartment = new Department();
        edDepartment.setName("Electronic devices");
        edDepartment.setTeachers(createEdTeachers());
        edDepartment.setGroups(createEdGroups());
        edDepartment.setSubjects(creteEdSubjects());
        return edDepartment;
    }

    private List<Teacher> createEdTeachers() {
        List<Teacher> edTeachers = new ArrayList<>();
        edTeachers.add(createChirkinTeacher());
        return edTeachers;
    }

    private Teacher createChirkinTeacher() {
        Teacher chirkinTeacher = new Teacher();
        chirkinTeacher.setLastName("Chirkin");
        chirkinTeacher.setFirstName("Mikhail");
        chirkinTeacher.setPatronym("Viktorovich");
        chirkinTeacher.setEmployeeId(1425);
        chirkinTeacher.setSubjects(createChirkinSubjects());
        return chirkinTeacher;
    }

    private List<Subject> createChirkinSubjects() {
        List<Subject> chirkinSubjects = new ArrayList<>();
        chirkinSubjects.add(createDddSubject());
        return chirkinSubjects;
    }

    private Subject createDddSubject() {
        Subject dddSubject = new Subject();
        dddSubject.setName("Designing of digital devices");
        dddSubject.setHoursInSemestr(112);
        return dddSubject;
    }

    private List<Group> createEdGroups() {
        List<Group> edGroups = new ArrayList<>();
        edGroups.add(createGroup2054());
        return edGroups;
    }

    private Group createGroup2054() {
        Group group2054 = new Group();
        group2054.setName("2054");
        group2054.setStudents(createGroup2054Students());
        return group2054;
    }

    private List<Student> createGroup2054Students() {
        List<Student> group2054Students = new ArrayList<>();
        group2054Students.add(createZemovStudent());
        return group2054Students;
    }

    private Student createZemovStudent() {
        Student zemovStudent = new Student();
        zemovStudent.setLastName("Zemov");
        zemovStudent.setFirstName("Maksim");
        zemovStudent.setPatronym("Alexandrovich");
        zemovStudent.setNumberOfMarkBook(245789);
        return zemovStudent;
    }

    private List<Subject> creteEdSubjects() {
        List<Subject> edSubjects = new ArrayList<>();
        edSubjects.add(createDddSubject());
        return edSubjects;
    }

    private MonthlySchedule createSeptemberMonthlySchedule() {
        MonthlySchedule septemberMonthlySchedule = new MonthlySchedule();
        septemberMonthlySchedule.setMonth(9);
        septemberMonthlySchedule.setYear(2018);
        septemberMonthlySchedule.setDailySchedules(createSeptemberDailySchedules());
        return septemberMonthlySchedule;
    }

    private List<DailySchedule> createSeptemberDailySchedules() {
        List<DailySchedule> septemberDailySchedules = new ArrayList<>();
        septemberDailySchedules.add(createSeptember10DailySchedule());
        return septemberDailySchedules;
    }

    private DailySchedule createSeptember10DailySchedule() {
        DailySchedule sep10DailySchedule = new DailySchedule();
        sep10DailySchedule.setDate(LocalDate.of(2018, 9, 10));
        sep10DailySchedule.setLessons(createSeptember10Lessons());
        return sep10DailySchedule;
    }

    private List<Lesson> createSeptember10Lessons() {
        List<Lesson> september10Lessons = new ArrayList<>();
        september10Lessons.add(createPlicLessonForGroup3033AndForHolopov());
        september10Lessons.add(createIssLessonForGroup3033AndForHolopov());
        september10Lessons.add(createDddLessonForGroup2054AndForChirkin());
        return september10Lessons;
    }

    private Lesson createPlicLessonForGroup3033AndForHolopov() {
        Lesson plicLesson = new Lesson();
        plicLesson.setSubject(createPlicSubject());
        plicLesson.setGroup(createGroup3033());
        plicLesson.setTeacher(createHolopovTeacher());
        plicLesson.setAudience(createAudience313());
        plicLesson.setTimeStart(LocalTime.of(9, 55));
        return plicLesson;
    }

    private Lesson createIssLessonForGroup3033AndForHolopov() {
        Lesson issLesson = new Lesson();
        issLesson.setSubject(createIssSubject());
        issLesson.setGroup(createGroup3033());
        issLesson.setTeacher(createHolopovTeacher());
        issLesson.setAudience(createAudience313());
        issLesson.setTimeStart(LocalTime.of(11, 40));
        return issLesson;
    }

    private Lesson createDddLessonForGroup2054AndForChirkin() {
        Lesson dddLesson = new Lesson();
        dddLesson.setSubject(createDddSubject());
        dddLesson.setGroup(createGroup2054());
        dddLesson.setTeacher(createChirkinTeacher());
        dddLesson.setAudience(createAudience215());
        dddLesson.setTimeStart(LocalTime.of(9, 55));
        return dddLesson;
    }

    public DailySchedule getDailyScheduleForTeacher(Teacher teacher, int day) {
        return monthlyScheduleForSeptember.getMonthlyScheduleForTeacher(teacher).stream()
                .filter(dailySchedule -> dailySchedule.getDate().getDayOfMonth() == day).findFirst().get();
    }

    public DailySchedule getDailyScheduleForStudent(Student student, int day) {
        return monthlyScheduleForSeptember.getMonthlyScheduleForStudent(student).stream()
                .filter(dailySchedule -> dailySchedule.getDate().getDayOfMonth() == day).findFirst().get();
    }

    public DailySchedule getDailyScheduleForGroup(Group group, int day) {
        return monthlyScheduleForSeptember.getMonthlyScheduleForGroup(group).stream()
                .filter(dailySchedule -> dailySchedule.getDate().getDayOfMonth() == day).findFirst().get();
    }
}