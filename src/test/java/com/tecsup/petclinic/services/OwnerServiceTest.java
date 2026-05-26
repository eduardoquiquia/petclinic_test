package com.tecsup.petclinic.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tecsup.petclinic.dtos.OwnerDTO;
import com.tecsup.petclinic.exceptions.OwnerNotFoundException;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class OwnerServiceTest {

    @Autowired
    private OwnerService ownerService;

    /**
     * FIND OWNER BY ID
     */
    @Test
    public void testFindOwnerById() {

        Integer ID = 1;
        String FIRST_NAME_EXPECTED = "George";

        OwnerDTO owner = null;

        try {

            owner = ownerService.findById(ID);

        } catch (OwnerNotFoundException e) {

            fail(e.getMessage());

        }

        log.info("" + owner);

        assertEquals(FIRST_NAME_EXPECTED, owner.getFirstName());

    }

    /**
     * FIND OWNER BY LAST NAME
     */
    @Test
    public void testFindOwnerByLastName() {

        String LAST_NAME = "Davis";

        List<OwnerDTO> owners = ownerService.findByLastName(LAST_NAME);

        assertTrue(owners.size() > 0);

    }

    /**
     * CREATE OWNER
     */
    @Test
    public void testCreateOwner() {

        String FIRST_NAME = "Juan";
        String LAST_NAME = "Perez";
        String ADDRESS = "Lima";
        String CITY = "Lima";
        String TELEPHONE = "999999999";

        OwnerDTO ownerDTO = OwnerDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .address(ADDRESS)
                .city(CITY)
                .telephone(TELEPHONE)
                .build();

        OwnerDTO newOwnerDTO = ownerService.create(ownerDTO);

        log.info("OWNER CREATED : " + newOwnerDTO);

        assertNotNull(newOwnerDTO.getId());
        assertEquals(FIRST_NAME, newOwnerDTO.getFirstName());
        assertEquals(LAST_NAME, newOwnerDTO.getLastName());

    }

    /**
     * UPDATE OWNER
     */
    @Test
    public void testUpdateOwner() {

        String FIRST_NAME = "Mario";
        String LAST_NAME = "Soto";
        String ADDRESS = "Tacna";
        String CITY = "Tacna";
        String TELEPHONE = "966666666";

        OwnerDTO ownerDTO = OwnerDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .address(ADDRESS)
                .city(CITY)
                .telephone(TELEPHONE)
                .build();

        // ------------ Create ---------------

        OwnerDTO createdOwner = ownerService.create(ownerDTO);

        // ------------ Update ---------------

        createdOwner.setFirstName("Mario Updated");
        createdOwner.setCity("Lima");

        OwnerDTO updatedOwner = ownerService.update(createdOwner);

        log.info("UPDATED OWNER : " + updatedOwner);

        assertEquals("Mario Updated", updatedOwner.getFirstName());
        assertEquals("Lima", updatedOwner.getCity());

    }

    /**
     * DELETE OWNER
     */
    @Test
    public void testDeleteOwner() {

        String FIRST_NAME = "Delete";
        String LAST_NAME = "Test";
        String ADDRESS = "Piura";
        String CITY = "Piura";
        String TELEPHONE = "955555555";

        OwnerDTO ownerDTO = OwnerDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .address(ADDRESS)
                .city(CITY)
                .telephone(TELEPHONE)
                .build();

        // ------------ Create ---------------

        OwnerDTO createdOwner = ownerService.create(ownerDTO);

        // ------------ Delete ---------------

        try {

            ownerService.delete(createdOwner.getId());

        } catch (OwnerNotFoundException e) {

            fail(e.getMessage());

        }

        // ------------ Validation ---------------

        try {

            ownerService.findById(createdOwner.getId());

            assertTrue(false);

        } catch (OwnerNotFoundException e) {

            assertTrue(true);

        }

    }

}