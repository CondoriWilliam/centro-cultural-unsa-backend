package com.galaxy.bakendapirest.repository;

import com.galaxy.bakendapirest.repository.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
}
