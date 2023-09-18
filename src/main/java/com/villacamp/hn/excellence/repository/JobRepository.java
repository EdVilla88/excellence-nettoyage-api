package com.villacamp.hn.excellence.repository;

import com.villacamp.hn.excellence.entity.Job;
import com.villacamp.hn.excellence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JobRepository extends JpaRepository<Job, Long> {
    Optional<List<Job>> findAllByUser(User user);
}
