package base.exception.code;

/**
 * 通用的异常码
 */
public enum CommonExceptionCodeEnum implements ExceptionCode {
    JSON_TO_OBJECT_ERROR("解析JSON错误"),
    OBJECT_TO_JSON_ERROR("解析JSON错误"),
    USER_OR_PASSWORD_ERROR("用户或密码无效"),
    UNKNOWN_ERROR("程序错误，请联系系统管理员"),

    ;

    private final String message;

    CommonExceptionCodeEnum(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public String getCode() {
        return this.name();
    }
}
