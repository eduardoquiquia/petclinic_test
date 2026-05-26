package com.tecsup.petclinic.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tecsup.petclinic.dtos.VisitDTO;
import com.tecsup.petclinic.exceptions.VisitNotFoundException;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class VisitServiceTest {

    @Autowired
    private VisitService visitService;

    /**
     * FIND VISIT BY ID
     */
    @Test
    public void testFindVisitById() {

        Integer ID = 1;
        String DESCRIPTION_EXPECTED = "rabies shot";

        VisitDTO visit = null;

        try {

            visit = visitService.findById(ID);

        } catch (VisitNotFoundException e) {

            fail(e.getMessage());

        }

        log.info("" + visit);

        assertEquals(DESCRIPTION_EXPECTED, visit.getDescription());

    }

    /**
     * FIND VISIT BY PET ID
     */
    @Test
    public void testFindVisitByPetId() {

        Integer PET_ID = 8;

        List<VisitDTO> visits = visitService.findByPetId(PET_ID);

        assertTrue(visits.size() > 0);

    }

    /**
     * CREATE VISIT
     */
    @Test
    public void testCreateVisit() {

        Integer PET_ID = 1;
        Integer VET_ID = 1;
        LocalDate VISIT_DATE = LocalDate.now();
        String DESCRIPTION = "General check";
        Double COST = 50.0;

        VisitDTO visitDTO = VisitDTO.builder()
                .petId(PET_ID)
                .vetId(VET_ID)
                .visitDate(VISIT_DATE)
                .description(DESCRIPTION)
                .cost(COST)
                .build();

        VisitDTO newVisitDTO = visitService.create(visitDTO);

        log.info("VISIT CREATED : " + newVisitDTO);

        assertNotNull(newVisitDTO.getId());
        assertEquals(DESCRIPTION, newVisitDTO.getDescription());

    }

    /**
     * UPDATE VISIT
     */
    @Test
    public void testUpdateVisit() {

        Integer PET_ID = 1;
        Integer VET_ID = 1;

        VisitDTO visitDTO = VisitDTO.builder()
                .petId(PET_ID)
                .vetId(VET_ID)
                .visitDate(LocalDate.now())
                .description("Old Description")
                .cost(70.0)
                .build();

        // ------------ Create ---------------

        VisitDTO createdVisit = visitService.create(visitDTO);

        // ------------ Update ---------------

        createdVisit.setDescription("Updated Description");
        createdVisit.setCost(120.0);

        VisitDTO updatedVisit = visitService.update(createdVisit);

        log.info("UPDATED VISIT : " + updatedVisit);

        assertEquals("Updated Description", updatedVisit.getDescription());
        assertEquals(120.0, updatedVisit.getCost());

    }

    /**
     * DELETE VISIT
     */
    @Test
    public void testDeleteVisit() {

        VisitDTO visitDTO = VisitDTO.builder()
                .petId(1)
                .vetId(1)
                .visitDate(LocalDate.now())
                .description("Delete Visit")
                .cost(80.0)
                .build();

        // ------------ Create ---------------

        VisitDTO createdVisit = visitService.create(visitDTO);

        // ------------ Delete ---------------

        try {

            visitService.delete(createdVisit.getId());

        } catch (VisitNotFoundException e) {

            fail(e.getMessage());

        }

        // ------------ Validation ---------------

        try {

            visitService.findById(createdVisit.getId());

            assertTrue(false);

        } catch (VisitNotFoundException e) {

            assertTrue(true);

        }

    }

}