package com.villacamp.hn.excellence.service.impl;

import com.villacamp.hn.excellence.converter.ReviewConverter;
import com.villacamp.hn.excellence.dto.ReviewDTO;
import com.villacamp.hn.excellence.repository.ReviewRepository;
import com.villacamp.hn.excellence.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository repository;

    @Override
    public List<ReviewDTO> findReviewsByJob(long jobId) {
        var entities = repository.findAll()
                .stream()
                .filter(r -> r.getJob().getId() == jobId)
                .toList();
        return entities.stream()
                .map(ReviewConverter::convert)
                .collect(Collectors.toList());
    }
}
