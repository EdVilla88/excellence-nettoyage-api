package com.villacamp.hn.excellence.service.impl;

import com.villacamp.hn.excellence.converter.AddressConverter;
import com.villacamp.hn.excellence.dto.AddressDTO;
import com.villacamp.hn.excellence.dto.AddressRequestDTO;
import com.villacamp.hn.excellence.dto.AddressUpdateDTO;
import com.villacamp.hn.excellence.dto.UpsertDTO;
import com.villacamp.hn.excellence.entity.Address;
import com.villacamp.hn.excellence.entity.User;
import com.villacamp.hn.excellence.exception.NotFoundException;
import com.villacamp.hn.excellence.repository.AddressRepository;
import com.villacamp.hn.excellence.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository repository;

    @Override
    public List<AddressDTO> findAll(User user) {
        return repository.findAllByUser(user)
                .orElseThrow(() -> new NotFoundException("No addresses for this user."))
                .stream()
                .map(AddressConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public UpsertDTO insertAddress(User user, AddressRequestDTO request) {
        var entity = repository.save(
                Address.builder()
                        .address(request.getAddress())
                        .name(request.getName())
                        .description(request.getDescription())
                        .user(user)
                        .build());
        return UpsertDTO.builder()
                .success(entity.getId() > 0)
                .data(entity.getId())
                .build();
    }

    @Override
    public UpsertDTO updateAddress(User user, AddressUpdateDTO request) {
        var entity = repository.findById(request.getId())
                .orElseThrow(() -> new NotFoundException("Invalid address id"));

        if (!Objects.equals(entity.getUser().getId(), user.getId()))
            return UpsertDTO.builder()
                    .success(false)
                    .msg("Address not found for current user.")
                    .build();
        entity.setDescription(request.getDescription());
        entity.setName(request.getName());
        entity.setAddress(request.getAddress());
        return UpsertDTO.builder()
                .success(true)
                .data(repository.save(entity).getId())
                .build();
    }

    @Override
    public boolean deleteAddress(User user, long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Invalid address id."));

        if (!Objects.equals(entity.getUser().getId(), user.getId()))
            return false;
        repository.delete(entity);
        return true;
    }
}
