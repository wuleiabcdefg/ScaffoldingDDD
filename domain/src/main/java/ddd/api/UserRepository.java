package ddd.api;

import ddd.auth.model.user.User;

public interface UserRepository {
    User getUserById(Long userId);

    User findUser(String loginName);
}
