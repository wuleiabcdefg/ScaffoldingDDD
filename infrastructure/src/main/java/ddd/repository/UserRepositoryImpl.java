package ddd.repository;

import ddd.api.UserRepository;
import ddd.auth.model.user.User;
import ddd.repository.assembler.UserAssembler;
import ddd.repository.db.UserJpa;
import ddd.repository.db.UserRoleJpa;
import ddd.repository.db.entity.Employee;
import ddd.repository.db.entity.EmployeeRole;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Setter(onMethod = @__(@Autowired))
public class UserRepositoryImpl implements UserRepository {

    private UserJpa userJpa;

    private UserRoleJpa userRoleJpa;

    @Override
    public User getUserById(Long userId) {
        final Optional<Employee> userJpaById = userJpa.findById(userId);
        final List<EmployeeRole> roles = userRoleJpa.findByEmployeeId(userId);
        return userJpaById.map(employee -> UserAssembler.toUser(employee, roles)).orElse(null);
    }

    @Override
    public User findUser(final String loginName) {
        final Employee employee = userJpa.findByLoginName(loginName);
        if (employee!=null) {
            return UserAssembler.toUser(employee, List.of());
        }
        return null;
    }
}
