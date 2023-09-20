package com.villacamp.hn.excellence.service;

import com.villacamp.hn.excellence.dto.AddressDTO;
import com.villacamp.hn.excellence.dto.AddressRequestDTO;
import com.villacamp.hn.excellence.dto.AddressUpdateDTO;
import com.villacamp.hn.excellence.dto.UpsertDTO;
import com.villacamp.hn.excellence.entity.User;

import java.util.List;

public interface AddressService {

    List<AddressDTO> findAll(User user);

    UpsertDTO insertAddress(User user, AddressRequestDTO request);

    UpsertDTO updateAddress(User user, AddressUpdateDTO request);

    boolean deleteAddress(User user, long id);
}
