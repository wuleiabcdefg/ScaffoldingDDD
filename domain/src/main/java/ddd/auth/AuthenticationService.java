package ddd.auth;


import ddd.api.IUserRepository;
import org.springframework.stereotype.Component;

/**
 * 权限认证领域服务
 */
@Component
public class AuthenticationService {

    private final IUserRepository userRepository;


    public AuthenticationService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String authenticate(String userName, String password) {
        // 1. 验证用户名和密码

        // 2. 验证通过后生成token
        return null;
    }
}
