package com.tecsup.petclinic.mappers;

import com.tecsup.petclinic.dtos.VetDTO;
import com.tecsup.petclinic.entities.Vet;
import org.springframework.stereotype.Component;

@Component
public class VetMapper {

    public Vet mapToEntity(VetDTO dto) {
        if (dto == null) return null;

        Vet vet = new Vet();
        vet.setId(dto.getId());
        vet.setFirstName(dto.getFirstName());
        vet.setLastName(dto.getLastName());
        vet.setEmail(dto.getEmail());
        vet.setPhone(dto.getPhone());
        vet.setActive(dto.isActive());
        return vet;
    }

    public VetDTO mapToDto(Vet entity) {
        if (entity == null) return null;

        return new VetDTO(
                entity.getId(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getEmail(),
                entity.getPhone(),
                entity.isActive()
        );
    }
}