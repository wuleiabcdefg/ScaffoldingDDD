package ddd.auth.model.user;

import ddd.auth.model.role.RoleId;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 登录本系统的人员
 */
@Setter
@Getter
public class User {
    /**
     * 唯一ID
     */
    private UserId userId;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 年龄
     */
    private Short age;

    /**
     * 拥有的角色
     */
    private List<RoleId> roles;

}
