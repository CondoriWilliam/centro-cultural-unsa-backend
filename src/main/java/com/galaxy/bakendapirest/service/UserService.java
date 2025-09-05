package com.galaxy.bakendapirest.service;

import com.galaxy.bakendapirest.controller.dto.UserRequest;

public interface UserService {
    void create(UserRequest request);
}
