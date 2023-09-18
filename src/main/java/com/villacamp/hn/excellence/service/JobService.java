package com.villacamp.hn.excellence.service;

import com.villacamp.hn.excellence.dto.JobRequestDTO;
import com.villacamp.hn.excellence.dto.JobResponseDTO;
import com.villacamp.hn.excellence.dto.JobUpdateDTO;
import com.villacamp.hn.excellence.dto.UpsertDTO;
import com.villacamp.hn.excellence.entity.User;

import java.util.List;

public interface JobService {

    List<JobResponseDTO> findJobs(User user);

    UpsertDTO insertJob(User user, JobRequestDTO request);

    UpsertDTO updateJob(User user, JobUpdateDTO update);

    boolean deleteJob(User user, int id);
}
