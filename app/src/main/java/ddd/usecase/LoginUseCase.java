package ddd.usecase;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 登录
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LoginUseCase {

    @Setter
    @Getter
    public static class Request {
        private String userName;
        private String password;
    }
}
