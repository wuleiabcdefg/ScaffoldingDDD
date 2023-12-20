package ddd.auth.code;

import base.exception.code.ExceptionCode;

public enum AppExceptionCodeEnum implements ExceptionCode {
    USER_NOT_FOUND("用户未找到");

    private final String message;

    AppExceptionCodeEnum(String message) {
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