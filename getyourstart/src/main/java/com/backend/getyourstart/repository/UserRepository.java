package com.backend.getyourstart.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.backend.getyourstart.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    @Query("SELECT u FROM UserModel u WHERE u.id = :user_id")
    Optional<UserModel> getUserById(@Param("user_id") Long userId);

    @Query("SELECT u FROM UserModel u WHERE u.username LIKE :username")
    Optional<UserModel> getUserByUsername(@Param("username") String username);
}
