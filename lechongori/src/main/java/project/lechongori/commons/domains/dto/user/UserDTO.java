package project.lechongori.commons.domains.dto.user;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserDTO implements Serializable {
    private Integer userId;
    private String userEmail;
    private String userPassword;
}