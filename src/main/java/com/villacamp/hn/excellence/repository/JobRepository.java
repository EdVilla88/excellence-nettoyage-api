package com.villacamp.hn.excellence.repository;

import com.villacamp.hn.excellence.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
