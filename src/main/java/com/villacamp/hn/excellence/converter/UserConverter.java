package com.villacamp.hn.excellence.converter;

import com.villacamp.hn.excellence.dto.EmployeeDTO;
import com.villacamp.hn.excellence.entity.User;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@NoArgsConstructor
public final class UserConverter {

    public static EmployeeDTO convert(User entity) {
        return new ModelMapper().map(entity, EmployeeDTO.class);
    }
}
