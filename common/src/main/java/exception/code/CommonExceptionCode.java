package exception.code;

/**
 * 通用的异常码
 */
public enum CommonExceptionCode implements ExceptionCode{
    XXXX_CM_0000001("系统内部错误"),
    ;

    private String message;

    CommonExceptionCode(String message) {
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
