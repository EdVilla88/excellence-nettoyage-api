package com.villacamp.hn.excellence.repository;

import com.villacamp.hn.excellence.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
