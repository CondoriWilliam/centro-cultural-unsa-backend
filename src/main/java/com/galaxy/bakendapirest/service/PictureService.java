package com.galaxy.bakendapirest.service;

import com.galaxy.bakendapirest.controller.dto.PictureItem;

import java.util.List;

public interface PictureService {
    List<PictureItem> list();
    void create(PictureItem item);
    void update(Integer id, PictureItem item);
    void delete(Integer id);

    PictureItem listById(Integer id);
}
