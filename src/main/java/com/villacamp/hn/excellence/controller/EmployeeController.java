package com.villacamp.hn.excellence.controller;

import com.villacamp.hn.excellence.dto.EmployeeDTO;
import com.villacamp.hn.excellence.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "v1/employee")
@RequiredArgsConstructor
@SecurityRequirements({@SecurityRequirement(name = "api-key"), @SecurityRequirement(name = "Authorization")})
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    @Operation(summary = "Get all employees")
    public ResponseEntity<List<EmployeeDTO>> allEmp() {
        return ResponseEntity.ok(employeeService.findAllEmployees());
    }

}
