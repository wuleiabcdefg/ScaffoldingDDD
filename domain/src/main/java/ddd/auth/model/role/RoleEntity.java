package ddd.auth.model.role;


import ddd.auth.model.permission.PermissionId;
import lombok.Getter;

import java.util.List;

@Getter
public class RoleEntity {

    private RoleId roleId;

    private String roleName;

    private String description;

    private List<PermissionId> permissionIdList;

}
