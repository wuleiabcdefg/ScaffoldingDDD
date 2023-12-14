package ddd.repository.assembler;

import ddd.repository.db.entity.UserRecord;
import ddd.repository.db.entity.UserRoleRecord;
import ddd.role.RoleId;
import ddd.user.User;
import ddd.user.UserId;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UserAssembler {


    public static User toUser(UserRecord userRecord, List<UserRoleRecord> roles) {
        User user = new User();
        user.setUserId(new UserId(userRecord.getId()));
        user.setUserName(userRecord.getUserName());
        user.setRoles(roles.stream().map(userRoleRecord -> new RoleId(userRoleRecord.getRoleId())).toList());
        return user;
    }
}
