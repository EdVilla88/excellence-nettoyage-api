package com.villacamp.hn.excellence.repository;

import com.villacamp.hn.excellence.entity.Address;
import com.villacamp.hn.excellence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Optional<List<Address>> findAllByClient(User client);

    Optional<Address> findByIdAndClient(long id, User client);
}
