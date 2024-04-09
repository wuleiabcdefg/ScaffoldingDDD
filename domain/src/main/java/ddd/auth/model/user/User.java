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
    private EmployeeID userId;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 登录名
     */
    private String loginName;
    /**
     * 工号
     */
    private String employeeNumber;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 职位
     */
    private String position;
    /**
     * 年龄
     */
    private Short age;

    /**
     * 拥有的角色
     */
    private List<RoleId> roles;

}
