package ddd.auth.model.permission;


/**
 * 权限ID
 */
public enum PermissionId {

    /**
     * 权限ID 新增考勤
     */
    ADD_ATTENDANCE("ADD_ATTENDANCE"),
    /**
     * 权限ID 新增考勤模板
     */
    ADD_ATTENDANCE_TEMPLATE("ADD_ATTENDANCE_TEMPLATE"),
    /**
     * 权限ID 删除考勤
     */
    DELETE_ATTENDANCE("DELETE_ATTENDANCE"),
    /**
     * 权限ID 导出考勤
     */
    EXPORT_ATTENDANCE("EXPORT_ATTENDANCE"),
    /**
     * 权限ID 导出考勤模板
     */
    EXPORT_ATTENDANCE_TEMPLATE("EXPORT_ATTENDANCE_TEMPLATE"),
    /**
     * 权限ID 导入考勤
     */
    IMPORT_ATTENDANCE("IMPORT_ATTENDANCE"),
    /**
     * 权限ID 查询全部考勤
     */
    QUERY_ALL_ATTENDANCE("QUERY_ALL_ATTENDANCE"),
    /**
     * 权限ID 查询个人考勤
     */
    QUERY_PERSONAL_ATTENDANCE("QUERY_PERSONAL_ATTENDANCE"),
    /**
     * 权限ID 修改考勤
     */
    UPDATE_ATTENDANCE("UPDATE_ATTENDANCE"),
    /**
     * 权限ID 修改考勤模板
     */
    UPDATE_ATTENDANCE_TEMPLATE("UPDATE_ATTENDANCE_TEMPLATE"),
    ;


    private final String code;

    PermissionId(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}