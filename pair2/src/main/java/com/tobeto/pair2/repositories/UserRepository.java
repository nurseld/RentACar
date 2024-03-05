package com.tobeto.pair2.repositories;

import com.tobeto.pair2.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User,Integer> {
//   Optional<User> findByUsername(String username);

   Optional<User> findByEmail(String email);

   User findByUsername(String username);

    boolean existsUserByEmail(String email);
}
