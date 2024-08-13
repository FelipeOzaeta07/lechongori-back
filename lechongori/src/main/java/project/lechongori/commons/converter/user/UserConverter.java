package project.lechongori.commons.converter.user;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import project.lechongori.commons.constans.response.IGeneralResponse;
import project.lechongori.commons.domains.dto.user.UserDTO;
import project.lechongori.commons.domains.entity.user.UserEntity;
import project.lechongori.commons.helpers.HelperMapper;

import java.util.Base64;

@Component
@Log4j2
public class UserConverter {
    public UserDTO convertUserEntityToUserDTO(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();
        try {
            userDTO = HelperMapper.modelMapper().map(userEntity, UserDTO.class);
            byte[] cadenaDecodificadaByte = Base64.getDecoder().decode(userEntity.getUserPassword());
            String cadenaDecodificada = new String(cadenaDecodificadaByte);
            userDTO.setUserPassword(cadenaDecodificada);
        } catch (Exception e) {
            log.error(IGeneralResponse.DOCUMENT_FAIL + e);
        }
        return userDTO;
    }

    public UserEntity convertUserDTOToUserEntity(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        try {
            userEntity = HelperMapper.modelMapper().map(userDTO, UserEntity.class);
            userEntity.setUserPassword(
                    Base64.getEncoder().encodeToString(userDTO.getUserPassword().getBytes()));
        } catch (Exception e) {
            log.error(IGeneralResponse.DOCUMENT_FAIL + e);
        }
        return userEntity;
    }
}