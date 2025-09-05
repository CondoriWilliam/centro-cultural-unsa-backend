package com.galaxy.bakendapirest.service.impl;

import com.galaxy.bakendapirest.controller.dto.PictureItem;
import com.galaxy.bakendapirest.exception.EntityNotFoundException;
import com.galaxy.bakendapirest.repository.PictureRepository;
import com.galaxy.bakendapirest.repository.entity.PictureEntity;
import com.galaxy.bakendapirest.service.PictureService;
import com.galaxy.bakendapirest.service.mapper.PictureMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service // "pictureServiceBean"
@RequiredArgsConstructor
public class PictureServiceImpl implements PictureService {

    private final PictureRepository pictureRepository;

    @Override
    public List<PictureItem> list() {
        List<PictureEntity> entities = pictureRepository.findByActivate(true);
        return entities.stream()
                .map(entity -> PictureMapper.fromEntityToDto(entity, new PictureItem()))
                .toList();
    }

    @Override
    public PictureItem listById(Integer id) {
        Optional<PictureEntity> pictureEntity = pictureRepository.findByIdAndActivate(id, true);
        if (pictureEntity.isEmpty()) {
            throw new EntityNotFoundException("No entity with id: "+ id + ", It's empty");
        }
        return PictureMapper.fromEntityToDto(pictureEntity.get(), new PictureItem());
    }

    @Override
    public void create(PictureItem item) {
        PictureEntity entity = PictureMapper.fromDtoToEntity(item, new PictureEntity());
        entity.setActivate(true);
        pictureRepository.save(entity);
    }

    @Override
    public void update(Integer id, PictureItem item) {
        Optional<PictureEntity> bdEntityOpt = pictureRepository.findById(id);
        if (bdEntityOpt.isEmpty()) {
            throw new EntityNotFoundException("No entity with id" + id + " is found to update");
        }
        if (Boolean.FALSE.equals(bdEntityOpt.get().getActivate())) {
            throw new EntityNotFoundException("Product " + id + " was previous eliminated");
        }
        PictureEntity dbEntity = bdEntityOpt.get();
        PictureMapper.fromDtoToEntity(item, dbEntity);
        pictureRepository.save(dbEntity);
    }

    @Override
    public void delete(Integer id) {
        Optional<PictureEntity> bdEntityOpt = pictureRepository.findByIdAndActivate(id, true);
        if (bdEntityOpt.isEmpty()) {
            throw new EntityNotFoundException("No entity with id" + id + " is found to delete");
        }
        PictureEntity dbEntity = bdEntityOpt.get();
        dbEntity.setActivate(false);
        pictureRepository.save(dbEntity);
    }
}
