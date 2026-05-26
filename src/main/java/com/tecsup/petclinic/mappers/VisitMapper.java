package com.tecsup.petclinic.mappers;

import com.tecsup.petclinic.dtos.VisitDTO;
import com.tecsup.petclinic.entities.Visit;

public class VisitMapper {

    public static VisitDTO toDTO(Visit visit) {

        return VisitDTO.builder()
                .id(visit.getId())
                .petId(visit.getPetId())
                .vetId(visit.getVetId())
                .visitDate(visit.getVisitDate())
                .description(visit.getDescription())
                .cost(visit.getCost())
                .build();
    }

    public static Visit toEntity(VisitDTO visitDTO) {

        Visit visit = new Visit();

        visit.setId(visitDTO.getId());
        visit.setPetId(visitDTO.getPetId());
        visit.setVetId(visitDTO.getVetId());
        visit.setVisitDate(visitDTO.getVisitDate());
        visit.setDescription(visitDTO.getDescription());
        visit.setCost(visitDTO.getCost());

        return visit;
    }

}