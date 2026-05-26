package com.tecsup.petclinic.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.tecsup.petclinic.dtos.VetDTO;
import com.tecsup.petclinic.mappers.VetMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.tecsup.petclinic.entities.Vet;
import com.tecsup.petclinic.exceptions.VetNotFoundException;
import com.tecsup.petclinic.repositories.VetRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@Slf4j
@SpringBootTest
public class VetServiceMockitoTest {

    @Autowired
    private VetService vetService;

    @Autowired
    private VetMapper vetMapper;

    @MockitoBean
    private VetRepository repository;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void testFindVetById() {
        Vet vetExpected = new Vet(1, "James", "Carter", "james.carter@gmail.com", "5551234", true);

        Mockito.when(this.repository.findById(1))
                .thenReturn(Optional.of(vetExpected));

        VetDTO vet = null;
        try {
            vet = this.vetService.findById(1);
        } catch (VetNotFoundException e) {
            fail(e.getMessage());
        }

        log.info("Expected: " + vetExpected);
        log.info("Actual: " + vet);
        assertEquals(vetExpected.getFirstName(), vet.getFirstName());
    }

    @Test
    public void testFindVetByFirstName() {
        String FIND_NAME = "James";

        List<Vet> vetsExpected = new ArrayList<>();
        vetsExpected.add(new Vet(1, "James", "Carter", "james.carter@gmail.com", "5551234", true));

        Mockito.when(this.repository.findByFirstName(FIND_NAME))
                .thenReturn(vetsExpected);

        List<VetDTO> vets = this.vetService.findByFirstName(FIND_NAME);

        assertEquals(vetsExpected.size(), vets.size());
    }

    @Test
    public void testCreateVet() {
        Vet newVet = new Vet(null, "William", "Leary", "william@gmail.com", "5556789", true);
        Vet newVetCreated = new Vet(1, "William", "Leary", "william@gmail.com", "5556789", true);

        VetDTO newVetDTO = this.vetMapper.mapToDto(newVet);
        VetDTO hopeVetDTOCreated = this.vetMapper.mapToDto(newVetCreated);

        Mockito.when(this.repository.save(newVet))
                .thenReturn(newVetCreated);

        VetDTO newVetDTOCreated = this.vetService.create(newVetDTO);

        log.info("Vet created : {}", newVetDTOCreated);

        assertNotNull(newVetDTOCreated.getId());
        assertEquals(hopeVetDTOCreated.getFirstName(), newVetDTOCreated.getFirstName());
        assertEquals(hopeVetDTOCreated.getLastName(), newVetDTOCreated.getLastName());
        assertEquals(hopeVetDTOCreated.getEmail(), newVetDTOCreated.getEmail());
    }

    @Test
    public void testUpdateVet() {
        String UP_FIRST_NAME = "Helen2";
        String UP_LAST_NAME = "Leary2";

        Vet newVet = new Vet(null, "Helen", "Leary", "helen@gmail.com", "5550000", true);
        Vet newVetCreate = new Vet(1, "Helen", "Leary", "helen@gmail.com", "5550000", true);

        VetDTO newVetDTO = vetMapper.mapToDto(newVet);

        // ------------ Create ---------------
        Mockito.when(this.repository.save(newVet))
                .thenReturn(newVetCreate);

        VetDTO newVetDTOCreate = this.vetService.create(newVetDTO);
        log.info("{}", newVetDTOCreate);

        // ------------ Update ---------------
        newVetDTOCreate.setFirstName(UP_FIRST_NAME);
        newVetDTOCreate.setLastName(UP_LAST_NAME);

        VetDTO newVetDTOUpdate = newVetDTOCreate;
        Vet newVetUpdate = this.vetMapper.mapToEntity(newVetDTOUpdate);

        Mockito.when(this.repository.existsById(newVetDTOCreate.getId()))
                .thenReturn(true);
        Mockito.when(this.repository.save(newVetUpdate))
                .thenReturn(newVetUpdate);

        VetDTO vetDTOUpdate = null;
        try {
            vetDTOUpdate = this.vetService.update(newVetDTOCreate);
        } catch (VetNotFoundException e) {
            fail("No debería lanzar excepción en un flujo correcto: " + e.getMessage());
        }

        assertEquals(UP_FIRST_NAME, vetDTOUpdate.getFirstName());
        assertEquals(UP_LAST_NAME, vetDTOUpdate.getLastName());
    }

    @Test
    public void testDeleteVet() {
        Vet newVet = new Vet(null, "Rafael", "Ortega", "rafael@gmail.com", "5551111", true);
        Vet newVetCreate = new Vet(1, "Rafael", "Ortega", "rafael@gmail.com", "5551111", true);

        VetDTO newVetDTO = this.vetMapper.mapToDto(newVet);

        // ------------ Create ---------------
        Mockito.when(this.repository.save(newVet))
                .thenReturn(newVetCreate);

        VetDTO vetDTOCreate = this.vetService.create(newVetDTO);
        log.info("{}", vetDTOCreate);

        // ------------ Delete ---------------
        Mockito.doNothing().when(this.repository).delete(newVetCreate);
        Mockito.when(this.repository.findById(newVetCreate.getId()))
                .thenReturn(Optional.of(newVetCreate));

        try {
            this.vetService.delete(vetDTOCreate.getId());
        } catch (VetNotFoundException e) {
            fail(e.getMessage());
        }

        // ------------ Validate ---------------
        Mockito.when(this.repository.findById(newVetCreate.getId()))
                .thenReturn(Optional.ofNullable(null));

        try {
            this.vetService.findById(vetDTOCreate.getId());
            fail("Debería lanzar VetNotFoundException");
        } catch (VetNotFoundException e) {
            assertTrue(true);
        }
    }
}