package com.galaxy.bakendapirest.service.impl;

import com.galaxy.bakendapirest.controller.dto.PictureItem;
import com.galaxy.bakendapirest.exception.EntityNotFoundException;
import com.galaxy.bakendapirest.repository.PictureRepository;
import com.galaxy.bakendapirest.repository.entity.PictureEntity;
import com.galaxy.bakendapirest.service.PictureService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PictureServiceImplTest {

    private PictureService pictureService;

    @Mock
    private PictureRepository pictureRepository;

    @Captor
    private ArgumentCaptor<PictureEntity> pictureEntityCaptor;

    @BeforeEach
    void init() {
        pictureService = new PictureServiceImpl(pictureRepository);
    }

    @Test
    void list() {
        PictureEntity entity = new PictureEntity();
        List<PictureEntity> entities = List.of(entity);
        when(pictureRepository.findByActivate(true)).thenReturn(entities);

        List<PictureItem> pictureItems = pictureService.list();
        Assertions.assertNotNull(pictureItems);
        Assertions.assertEquals(1, pictureItems.size());
    }

    @Test
    void create() {
        PictureItem request = new PictureItem();
        pictureService.create(request);
        verify(pictureRepository, times(1)).save(pictureEntityCaptor.capture());

        PictureEntity captured = pictureEntityCaptor.getValue();
        Assertions.assertNotNull(captured);
        Assertions.assertTrue(captured.getActivate());
    }

    @Test
    void update() {
        Integer id = 1;
        PictureItem request = new PictureItem();
        PictureEntity entity = new PictureEntity();
        entity.setActivate(true);

        when(pictureRepository.findById(id)).thenReturn(Optional.of(entity));

        pictureService.update(id,request);
        verify(pictureRepository, times(1)).save(pictureEntityCaptor.capture());

        PictureEntity captured = pictureEntityCaptor.getValue();
        Assertions.assertNotNull(captured);
        Assertions.assertEquals(captured, entity);
    }

    @Test
    void updateException() {
        Integer id = 1;
        PictureItem request = new PictureItem();
        Assertions.assertThrows(EntityNotFoundException.class, () -> pictureService.update(id, request));

        PictureEntity entity = new PictureEntity();
        entity.setActivate(false);
        when(pictureRepository.findById(id)).thenReturn(Optional.of(entity));
        Assertions.assertThrows(EntityNotFoundException.class, () -> pictureService.update(id, request));
    }

    @Test
    void listById(){
        Integer id = 1;
        PictureEntity entity = new PictureEntity();
        entity.setId(id);
        when(pictureRepository.findByIdAndActivate(id, true)).thenReturn(Optional.of(entity));
        PictureItem itemResponse = pictureService.listById(id);
        Assertions.assertNotNull(itemResponse);
        Assertions.assertEquals(entity.getId(), itemResponse.getId());
    }

    @Test
    void listByIdException() {
        Assertions.assertThrows(EntityNotFoundException.class, () -> pictureService.listById(1));
    }

    @Test
    void delete() {
        Integer id = 1;
        PictureEntity entity = new PictureEntity();
        entity.setId(id);
        entity.setActivate(true);
        when(pictureRepository.findByIdAndActivate(id, true)).thenReturn(Optional.of(entity));
        pictureService.delete(id);
        verify(pictureRepository, times(1)).save(pictureEntityCaptor.capture());
        PictureEntity captured = pictureEntityCaptor.getValue();
        Assertions.assertNotNull(captured);
        Assertions.assertFalse(captured.getActivate());
    }

    @Test
    void deleteByException() {
        Assertions.assertThrows(EntityNotFoundException.class, () -> pictureService.delete(1));
    }

}