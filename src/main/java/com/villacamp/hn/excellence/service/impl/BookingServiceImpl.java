package com.villacamp.hn.excellence.service.impl;

import com.villacamp.hn.excellence.converter.BookingConverter;
import com.villacamp.hn.excellence.dto.BookingDTO;
import com.villacamp.hn.excellence.dto.BookingRequestDTO;
import com.villacamp.hn.excellence.dto.BookingUpdateDTO;
import com.villacamp.hn.excellence.dto.UpsertDTO;
import com.villacamp.hn.excellence.entity.Booking;
import com.villacamp.hn.excellence.entity.User;
import com.villacamp.hn.excellence.exception.NotFoundException;
import com.villacamp.hn.excellence.repository.AddressRepository;
import com.villacamp.hn.excellence.repository.BookingRepository;
import com.villacamp.hn.excellence.repository.JobRepository;
import com.villacamp.hn.excellence.service.BookingService;
import com.villacamp.hn.excellence.utils.enums.BookingStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository repository;
    private final JobRepository jobRepository;
    private final AddressRepository addressRepository;

    @Override
    public List<BookingDTO> findAll(User user) {
        return repository.findAll()
                .stream()
                .filter(b -> Objects.equals(b.getAddress().getUser().getId(), user.getId()))
                .map(BookingConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public UpsertDTO insertBooking(User user, BookingRequestDTO request) {
        var result = repository.save(
                Booking.builder()
                        .job(jobRepository.findById(request.getJobId())
                                .orElseThrow(() -> new NotFoundException("Invalid job id.")))
                        .bookedDateTime(request.getBookedDateTime())
                        .phone(request.getPhone())
                        .address(addressRepository.findByIdAndUser(request.getAddressId(), user)
                                .orElseThrow(() -> new NotFoundException(("Invalid address id."))))
                        .locationSize(request.getLocationSize())
                        .rooms(request.getRooms())
                        .status(BookingStatus.PND)
                        .build());
        return UpsertDTO.builder()
                .success(result.getId() > 0)
                .data(result.getId())
                .build();
    }

    @Override
    public UpsertDTO updateBooking(User user, BookingUpdateDTO request) {
        var entity = repository.findById(request.getId())
                .orElseThrow(() -> new NotFoundException("Invalid booking id."));

        if (!Objects.equals(entity.getAddress().getUser().getId(), user.getId()))
            return UpsertDTO.builder()
                    .success(false)
                    .msg("Invalid booking for current user.")
                    .build();
        entity.setAddress(addressRepository.findByIdAndUser(request.getAddressId(), user)
                .orElseThrow(() -> new NotFoundException("Invalid address id.")));
        entity.setJob((jobRepository.findById(request.getJobId())
                .orElseThrow(() -> new NotFoundException("Invalid job id."))));
        entity.setBookedDateTime(request.getBookedDateTime());
        entity.setLocationSize(request.getLocationSize());
        entity.setRooms(request.getRooms());
        entity.setPhone(request.getPhone());

        return UpsertDTO.builder()
                .success(true)
                .data(repository.save(entity).getId())
                .build();
    }

    @Override
    public boolean deleteBooking(User user, long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Invalid booking id."));

        if (!Objects.equals(entity.getAddress().getUser().getId(), user.getId()))
            return false;
        repository.delete(entity);
        return true;
    }

    @Override
    public boolean updateStatus(User user, long id, BookingStatus status) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Invalid booking id."));

        if (!Objects.equals(entity.getAddress().getUser().getId(), user.getId()))
            throw new NotFoundException("Booking does not exist in current user.");
        else if (status.equals(BookingStatus.COM))
            entity.setCompletionDate(LocalDateTime.now());
        entity.setStatus(status);
        repository.save(entity);
        return true;
    }
}
