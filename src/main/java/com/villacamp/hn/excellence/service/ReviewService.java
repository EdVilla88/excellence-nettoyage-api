package com.villacamp.hn.excellence.service;

import com.villacamp.hn.excellence.dto.ReviewDTO;

import java.util.List;

public interface ReviewService {

    List<ReviewDTO> findReviewsByJob(long jobId);
}
