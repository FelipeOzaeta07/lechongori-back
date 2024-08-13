package project.lechongori.service.user;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import project.lechongori.commons.constans.response.IGeneralResponse;
import project.lechongori.commons.converter.user.UserConverter;
import project.lechongori.commons.domains.dto.user.UserDTO;
import project.lechongori.commons.domains.entity.user.UserEntity;
import project.lechongori.commons.domains.responseDTO.GenericResponseDTO;
import project.lechongori.repository.user.IUserRepository;

import java.util.List;

@Component
@Log4j2
public class UserService {
    private final IUserRepository iUserRepository;

    private final UserConverter userConverter;

    public UserService(IUserRepository iUserRepository, UserConverter userConverter) {
        this.iUserRepository = iUserRepository;
        this.userConverter = userConverter;
    }
    public ResponseEntity<GenericResponseDTO> serviceUser(UserDTO userDTO) {
        try {
            List<UserEntity> usuarios = iUserRepository.findAll();
            if (!usuarios.isEmpty()) {
                for (UserEntity usuario : usuarios) {
                    UserDTO usuarioDecode = userConverter.convertUserEntityToUserDTO(usuario);
                    if (usuarioDecode.getUserPassword().equals(userDTO.getUserPassword()) &&
                            usuarioDecode.getUserEmail().equals(userDTO.getUserEmail())) {
                        return ResponseEntity.ok(GenericResponseDTO.builder()
                                .message(IGeneralResponse.OPERATION_SUCCESS)
                                .objectResponse("OK")
                                .statusCode(HttpStatus.OK.value())
                                .build());
                    }
                }
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message("ERROR Datos incorrectos")
                        .objectResponse(null)
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .build());
            } else {
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message("error")
                        .objectResponse(null)
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .build());
            }
        } catch (Exception e) {
            log.error(IGeneralResponse.INTERNAL_SERVER, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(GenericResponseDTO.builder()
                            .message(IGeneralResponse.INTERNAL_SERVER)
                            .objectResponse(null)
                            .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }
    }
}
