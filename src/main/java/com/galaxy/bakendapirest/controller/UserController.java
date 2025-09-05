package com.galaxy.bakendapirest.controller;

import com.galaxy.bakendapirest.controller.dto.UserRequest;
import com.galaxy.bakendapirest.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody UserRequest request) {
        userService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/authenticate")
    public ResponseEntity<Void> authenticate() { return ResponseEntity.status(HttpStatus.OK).build(); }
}
