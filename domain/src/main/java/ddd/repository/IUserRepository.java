package ddd.repository;

import ddd.user.User;

public interface IUserRepository {
    User getUserById(String userId);
}
