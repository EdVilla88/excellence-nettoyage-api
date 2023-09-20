package com.villacamp.hn.excellence.converter;

import com.villacamp.hn.excellence.dto.AddressDTO;
import com.villacamp.hn.excellence.entity.Address;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@NoArgsConstructor
public final class AddressConverter {
    public static AddressDTO convert(Address entity) {
        return new ModelMapper().map(entity, AddressDTO.class);
    }

    public static Address convert(AddressDTO dto) {
        return new ModelMapper().map(dto, Address.class);
    }
}
