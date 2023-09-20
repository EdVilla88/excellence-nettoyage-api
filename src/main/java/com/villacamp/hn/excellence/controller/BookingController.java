package com.villacamp.hn.excellence.controller;

import com.villacamp.hn.excellence.dto.BookingDTO;
import com.villacamp.hn.excellence.dto.BookingRequestDTO;
import com.villacamp.hn.excellence.dto.BookingUpdateDTO;
import com.villacamp.hn.excellence.dto.UpsertDTO;
import com.villacamp.hn.excellence.entity.User;
import com.villacamp.hn.excellence.service.BookingService;
import com.villacamp.hn.excellence.utils.enums.BookingStatus;
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
@RequestMapping("v1/booking")
@RequiredArgsConstructor
@SecurityRequirements({@SecurityRequirement(name = "api-key"), @SecurityRequirement(name = "Authorization")})
public class BookingController {

    private final BookingService service;

    @GetMapping
    @Operation(summary = "Get current bookings")
    @PreAuthorize("hasRole('CLI')")
    public ResponseEntity<List<BookingDTO>> allBookings(Authentication authentication) {
        return ResponseEntity.ok(service.findAll((User) authentication.getPrincipal()));
    }

    @PostMapping
    @Operation(summary = "Insert new booking")
    @PreAuthorize("hasRole('CLI')")
    public ResponseEntity<UpsertDTO> insertBooking(Authentication authentication, @Valid @RequestBody BookingRequestDTO request) {
        return ResponseEntity.ok(service.insertBooking((User) authentication.getPrincipal(), request));
    }

    @PutMapping
    @Operation(summary = "Update a booking")
    @PreAuthorize("hasRole('CLI')")
    public ResponseEntity<UpsertDTO> updateBooking(Authentication authentication, @Valid @RequestBody BookingUpdateDTO request) {
        return ResponseEntity.ok(service.updateBooking((User) authentication.getPrincipal(), request));
    }

    @DeleteMapping
    @Operation(summary = "Delete a booking")
    @PreAuthorize("hasRole('CLI')")
    public ResponseEntity<Boolean> deleteBooking(Authentication authentication, @RequestParam long id) {
        return ResponseEntity.ok(service.deleteBooking((User) authentication.getPrincipal(), id));
    }

    @PutMapping("/status")
    @Operation(summary = "Update a booking's status")
    @PreAuthorize("hasRole('CLI')")
    public ResponseEntity<Boolean> updateBookingStatus(Authentication authentication, @RequestParam long id, @RequestParam BookingStatus status) {
        return ResponseEntity.ok(service.updateStatus((User) authentication.getPrincipal(), id, status));
    }
}
