package com.foxminded.university.console;

import com.foxminded.university.domain.schedule.DailySchedule;
import com.foxminded.university.domain.schedule.Lesson;
import com.foxminded.university.domain.schedule.MonthlySchedule;
import com.foxminded.university.domain.university.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class UniversityCreator {
    public University createRyazanStateRadioengineeringUniversity() {
        University ryazanStateRadioengineeringUniversity = new University();
        ryazanStateRadioengineeringUniversity.setName("Ryazan State Radioengineering University");
        ryazanStateRadioengineeringUniversity.setFaculties(createRyazanStateRadioengineeringUniversityFaculties());
        return ryazanStateRadioengineeringUniversity;
    }

    private List<Faculty> createRyazanStateRadioengineeringUniversityFaculties() {
        List<Faculty> ryazanStateRadioengineeringUniversityFaculties = new ArrayList<>();
        ryazanStateRadioengineeringUniversityFaculties.add(createFacultyOfAutomationAndInformationTechnologiesInSystemManagement());
        ryazanStateRadioengineeringUniversityFaculties.add(createElectronicsFaculty());
        return ryazanStateRadioengineeringUniversityFaculties;
    }

    private Faculty createFacultyOfAutomationAndInformationTechnologiesInSystemManagement() {
        Faculty facultyOfAutomationAndInformationTechnologiesInSystemManagement = new Faculty();
        facultyOfAutomationAndInformationTechnologiesInSystemManagement.setName("Faculty of Automation and Information Technologies in System Management");
        facultyOfAutomationAndInformationTechnologiesInSystemManagement.setAudiences(createFacultyOfAutomationAndInformationTechnologiesInSystemManagementAudiences());
        facultyOfAutomationAndInformationTechnologiesInSystemManagement.setDepartments(createFacultyOfAutomationAndInformationTechnologiesInSystemManagementDepartments());
        return facultyOfAutomationAndInformationTechnologiesInSystemManagement;
    }

    private List<Audience> createFacultyOfAutomationAndInformationTechnologiesInSystemManagementAudiences() {
        List<Audience> facultyOfAutomationAndInformationTechnologiesInSystemManagementAudiences = new ArrayList<>();
        facultyOfAutomationAndInformationTechnologiesInSystemManagementAudiences.add(createAudience313());
        return facultyOfAutomationAndInformationTechnologiesInSystemManagementAudiences;
    }

    private Audience createAudience313() {
        Audience audience313 = new Audience();
        audience313.setNumber(313);
        audience313.setBuilding(1);
        audience313.setType("Laboratory");
        return audience313;
    }

    private List<Department> createFacultyOfAutomationAndInformationTechnologiesInSystemManagementDepartments() {
        List<Department> facultyOfAutomationAndInformationTechnologiesInSystemManagementDepartments = new ArrayList<>();
        facultyOfAutomationAndInformationTechnologiesInSystemManagementDepartments.add(createAutomatedControlSystemsDepartment());
        return facultyOfAutomationAndInformationTechnologiesInSystemManagementDepartments;
    }

    private Department createAutomatedControlSystemsDepartment() {
        Department automatedControlSystemsDepartment = new Department();
        automatedControlSystemsDepartment.setName("Automated control systems");
        automatedControlSystemsDepartment.setGroups(createAutomatedControlSystemsDepartmentGroups());
        automatedControlSystemsDepartment.setTeachers(createAutomatedControlSystemsDepartmentTeachers());
        automatedControlSystemsDepartment.setSubjects(createAutomatedControlSystemsDepartmentSubjects());
        return automatedControlSystemsDepartment;
    }

    private List<Group> createAutomatedControlSystemsDepartmentGroups() {
        List<Group> automatedControlSystemsGroups = new ArrayList<>();
        automatedControlSystemsGroups.add(createGroup3033());
        return automatedControlSystemsGroups;
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

    private List<Teacher> createAutomatedControlSystemsDepartmentTeachers() {
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
        holopovSubjects.add(createProgrammingOfLogicIntegratedCircuitsSubject());
        holopovSubjects.add(createInformationSystemsSoftwareSubject());
        return holopovSubjects;
    }

    private Subject createProgrammingOfLogicIntegratedCircuitsSubject() {
        Subject programmingOfLogicIntegratedCircuitsSubject = new Subject();
        programmingOfLogicIntegratedCircuitsSubject.setName("Programming of logic integrated circuits");
        programmingOfLogicIntegratedCircuitsSubject.setHoursInSemestr(120);
        return programmingOfLogicIntegratedCircuitsSubject;
    }

    private Subject createInformationSystemsSoftwareSubject() {
        Subject informationSystemsSoftwareSubject = new Subject();
        informationSystemsSoftwareSubject.setName("Information systems software");
        informationSystemsSoftwareSubject.setHoursInSemestr(116);
        return informationSystemsSoftwareSubject;
    }

    private List<Subject> createAutomatedControlSystemsDepartmentSubjects() {
        List<Subject> automatedControlSystemsDepartmentSubjects = new ArrayList<>();
        automatedControlSystemsDepartmentSubjects.add(createProgrammingOfLogicIntegratedCircuitsSubject());
        automatedControlSystemsDepartmentSubjects.add(createInformationSystemsSoftwareSubject());
        return automatedControlSystemsDepartmentSubjects;
    }

    private Faculty createElectronicsFaculty() {
        Faculty electronicsFaculty = new Faculty();
        electronicsFaculty.setName("Faculty of electronics");
        electronicsFaculty.setAudiences(createElectronicsFacultyAudiences());
        electronicsFaculty.setDepartments(createElectronicsFacultyDepartments());
        return electronicsFaculty;
    }

    private List<Audience> createElectronicsFacultyAudiences() {
        List<Audience> electronicsFacultyAudiences = new ArrayList<>();
        electronicsFacultyAudiences.add(createAudience215());
        return electronicsFacultyAudiences;
    }

    private Audience createAudience215() {
        Audience audience215 = new Audience();
        audience215.setNumber(215);
        audience215.setBuilding(1);
        audience215.setType("Lecture hall");
        return audience215;
    }

    private List<Department> createElectronicsFacultyDepartments() {
        List<Department> feDepartments = new ArrayList<>();
        feDepartments.add(createElectronicDevicesDepartment());
        return feDepartments;
    }

    private Department createElectronicDevicesDepartment() {
        Department electronicDevicesDepartment = new Department();
        electronicDevicesDepartment.setName("Electronic devices");
        electronicDevicesDepartment.setTeachers(createElectronicDevicesDepartmentTeachers());
        electronicDevicesDepartment.setGroups(createElectronicDevicesDepartmentGroups());
        electronicDevicesDepartment.setSubjects(creteElectronicDevicesDepartmentSubjects());
        return electronicDevicesDepartment;
    }

    private List<Teacher> createElectronicDevicesDepartmentTeachers() {
        List<Teacher> electronicDevicesDepartmentTeachers = new ArrayList<>();
        electronicDevicesDepartmentTeachers.add(createChirkinTeacher());
        return electronicDevicesDepartmentTeachers;
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
        chirkinSubjects.add(createDesigningOfDigitalDevicesSubject());
        return chirkinSubjects;
    }

    private Subject createDesigningOfDigitalDevicesSubject() {
        Subject designingOfDigitalDevicesSubject = new Subject();
        designingOfDigitalDevicesSubject.setName("Designing of digital devices");
        designingOfDigitalDevicesSubject.setHoursInSemestr(112);
        return designingOfDigitalDevicesSubject;
    }

    private List<Group> createElectronicDevicesDepartmentGroups() {
        List<Group> electronicDevicesDepartmentGroups = new ArrayList<>();
        electronicDevicesDepartmentGroups.add(createGroup2054());
        return electronicDevicesDepartmentGroups;
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

    private List<Subject> creteElectronicDevicesDepartmentSubjects() {
        List<Subject> electronicDevicesDepartmentSubjects = new ArrayList<>();
        electronicDevicesDepartmentSubjects.add(createDesigningOfDigitalDevicesSubject());
        return electronicDevicesDepartmentSubjects;
    }

    public MonthlySchedule createSeptemberMonthlySchedule() {
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
        DailySchedule september10DailySchedule = new DailySchedule();
        september10DailySchedule.setDate(LocalDate.of(2018, 9, 10));
        september10DailySchedule.setLessons(createSeptember10Lessons());
        return september10DailySchedule;
    }

    private List<Lesson> createSeptember10Lessons() {
        List<Lesson> september10Lessons = new ArrayList<>();
        september10Lessons.add(createProgrammingOfLogicIntegratedCircuitsLessonForGroup3033AndForHolopov());
        september10Lessons.add(createInformationSystemsSoftwareLessonForGroup3033AndForHolopov());
        september10Lessons.add(createDesigningOfDigitalDevicesLessonForGroup2054AndForChirkin());
        return september10Lessons;
    }

    private Lesson createProgrammingOfLogicIntegratedCircuitsLessonForGroup3033AndForHolopov() {
        Lesson programmingOfLogicIntegratedCircuitsLesson = new Lesson();
        programmingOfLogicIntegratedCircuitsLesson.setSubject(createProgrammingOfLogicIntegratedCircuitsSubject());
        programmingOfLogicIntegratedCircuitsLesson.setGroup(createGroup3033());
        programmingOfLogicIntegratedCircuitsLesson.setTeacher(createHolopovTeacher());
        programmingOfLogicIntegratedCircuitsLesson.setAudience(createAudience313());
        programmingOfLogicIntegratedCircuitsLesson.setTimeStart(LocalTime.of(9, 55));
        return programmingOfLogicIntegratedCircuitsLesson;
    }

    private Lesson createInformationSystemsSoftwareLessonForGroup3033AndForHolopov() {
        Lesson informationSystemsSoftwareLesson = new Lesson();
        informationSystemsSoftwareLesson.setSubject(createInformationSystemsSoftwareSubject());
        informationSystemsSoftwareLesson.setGroup(createGroup3033());
        informationSystemsSoftwareLesson.setTeacher(createHolopovTeacher());
        informationSystemsSoftwareLesson.setAudience(createAudience313());
        informationSystemsSoftwareLesson.setTimeStart(LocalTime.of(11, 40));
        return informationSystemsSoftwareLesson;
    }

    private Lesson createDesigningOfDigitalDevicesLessonForGroup2054AndForChirkin() {
        Lesson designingOfDigitalDevicesLesson = new Lesson();
        designingOfDigitalDevicesLesson.setSubject(createDesigningOfDigitalDevicesSubject());
        designingOfDigitalDevicesLesson.setGroup(createGroup2054());
        designingOfDigitalDevicesLesson.setTeacher(createChirkinTeacher());
        designingOfDigitalDevicesLesson.setAudience(createAudience215());
        designingOfDigitalDevicesLesson.setTimeStart(LocalTime.of(9, 55));
        return designingOfDigitalDevicesLesson;
    }
}
