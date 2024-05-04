package ddd.repository.db.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@Table(name = "Employee")
@ToString
public class Employee {
    /**
     * 员工id
     */
    @Id
    private Long employeeID;
    /**
     * 姓名
     */
    private String name;
    /**
     * 员工号
     */
    private String employeeNumber;
    /**
     * 登录名
     */
    private String loginName;
    /**
     * 密码（加密）
     */
    private String password;
}
