package com.galaxy.bakendapirest.service.mapper;

import com.galaxy.bakendapirest.controller.dto.UserRequest;
import com.galaxy.bakendapirest.repository.entity.UserEntity;

public class UserMapper {

    private UserMapper() {}

    public static UserEntity populateEntity(UserRequest request, UserEntity entity) {
        entity.setUserName(request.getUsername());
        entity.setFirstName(request.getFirstName());
        entity.setLastName(request.getLastName());
        entity.setDocNumber(request.getDocNumber());
        return entity;
    }
}
