package com.tecsup.petclinic.services;

import java.util.List;

import com.tecsup.petclinic.dtos.VisitDTO;
import com.tecsup.petclinic.exceptions.VisitNotFoundException;

public interface VisitService {

    VisitDTO findById(Integer id) throws VisitNotFoundException;

    List<VisitDTO> findByPetId(Integer petId);

    VisitDTO create(VisitDTO visitDTO);

    VisitDTO update(VisitDTO visitDTO);

    void delete(Integer id) throws VisitNotFoundException;

}