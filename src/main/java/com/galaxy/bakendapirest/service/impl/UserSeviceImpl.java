package com.galaxy.bakendapirest.service.impl;

import com.galaxy.bakendapirest.controller.dto.UserRequest;
import com.galaxy.bakendapirest.exception.EntityNotFoundException;
import com.galaxy.bakendapirest.repository.DocTypeRepository;
import com.galaxy.bakendapirest.repository.RoleRepository;
import com.galaxy.bakendapirest.repository.UserRepository;
import com.galaxy.bakendapirest.repository.entity.DocTypeEntity;
import com.galaxy.bakendapirest.repository.entity.RoleEntity;
import com.galaxy.bakendapirest.repository.entity.UserEntity;
import com.galaxy.bakendapirest.service.UserService;
import com.galaxy.bakendapirest.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserSeviceImpl implements UserService {

    private final UserRepository userRepository;
    private final DocTypeRepository docTypeRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void create(UserRequest request) {
        Optional<DocTypeEntity> docTypeEntityOpt = docTypeRepository.findById(request.getDocTypeId());
        if (docTypeEntityOpt.isEmpty()) {
            throw new EntityNotFoundException(String.format("DocType no found with id %d", request.getDocTypeId()));
        }
        Optional<RoleEntity> roleEntityOpt = roleRepository.findById(request.getRoleId());
        if (roleEntityOpt.isEmpty()) {
            throw new EntityNotFoundException(String.format("Role no found with id %d", request.getRoleId()));
        }

        UserEntity userEntity = UserMapper.populateEntity(request, new UserEntity());
        userEntity.setPassword(passwordEncoder.encode(request.getPassword()));
        userEntity.setDocTypeEntity(docTypeEntityOpt.get());
        userEntity.setRoleEntity(roleEntityOpt.get());
        userEntity.setActivate(true);
        userRepository.save(userEntity);
    }
}
