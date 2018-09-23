package com.foxminded.university.domain.university;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AudienceTest {
    private Audience audience313;
    private Audience updateAudience;

    @Before
    public void setUp() {
        audience313 = new Audience();
        audience313.setNumber(313);
        audience313.setBuilding(1);
        audience313.setType("Laboratory");

        updateAudience = new Audience();
        updateAudience.setNumber(255);
        updateAudience.setBuilding(1);
    }

    @Test
    public void shouldUpdateAudience_WhenUpdateAudience() {
        audience313.update(updateAudience);

        Audience expectedAudience = updateAudience;
        Audience actualAudience = audience313;

        assertEquals(expectedAudience, actualAudience);
    }
}