package com.galaxy.bakendapirest.repository;

import com.galaxy.bakendapirest.repository.entity.DocTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocTypeRepository extends JpaRepository<DocTypeEntity, Integer> {
}
