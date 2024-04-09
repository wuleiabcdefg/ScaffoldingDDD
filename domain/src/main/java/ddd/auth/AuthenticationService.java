package ddd.auth;


import base.exception.BusinessRuntimeException;
import base.exception.code.CommonExceptionCodeEnum;
import ddd.api.UserRepository;
import ddd.auth.model.user.User;
import ddd.infra.SecureInterface;
import ddd.infra.TokenInterface;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * 权限认证领域服务
 */
@Component
public class AuthenticationService {

    private final UserRepository userRepository;
    private final TokenInterface tokenInterface;
    private final SecureInterface secureInterface;


    public AuthenticationService(UserRepository userRepository, TokenInterface tokenInterface, SecureInterface secureInterface) {
        this.userRepository = userRepository;
        this.tokenInterface = tokenInterface;
        this.secureInterface = secureInterface;
    }

    public String authenticate(String loginName, String password) {
        User user = userRepository.findUser(loginName);
        if (userNotFound(user) || passwordIsIncorrect(password, user.getPassword())) {
            throw new BusinessRuntimeException(CommonExceptionCodeEnum.USER_OR_PASSWORD_ERROR);
        }
        // 2. 验证通过后生成token
        return tokenInterface.gwtToken(user);
    }

    private boolean passwordIsIncorrect(final String password, final String passwordEncrypted) {
        return !Objects.equals(passwordEncrypted, secureInterface.encrypt(password));
    }

    private boolean userNotFound(final User user) {
        return user==null || user.getUserId()==null;
    }
}
