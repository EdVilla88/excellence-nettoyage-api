package com.villacamp.hn.excellence.repository;

import com.villacamp.hn.excellence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findUserByEmail(String email);

    Boolean existsByEmail(String email);
}
