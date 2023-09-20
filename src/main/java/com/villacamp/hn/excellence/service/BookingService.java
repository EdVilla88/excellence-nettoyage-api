package com.villacamp.hn.excellence.service;

import com.villacamp.hn.excellence.dto.BookingDTO;
import com.villacamp.hn.excellence.dto.BookingRequestDTO;
import com.villacamp.hn.excellence.dto.BookingUpdateDTO;
import com.villacamp.hn.excellence.dto.UpsertDTO;
import com.villacamp.hn.excellence.entity.User;
import com.villacamp.hn.excellence.utils.enums.BookingStatus;

import java.util.List;

public interface BookingService {

    List<BookingDTO> findAll(User user);

    UpsertDTO insertBooking(User user, BookingRequestDTO request);

    UpsertDTO updateBooking(User user, BookingUpdateDTO request);

    boolean deleteBooking(User user, long id);

    boolean updateStatus(User user, long id, BookingStatus status);
}
