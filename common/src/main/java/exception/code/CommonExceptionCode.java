package exception.code;

/**
 * 通用的异常码
 */
public enum CommonExceptionCode implements ExceptionCode{
    TO_JSON_STR_ERROR("解析JSON错误");

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
