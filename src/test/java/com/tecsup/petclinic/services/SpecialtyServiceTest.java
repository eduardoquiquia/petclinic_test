package com.tecsup.petclinic.services;

import static org.junit.jupiter.api.Assertions.*;
import com.tecsup.petclinic.entities.Specialty;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
@Slf4j
public class SpecialtyServiceTest {

    @Autowired
    private SpecialtyService specialtyService;

    @Test
    public void testFindSpecialtyById() {
        Integer ID = 1;
        String NAME_EXPECTED = "radiology";
        Specialty specialty = null;
        try {
            specialty = specialtyService.findById(ID);
        } catch (Exception e) {
            fail(e.getMessage());
        }
        log.info("Found: " + specialty);
        assertEquals(NAME_EXPECTED, specialty.getName());
    }

    @Test
    public void testFindSpecialtyByName() {
        String FIND_NAME = "surgery";
        int SIZE_EXPECTED = 1;
        List<Specialty> specialties = specialtyService.findByName(FIND_NAME);
        log.info("Results: " + specialties.size());
        assertEquals(SIZE_EXPECTED, specialties.size());
    }

    @Test
    public void testCreateSpecialty() {
        String NAME = "cardiology";
        String OFFICE = "Building A";
        int H_OPEN = 8;
        int H_CLOSE = 17;
        Specialty specialty = new Specialty(null, NAME, OFFICE, H_OPEN, H_CLOSE);
        Specialty created = specialtyService.create(specialty);
        log.info("Created: " + created);
        assertNotNull(created.getId());
        assertEquals(NAME, created.getName());
    }

    @Test
    public void testUpdateSpecialty() {
        Specialty specialty = new Specialty(null, "neurology", "Block B", 9, 18);
        Specialty created = specialtyService.create(specialty);
        log.info("Created: " + created);
        created.setName("neurology updated");
        created.setOffice("Block C");
        Specialty updated = specialtyService.update(created);
        log.info("Updated: " + updated);
        assertEquals("neurology updated", updated.getName());
        assertEquals("Block C", updated.getOffice());
    }

    @Test
    public void testDeleteSpecialty() {
        Specialty specialty = new Specialty(null, "oncology", "Wing D", 7, 15);
        Specialty created = specialtyService.create(specialty);
        log.info("Created for delete: " + created);
        try {
            specialtyService.delete(created.getId());
        } catch (Exception e) {
            fail(e.getMessage());
        }
        try {
            specialtyService.findById(created.getId());
            assertTrue(false);
        } catch (Exception e) {
            assertTrue(true);
        }
    }
}
