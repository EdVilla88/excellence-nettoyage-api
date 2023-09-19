package com.villacamp.hn.excellence.converter;

import com.villacamp.hn.excellence.dto.JobDTO;
import com.villacamp.hn.excellence.dto.JobRequestDTO;
import com.villacamp.hn.excellence.entity.Job;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@NoArgsConstructor
public final class JobConverter {
    public static JobDTO convert(Job entity) {
        return new ModelMapper().map(entity, JobDTO.class);
    }

    public static Job convert(JobRequestDTO dto) {
        return new ModelMapper().map(dto, Job.class);
    }

    public static Job convert(JobDTO dto) {
        return new ModelMapper().map(dto, Job.class);
    }
}
