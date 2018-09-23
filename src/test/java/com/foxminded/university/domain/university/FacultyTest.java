package com.foxminded.university.domain.university;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FacultyTest {
    private Faculty faituFaculty;
    private Audience audience313;
    private Department acsDepartment;
    private List<Department> storedDepartments;
    private List<Department> emptyStoredDepartments;
    private List<Audience> storedAudiences;
    private List<Audience> emptyStoredAudiences;

    private Faculty updateFaculty;

    @Before
    public void setUp() {
        acsDepartment = new Department();
        acsDepartment.setName("ASU");

        audience313 = new Audience();
        audience313.setNumber(313);
        audience313.setBuilding(1);
        audience313.setType("Laboratory");

        faituFaculty = new Faculty();
        faituFaculty.setName("FAITU");
        faituFaculty.addAudience(audience313);
        faituFaculty.addDepartment(acsDepartment);

        storedDepartments = new ArrayList<>();
        storedDepartments.add(acsDepartment);

        emptyStoredDepartments = new ArrayList<>();

        storedAudiences = new ArrayList<>();
        storedAudiences.add(audience313);

        emptyStoredAudiences = new ArrayList<>();

        updateFaculty = new Faculty();
        updateFaculty.setName("General and applied physics");
    }

    @Test
    public void shouldAddAudienceToFaculty_WhenAddAudienceToFaculty() {
        List<Audience> expectedAudiences = storedAudiences;
        List<Audience> actualStoredAudiences = faituFaculty.getAudiences();

        assertEquals(expectedAudiences, actualStoredAudiences);
    }

    @Test
    public void shouldRemoveAudienceFromFaculty_WhenRemoveAudienceFromFaculty() {
        faituFaculty.removeAudience(audience313);

        List<Audience> expectedAudiences = emptyStoredAudiences;
        List<Audience> actualStoredAudiences = faituFaculty.getAudiences();

        assertEquals(expectedAudiences, actualStoredAudiences);
    }

    @Test
    public void shouldAddDepartmentToFaculty_WhenAddDepartmentToFaculty() {
        List<Department> expectedDepartments = storedDepartments;
        List<Department> actualStoredDepartments = faituFaculty.getDepartments();

        assertEquals(expectedDepartments, actualStoredDepartments);
    }

    @Test
    public void shouldRemoveDepartmentFromFaculty_WhenRemoveDepartmentFromFaculty() {
        faituFaculty.removeDepartment(acsDepartment);

        List<Department> expectedDepartments = emptyStoredDepartments;
        List<Department> actualStoredDepartments = faituFaculty.getDepartments();

        assertEquals(expectedDepartments, actualStoredDepartments);
    }

    @Test
    public void shouldUpdateFaculty_WhenUpdateFaculty() {
        faituFaculty.update(updateFaculty);

        Faculty expectedFaculty = updateFaculty;
        Faculty actualFaculty = faituFaculty;

        assertEquals(expectedFaculty, actualFaculty);
    }
}