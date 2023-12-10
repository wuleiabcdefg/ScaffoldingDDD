package ddd.common;

import lombok.Getter;

/**
 * 异常类型
 */
@Getter
public enum AppErrorType {

    /**
     * 系统异常，比如数据库异常，IO异常，空指针异常
     */
    INTERNAL_ERROR("E"),
    /**
     * 业务异常，比如密码输入错误导致的登录失败
     */
    BUSINESS_ERROR("B"),
    ;

    private final String errorType;

    AppErrorType(String errorType) {
        this.errorType = errorType;
    }

}
