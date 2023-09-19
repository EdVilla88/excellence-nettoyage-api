package com.villacamp.hn.excellence.service.impl;

import com.villacamp.hn.excellence.converter.JobConverter;
import com.villacamp.hn.excellence.converter.UserConverter;
import com.villacamp.hn.excellence.dto.JobDTO;
import com.villacamp.hn.excellence.dto.JobRequestDTO;
import com.villacamp.hn.excellence.dto.JobUpdateDTO;
import com.villacamp.hn.excellence.dto.UpsertDTO;
import com.villacamp.hn.excellence.entity.Job;
import com.villacamp.hn.excellence.entity.User;
import com.villacamp.hn.excellence.exception.NotFoundException;
import com.villacamp.hn.excellence.repository.JobRepository;
import com.villacamp.hn.excellence.service.EmployeeService;
import com.villacamp.hn.excellence.service.JobService;
import com.villacamp.hn.excellence.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepository repository;
    private final EmployeeService employeeService;
    private final ReviewService reviewService;

    @Override
    public List<JobDTO> findJobs() {
        var entities = repository.findAll();
        return entities.stream().map(j -> {
            var dto = JobConverter.convert(j);
            dto.setEmployee(UserConverter.convert(j.getEmployee()));
            dto.setReviews(reviewService.findReviewsByJob(j.getId()));
            return dto;
        }).toList();
    }

    public Job findJob(long id) {
        return repository.findById(id).orElseThrow(() ->
                new NotFoundException("Invalid job id."));
    }

    @Override
    public UpsertDTO insertJob(User user, JobRequestDTO request) {
        var entity = JobConverter.convert(request);
        entity.setEmployee(employeeService.findEmployeeById(request.getUserId()));
        entity.setId(repository.save(entity).getId());
        entity.setCreatedBy(user.getEmail());
        return UpsertDTO.builder()
                .success(entity.getId() > 0)
                .data(entity.getId())
                .build();
    }

    @Override
    public UpsertDTO updateJob(User user, JobUpdateDTO update) {
        var entity = findJob(update.getId());
        entity.setPrice(update.getPrice());
        entity.setDescription(update.getDescription());
        entity.setTitle(update.getTitle());
        entity.setUpdated(LocalDateTime.now());
        entity.setUpdatedBy(user.getEmail());
        entity.setEmployee(employeeService.findEmployeeById(update.getUserId()));

        return UpsertDTO.builder()
                .success(true)
                .data(repository.save(entity).getId())
                .build();
    }

    @Override
    public boolean deleteJob(User user, long id) {
        repository.delete(findJob(id));
        return true;
    }
}
