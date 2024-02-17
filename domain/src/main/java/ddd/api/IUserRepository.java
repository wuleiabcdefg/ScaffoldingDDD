package ddd.api;

import ddd.auth.model.user.User;

public interface IUserRepository {
    User getUserById(Long userId);
}
