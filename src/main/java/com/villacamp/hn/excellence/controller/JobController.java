package com.villacamp.hn.excellence.controller;

import com.villacamp.hn.excellence.dto.JobDTO;
import com.villacamp.hn.excellence.dto.JobRequestDTO;
import com.villacamp.hn.excellence.dto.JobUpdateDTO;
import com.villacamp.hn.excellence.dto.UpsertDTO;
import com.villacamp.hn.excellence.entity.User;
import com.villacamp.hn.excellence.service.JobService;
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
@RequestMapping(path = "v1/job")
@RequiredArgsConstructor
@SecurityRequirements({@SecurityRequirement(name = "api-key"), @SecurityRequirement(name = "Authorization")})
public class JobController {
    private final JobService jobService;

    @GetMapping
    @Operation(summary = "Get current jobs")
    @PreAuthorize("hasRole('CLI, ADM')")
    public ResponseEntity<List<JobDTO>> allJobs() {
        return ResponseEntity.ok(jobService.findJobs());
    }

    @PostMapping
    @Operation(summary = "Insert new job")
    @PreAuthorize("hasRole('ADM')")
    public ResponseEntity<UpsertDTO> insertJob(Authentication authentication, @Valid @RequestBody JobRequestDTO request) {
        return ResponseEntity.ok(jobService.insertJob((User) authentication.getPrincipal(), request));
    }

    @PutMapping
    @Operation(summary = "Update a job")
    @PreAuthorize("hasRole('ADM')")
    public ResponseEntity<UpsertDTO> updateJob(Authentication authentication, @Valid @RequestBody JobUpdateDTO request) {
        return ResponseEntity.ok(jobService.updateJob((User) authentication.getPrincipal(), request));
    }

    @DeleteMapping
    @Operation(summary = "Delete a job")
    @PreAuthorize("hasRole('ADM')")
    public ResponseEntity<Boolean> deleteJob(@RequestParam long id) {
        return ResponseEntity.ok(jobService.deleteJob(id));
    }
}
