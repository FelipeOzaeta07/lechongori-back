package project.lechongori.commons.converter.user;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import project.lechongori.commons.domains.dto.user.UserDTO;
import project.lechongori.commons.domains.entity.user.UserEntity;
import project.lechongori.commons.helpers.HelperMapper;

@Component
@Log4j2
public class UserConverter {

    public UserDTO convertUserEntityToUserDTO(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();
        try {
            userDTO = HelperMapper.modelMapper().map(userEntity, UserDTO.class);
        } catch (Exception e) {
            log.error("Error converting UserEntity to UserDTO: " + e.getMessage(), e);
        }
        return userDTO;
    }
    public UserEntity convertUserDTOToUserEntity(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        try {
            userEntity = HelperMapper.modelMapper().map(userDTO, UserEntity.class);
        } catch (Exception e) {
            log.error("Error converting UserDTO to UserEntity: " + e.getMessage(), e);
        }
        return userEntity;
    }
}
