package com.villacamp.hn.excellence.controller;

import com.villacamp.hn.excellence.dto.AddressDTO;
import com.villacamp.hn.excellence.dto.AddressRequestDTO;
import com.villacamp.hn.excellence.dto.AddressUpdateDTO;
import com.villacamp.hn.excellence.dto.UpsertDTO;
import com.villacamp.hn.excellence.entity.User;
import com.villacamp.hn.excellence.service.AddressService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/address")
@RequiredArgsConstructor
@SecurityRequirements({@SecurityRequirement(name = "api-key"), @SecurityRequirement(name = "Authorization")})
public class AddressController {

    private final AddressService service;

    @GetMapping
    @Operation(summary = "Get current addresses")
    @PreAuthorize("hasRole('CLI')")
    public ResponseEntity<List<AddressDTO>> allAddresses(Authentication authentication) {
        return ResponseEntity.ok(service.findAll((User) authentication.getPrincipal()));
    }

    @PostMapping
    @Operation(summary = "Insert new address")
    @PreAuthorize("hasRole('CLI')")
    public ResponseEntity<UpsertDTO> insertAddress(Authentication authentication, @Valid @RequestBody AddressRequestDTO request) {
        return ResponseEntity.ok(service.insertAddress((User) authentication.getPrincipal(), request));
    }

    @PutMapping
    @Operation(summary = "Update a address")
    @PreAuthorize("hasRole('CLI')")
    public ResponseEntity<UpsertDTO> updateAddress(Authentication authentication, @Valid @RequestBody AddressUpdateDTO request) {
        return ResponseEntity.ok(service.updateAddress((User) authentication.getPrincipal(), request));
    }

    @DeleteMapping
    @Operation(summary = "Delete a address")
    @PreAuthorize("hasRole('CLI')")
    public ResponseEntity<Boolean> deleteAddress(Authentication authentication, @RequestParam long id) {
        return ResponseEntity.ok(service.deleteAddress((User) authentication.getPrincipal(), id));
    }
}
