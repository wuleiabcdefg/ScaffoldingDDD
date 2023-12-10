package ddd.repository.db;

import ddd.repository.IUserRepository;
import ddd.user.User;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryImpl implements IUserRepository {
    @Override
    public User getUserById(String userId) {
        User user = new User();
        if (userId.equals("zhangsan")) {
            user.setUserId("zhangsan");
            user.setUserName("张三");
        } else if (userId.equals("lisi")) {
            user.setUserId("lisi");
            user.setUserName("李四");
        } else {
            return null;
        }
        return user;
    }
}
