package project.lechongori.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import project.lechongori.commons.domains.entity.user.UserEntity;

public interface IUserRepository extends JpaRepository<UserEntity, Integer> {
}
