package ddd.repository.assembler;

import cn.hutool.core.convert.Convert;
import ddd.auth.model.role.RoleId;
import ddd.auth.model.user.EmployeeID;
import ddd.auth.model.user.User;
import ddd.repository.db.entity.Employee;
import ddd.repository.db.entity.EmployeeRole;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UserAssembler {


    public static User toUser(Employee employee, List<EmployeeRole> roles) {
        final User user = Convert.convert(User.class, employee);

        user.setUserId(new EmployeeID(employee.getEmployeeID()));
        user.setUserName(employee.getName());
        user.setRoles(roles.stream().map(employeeRole -> new RoleId(employeeRole.getRoleId())).toList());
        return user;
    }
}
