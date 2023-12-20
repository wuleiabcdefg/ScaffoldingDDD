package ddd.repository;

import ddd.api.repository.IUserRepository;
import ddd.repository.assembler.UserAssembler;
import ddd.repository.db.UserJpa;
import ddd.repository.db.UserRoleJpa;
import ddd.repository.db.entity.UserRecord;
import ddd.repository.db.entity.UserRoleRecord;
import ddd.user.User;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Setter(onMethod = @__(@Autowired))
public class UserRepositoryImpl implements IUserRepository {

    private UserJpa userJpa;

    private UserRoleJpa userRoleJpa;

    @Override
    public User getUserById(Long userId) {
        final Optional<UserRecord> userJpaById = userJpa.findById(userId);
        final List<UserRoleRecord> roles = userRoleJpa.findByUserId(userId);
        return userJpaById.map(userRecord -> UserAssembler.toUser(userRecord, roles)).orElse(null);
    }
}
