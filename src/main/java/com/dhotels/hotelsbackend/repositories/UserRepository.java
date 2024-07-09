package com.dhotels.hotelsbackend.repositories;

import com.dhotels.hotelsbackend.modules.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    abstract public Optional<User> findByEmail(String email);
}
