package com.villacamp.hn.excellence.repository;

import com.villacamp.hn.excellence.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
