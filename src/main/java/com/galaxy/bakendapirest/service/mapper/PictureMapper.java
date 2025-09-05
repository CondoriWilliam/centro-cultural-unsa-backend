package com.galaxy.bakendapirest.service.mapper;

import com.galaxy.bakendapirest.controller.dto.PictureItem;
import com.galaxy.bakendapirest.repository.entity.PictureEntity;

public class PictureMapper {

    private PictureMapper() {};

    public static PictureEntity fromDtoToEntity(PictureItem item, PictureEntity entity) {
        entity.setName(item.getName());
        entity.setTechnique(item.getTechnique());
        entity.setCategory(item.getCategory());
        entity.setDescription(item.getDescription());
        entity.setYear(item.getYear());
        entity.setLink_image(item.getLink_image());
        entity.setLink_qr(item.getLink_qr());
        entity.setLink_audio(item.getLink_audio());
        entity.setPos_x(item.getPos_x());
        entity.setPos_y(item.getPos_y());
        return entity;
    }

    public static PictureItem fromEntityToDto(PictureEntity entity, PictureItem item) {
        item.setId(entity.getId());
        item.setName(entity.getName());
        item.setTechnique(entity.getTechnique());
        item.setCategory(entity.getCategory());
        item.setDescription(entity.getDescription());
        item.setYear(entity.getYear());
        item.setLink_image(entity.getLink_image());
        item.setLink_qr(entity.getLink_qr());
        item.setLink_audio(entity.getLink_audio());
        item.setPos_x(entity.getPos_x());
        item.setPos_y(entity.getPos_y());
        return item;
    }
}
