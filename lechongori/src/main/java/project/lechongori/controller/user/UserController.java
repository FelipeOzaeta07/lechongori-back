package project.lechongori.controller.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.lechongori.commons.constans.EndPoint.User.IUserEndPoint;
import project.lechongori.commons.constans.response.IGeneralResponse;
import project.lechongori.commons.domains.dto.user.UserDTO;
import project.lechongori.commons.domains.responseDTO.GenericResponseDTO;
import project.lechongori.service.user.UserService;

@RestController
@RequestMapping(IUserEndPoint.USER_BASE_URL)
@Tag(name = "Sistema de Gestión de Usuario", description = "Crear, visualizar, eliminar y actualizar Usuario")
@Log4j2
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Autenticacion de Usuario")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = "ok",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GenericResponseDTO.class))}),
            @ApiResponse(responseCode  = "400", description = "FAIL",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode  = "404", description = IGeneralResponse.NOT_FOUND,
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode  = "500", description = IGeneralResponse.INTERNAL_SERVER,
                    content = {@Content(mediaType = "application/json")})})
    @PostMapping(IUserEndPoint.USER_SERVICE)
    public ResponseEntity<GenericResponseDTO> serviceUser(@RequestBody UserDTO userDTO) {
        return this.userService.serviceUser(userDTO);
    }
}
