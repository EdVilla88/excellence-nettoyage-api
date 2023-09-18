package com.villacamp.hn.excellence.service.impl;

import com.villacamp.hn.excellence.converter.JobConverter;
import com.villacamp.hn.excellence.dto.JobRequestDTO;
import com.villacamp.hn.excellence.dto.JobResponseDTO;
import com.villacamp.hn.excellence.dto.JobUpdateDTO;
import com.villacamp.hn.excellence.dto.UpsertDTO;
import com.villacamp.hn.excellence.entity.User;
import com.villacamp.hn.excellence.exception.NotFoundException;
import com.villacamp.hn.excellence.repository.JobRepository;
import com.villacamp.hn.excellence.service.JobService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepository repository;

    @Override
    public List<JobResponseDTO> findJobs(User user) {
        return repository.findAllByUser(user)
                .orElseThrow(() -> new NotFoundException("Empty jobs"))
                .stream()
                .map(JobConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public UpsertDTO insertJob(User user, JobRequestDTO request) {
        var entity = JobConverter.convert(request);
        entity.setUser(user);
        entity.setId(repository.save(entity).getId());
        return UpsertDTO.builder()
                .success(entity.getId() > 0)
                .data(entity.getId())
                .build();
    }

    @Override
    public UpsertDTO updateJob(User user, JobUpdateDTO update) {
        var entity = JobConverter.convert(
                findJobs(user)
                        .stream()
                        .filter(dto -> dto.getId() == update.getId())
                        .findAny()
                        .orElseThrow(() -> new NotFoundException("Invalid job id.")));
        entity.setPrice(update.getPrice());
        entity.setDescription(update.getDescription());
        entity.setTitle(update.getTitle());
        entity.setUpdated(LocalDateTime.now());
        entity.setUser(user);

        return UpsertDTO.builder()
                .success(true)
                .data(repository.save(entity).getId())
                .build();
    }

    @Override
    public boolean deleteJob(User user, int id) {
        var jobs = findJobs(user).stream()
                .filter(job -> job.getId() == id)
                .findAny()
                .orElseThrow(() -> new NotFoundException("Invalid job id"));
        repository.delete(JobConverter.convert(jobs));
        return true;
    }
}
