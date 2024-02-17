package ddd.repository.assembler;

import ddd.auth.model.role.RoleId;
import ddd.auth.model.user.User;
import ddd.auth.model.user.UserId;
import ddd.repository.db.entity.UserRecord;
import ddd.repository.db.entity.UserRoleRecord;
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
