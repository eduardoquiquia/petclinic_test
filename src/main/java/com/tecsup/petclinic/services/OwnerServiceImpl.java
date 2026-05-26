package com.tecsup.petclinic.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecsup.petclinic.dtos.OwnerDTO;
import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exceptions.OwnerNotFoundException;
import com.tecsup.petclinic.mappers.OwnerMapper;
import com.tecsup.petclinic.repositories.OwnerRepository;

@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public OwnerDTO findById(Integer id) throws OwnerNotFoundException {

        Optional<Owner> owner = ownerRepository.findById(id);

        if (owner.isPresent()) {
            return OwnerMapper.toDTO(owner.get());
        }

        throw new OwnerNotFoundException("Owner not found");
    }

    @Override
    public List<OwnerDTO> findByLastName(String lastName) {

        List<Owner> owners = ownerRepository.findByLastName(lastName);

        return owners.stream()
                .map(OwnerMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OwnerDTO create(OwnerDTO ownerDTO) {

        Owner owner = OwnerMapper.toEntity(ownerDTO);

        owner = ownerRepository.save(owner);

        return OwnerMapper.toDTO(owner);
    }

    @Override
    public OwnerDTO update(OwnerDTO ownerDTO) {

        Owner owner = OwnerMapper.toEntity(ownerDTO);

        owner = ownerRepository.save(owner);

        return OwnerMapper.toDTO(owner);
    }

    @Override
    public void delete(Integer id) throws OwnerNotFoundException {

        Optional<Owner> owner = ownerRepository.findById(id);

        if (owner.isPresent()) {
            ownerRepository.delete(owner.get());
        } else {
            throw new OwnerNotFoundException("Owner not found");
        }

    }

}