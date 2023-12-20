package ddd.api.repository;

import ddd.user.User;

public interface IUserRepository {
    User getUserById(Long userId);
}
