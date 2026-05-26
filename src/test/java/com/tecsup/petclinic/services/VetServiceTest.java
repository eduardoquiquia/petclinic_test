package com.tecsup.petclinic.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import com.tecsup.petclinic.dtos.VetDTO;
import org.junit.jupiter.api.Test;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tecsup.petclinic.exceptions.VetNotFoundException;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class VetServiceTest {

    @Autowired
    private VetService vetService;

    @Test
    public void testFindVetById() {
        final String FIRST_NAME_EXPECTED = "James"; // Cambia por un valor real de tu import.sql si es necesario
        Integer ID = 1;
        VetDTO vet = null;

        try {
            vet = this.vetService.findById(ID);
        } catch (VetNotFoundException e) {
            fail(e.getMessage());
        }

        assertEquals(FIRST_NAME_EXPECTED, vet.getFirstName());
    }

    @Test
    public void testFindVetByFirstName() {
        String FIND_NAME = "James";
        int SIZE_EXPECTED = 1;

        List<VetDTO> vets = this.vetService.findByFirstName(FIND_NAME);

        assertEquals(SIZE_EXPECTED, vets.size());
    }

    @Test
    public void testCreateVet() {
        String FIRST_NAME = "William";
        String LAST_NAME = "Carter";
        String EMAIL = "william.carter@gmail.com";
        String PHONE = "555123456";

        VetDTO vetDTO = VetDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .email(EMAIL)
                .phone(PHONE)
                .active(true)
                .build();

        VetDTO newVetDTO = this.vetService.create(vetDTO);
        log.info("VET CREATED :" + newVetDTO.toString());

        assertNotNull(newVetDTO.getId());
        assertEquals(FIRST_NAME, newVetDTO.getFirstName());
        assertEquals(LAST_NAME, newVetDTO.getLastName());
        assertEquals(EMAIL, newVetDTO.getEmail());
    }

    @Test
    public void testUpdateVet() {
        String FIRST_NAME = "Helen";
        String LAST_NAME = "Leary";

        String UP_FIRST_NAME = "Helen2";
        String UP_LAST_NAME = "Leary2";

        VetDTO vetDTO = VetDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .active(true)
                .build();

        // ------------ Create ---------------
        log.info(">" + vetDTO);
        VetDTO vetDTOCreated = this.vetService.create(vetDTO);
        log.info(">>" + vetDTOCreated);

        // ------------ Update ---------------
        vetDTOCreated.setFirstName(UP_FIRST_NAME);
        vetDTOCreated.setLastName(UP_LAST_NAME);

        VetDTO upgradeVetDTO = null;
        try {
            upgradeVetDTO = this.vetService.update(vetDTOCreated);
        } catch (VetNotFoundException e) {
            fail(e.getMessage());
        }

        assertEquals(UP_FIRST_NAME, upgradeVetDTO.getFirstName());
        assertEquals(UP_LAST_NAME, upgradeVetDTO.getLastName());
    }

    @Test
    public void testDeleteVet() {
        String FIRST_NAME = "Rafael";
        String LAST_NAME = "Ortega";

        // ------------ Create ---------------
        VetDTO vetDTO = VetDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .active(true)
                .build();

        VetDTO newVetDTO = this.vetService.create(vetDTO);
        log.info("" + vetDTO);

        // ------------ Delete ---------------
        try {
            this.vetService.delete(newVetDTO.getId());
        } catch (VetNotFoundException e) {
            fail(e.getMessage());
        }

        // ------------ Validation ---------------
        try {
            this.vetService.findById(newVetDTO.getId());
            fail("El veterinario debería haber sido eliminado");
        } catch (VetNotFoundException e) {
            assertTrue(true);
        }
    }
}