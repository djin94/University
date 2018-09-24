package com.foxminded.university.domain.university;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UniversityTest {
    private University university;
    private Faculty faituFaculty;

    private List<Faculty> storedFaculties;
    private List<Faculty> emptyStoredFaculties;

    private University updateUniversity;


    @Before
    public void setUp() {
        faituFaculty = new Faculty();
        faituFaculty.setName("FAITU");

        university = new University();
        university.setName("RSREU");
        university.add(faituFaculty);

        storedFaculties = new ArrayList<>();
        storedFaculties.add(faituFaculty);

        emptyStoredFaculties = new ArrayList<>();

        updateUniversity = new University();
        updateUniversity.setName("Moscow Institute of Physics and Technology ");
    }

    @Test
    public void shouldAddFacultyToUniversity_WhenAddFacultyToUniversity() {
        List<Faculty> expectedFaculties = storedFaculties;
        List<Faculty> actualStoredFaculties = university.getFaculties();

        assertEquals(expectedFaculties, actualStoredFaculties);
    }

    @Test
    public void shouldRemoveFacultyFromUniversity_WhenRemoveFacultyFromUniversity() {
        university.remove(faituFaculty);

        List<Faculty> expectedFaculties = emptyStoredFaculties;
        List<Faculty> actualStoredFaculties = university.getFaculties();

        assertEquals(expectedFaculties, actualStoredFaculties);
    }

    @Test
    public void shouldUpdateUniversity_WhenUpdateUniversity() {
        university.update(updateUniversity);

        University expectedUniversity = updateUniversity;
        University actualUniversity = university;

        assertEquals(expectedUniversity, actualUniversity);
    }


}