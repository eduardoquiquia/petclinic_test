package com.tecsup.petclinic.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecsup.petclinic.dtos.VisitDTO;
import com.tecsup.petclinic.entities.Visit;
import com.tecsup.petclinic.exceptions.VisitNotFoundException;
import com.tecsup.petclinic.mappers.VisitMapper;
import com.tecsup.petclinic.repositories.VisitRepository;

@Service
public class VisitServiceImpl implements VisitService {

    @Autowired
    private VisitRepository visitRepository;

    @Override
    public VisitDTO findById(Integer id) throws VisitNotFoundException {

        Optional<Visit> visit = visitRepository.findById(id);

        if (visit.isPresent()) {
            return VisitMapper.toDTO(visit.get());
        }

        throw new VisitNotFoundException("Visit not found");
    }

    @Override
    public List<VisitDTO> findByPetId(Integer petId) {

        List<Visit> visits = visitRepository.findByPetId(petId);

        return visits.stream()
                .map(VisitMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public VisitDTO create(VisitDTO visitDTO) {

        Visit visit = VisitMapper.toEntity(visitDTO);

        visit = visitRepository.save(visit);

        return VisitMapper.toDTO(visit);
    }

    @Override
    public VisitDTO update(VisitDTO visitDTO) {

        Visit visit = VisitMapper.toEntity(visitDTO);

        visit = visitRepository.save(visit);

        return VisitMapper.toDTO(visit);
    }

    @Override
    public void delete(Integer id) throws VisitNotFoundException {

        Optional<Visit> visit = visitRepository.findById(id);

        if (visit.isPresent()) {

            visitRepository.delete(visit.get());

        } else {

            throw new VisitNotFoundException("Visit not found");

        }

    }

}