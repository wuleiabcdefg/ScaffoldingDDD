package ddd.infra;

import ddd.auth.model.user.User;

public interface TokenInterface {


    /**
     * 生成gwtToken
     *
     * @param user 用户信息
     * @return token
     */
    String gwtToken(User user);
}
