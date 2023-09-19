package com.villacamp.hn.excellence.service;

import com.villacamp.hn.excellence.dto.EmployeeDTO;
import com.villacamp.hn.excellence.entity.User;

import java.util.List;

public interface EmployeeService {

    User findEmployeeById(long id);

    List<EmployeeDTO> findAllEmployees();
}
