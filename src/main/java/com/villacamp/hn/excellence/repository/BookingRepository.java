package com.villacamp.hn.excellence.repository;

import com.villacamp.hn.excellence.entity.Booking;
import com.villacamp.hn.excellence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    Optional<List<Booking>> findAll(User user);
}
