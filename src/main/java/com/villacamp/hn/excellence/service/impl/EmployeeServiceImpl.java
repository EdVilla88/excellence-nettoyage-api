package com.villacamp.hn.excellence.service.impl;

import com.villacamp.hn.excellence.converter.UserConverter;
import com.villacamp.hn.excellence.dto.EmployeeDTO;
import com.villacamp.hn.excellence.entity.User;
import com.villacamp.hn.excellence.exception.NotFoundException;
import com.villacamp.hn.excellence.repository.UserRepository;
import com.villacamp.hn.excellence.service.EmployeeService;
import com.villacamp.hn.excellence.utils.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final UserRepository userRepository;

    @Override
    public User findEmployeeById(long id) {
        var result = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Invalid employee id."));
        if (result.getRole().equals(Role.EMP))
            return result;
        else
            throw new NotFoundException("User is not an employee.");
    }

    @Override
    public List<EmployeeDTO> findAllEmployees() {
        return userRepository.findAll()
                .stream()
                .filter(u -> u.getRole().equals(Role.EMP))
                .toList()
                .stream()
                .map(UserConverter::convert)
                .collect(Collectors.toList());
    }
}
