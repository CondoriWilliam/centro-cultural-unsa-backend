package com.galaxy.bakendapirest.repository;

import com.galaxy.bakendapirest.repository.entity.PictureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PictureRepository extends JpaRepository<PictureEntity, Integer> {

    Optional<PictureEntity> findByIdAndActivate(Integer id, boolean isActivate);

    List<PictureEntity> findByActivate(boolean isActivate);
}
