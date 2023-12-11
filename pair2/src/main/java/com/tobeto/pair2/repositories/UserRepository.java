package com.tobeto.pair2.repositories;

import com.tobeto.pair2.entitites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,Integer> {
}
