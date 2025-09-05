package com.galaxy.bakendapirest.config;

import com.galaxy.bakendapirest.repository.UserRepository;
import com.galaxy.bakendapirest.repository.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service // contenedor de spring
@RequiredArgsConstructor
public class ProjectUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUserNameAndActivate(username, Boolean.TRUE).orElseThrow(() ->
                new UsernameNotFoundException(String.format("User detail no found for the user %s", username)));
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + userEntity.getRoleEntity().getName());

        return new User(userEntity.getUserName(), userEntity.getPassword(), List.of(authority));
    }
}
