package project.lechongori.controller.user;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.lechongori.commons.constans.EndPoint.User.IUserEndPoint;
import project.lechongori.commons.domains.dto.user.UserDTO;
import project.lechongori.service.user.impl.UserService;

@RestController
@RequestMapping(IUserEndPoint.USER_BASE_URL)
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(IUserEndPoint.USER_EMAIL)
    public ResponseEntity<UserDTO> getClient(@PathVariable String email){
        return new ResponseEntity<>(userService.getUser(email), HttpStatus.OK);
    }
}
