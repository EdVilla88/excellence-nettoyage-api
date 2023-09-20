package com.villacamp.hn.excellence.converter;

import com.villacamp.hn.excellence.dto.BookingDTO;
import com.villacamp.hn.excellence.entity.Booking;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@NoArgsConstructor
public final class BookingConverter {

    public static BookingDTO convert(Booking entity) {
        return new ModelMapper().map(entity, BookingDTO.class);
    }

    public static Booking convert(BookingDTO dto) {
        return new ModelMapper().map(dto, Booking.class);
    }
}
