package project.lechongori.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import project.lechongori.commons.converter.user.UserConverter;
import project.lechongori.commons.domains.dto.user.UserDTO;
import project.lechongori.commons.domains.entity.user.UserEntity;
import project.lechongori.repository.user.IUserRepository;
import project.lechongori.service.user.IUserService;

@Component
@Service
public class UserService implements IUserService{

    @Autowired
    private IUserRepository iUserRepository;

    @Autowired
    private UserConverter userConverter;

    public UserDTO getUser(String email) {
        UserEntity find = iUserRepository.findUserByEmail(email)
                .orElseThrow(() -> new RuntimeException("Email " + email + " not found"));
        return userConverter.convertUserEntityToUserDTO(find);
    }





}