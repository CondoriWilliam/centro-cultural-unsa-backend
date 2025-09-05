package com.galaxy.bakendapirest.repository;

import com.galaxy.bakendapirest.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByUserNameAndActivate(String username, Boolean isActivate);
}
