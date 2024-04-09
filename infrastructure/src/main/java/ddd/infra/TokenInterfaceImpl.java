package ddd.infra;

import cn.hutool.jwt.JWT;
import ddd.auth.model.user.User;
import org.springframework.stereotype.Component;

@Component
public class TokenInterfaceImpl implements TokenInterface {
    // 密钥
    byte[] key = "NASCHWADOIO".getBytes();

    @Override
    public String gwtToken(final User user) {
        return JWT.create()
                .setPayload("name", user.getUserId())
                .setKey(key)
                .sign();
    }
}
