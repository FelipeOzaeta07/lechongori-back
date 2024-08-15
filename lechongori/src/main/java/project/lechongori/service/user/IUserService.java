package project.lechongori.service.user;

import project.lechongori.commons.domains.dto.user.UserDTO;

public interface IUserService {
    UserDTO getUser(String email);
}
