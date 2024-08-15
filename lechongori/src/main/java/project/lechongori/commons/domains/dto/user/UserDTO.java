package project.lechongori.commons.domains.dto.user;
import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
public class UserDTO {
    private Integer idUser;
    private String email;
    private String password;
    private String role;
}
