package com.tecsup.petclinic.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.tecsup.petclinic.dtos.VetDTO;
import com.tecsup.petclinic.mappers.VetMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.tecsup.petclinic.entities.Vet;
import com.tecsup.petclinic.exceptions.VetNotFoundException;
import com.tecsup.petclinic.repositories.VetRepository;

@Service
@Slf4j
public class VetServiceImpl implements VetService {

    private final VetRepository vetRepository;
    private final VetMapper vetMapper;

    // Inyección por constructor (Forma recomendada de Spring)
    public VetServiceImpl(VetRepository vetRepository, VetMapper vetMapper) {
        this.vetRepository = vetRepository;
        this.vetMapper = vetMapper;
    }

    @Override
    public VetDTO create(VetDTO vetDTO) {
        log.info("Creando un nuevo veterinario: {}", vetDTO);
        Vet vet = vetMapper.mapToEntity(vetDTO);
        Vet savedVet = vetRepository.save(vet);
        return vetMapper.mapToDto(savedVet);
    }

    @Override
    public VetDTO update(VetDTO vetDTO) {
        log.info("Actualizando veterinario con ID: {}", vetDTO.getId());

        // Verificamos primero si existe antes de actualizar
        if (!vetRepository.existsById(vetDTO.getId())) {
            throw new VetNotFoundException("No se puede actualizar. Veterinario no encontrado con ID: " + vetDTO.getId());
        }

        Vet vet = vetMapper.mapToEntity(vetDTO);
        Vet updatedVet = vetRepository.save(vet);
        return vetMapper.mapToDto(updatedVet);
    }

    @Override
    public void delete(Integer id) throws VetNotFoundException {
        log.info("Eliminando veterinario con ID: {}", id);
        Vet vet = vetRepository.findById(id)
                .orElseThrow(() -> new VetNotFoundException("No se pudo eliminar. Veterinario no encontrado con ID: " + id));

        vetRepository.delete(vet);
    }

    @Override
    public VetDTO findById(Integer id) throws VetNotFoundException {
        log.info("Buscando veterinario por ID: {}", id);
        return vetRepository.findById(id)
                .map(vetMapper::mapToDto)
                .orElseThrow(() -> new VetNotFoundException("Veterinario no encontrado con ID: " + id));
    }

    @Override
    public List<VetDTO> findByFirstName(String firstName) {
        log.info("Buscando veterinarios por nombre: {}", firstName);
        // Nota: Asegúrate de tener este método definido en tu VetRepository
        return vetRepository.findByFirstName(firstName).stream()
                .map(vetMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<VetDTO> findAll() {
        log.info("Listando todos los veterinarios");
        return vetRepository.findAll().stream()
                .map(vetMapper::mapToDto)
                .collect(Collectors.toList());
    }
}