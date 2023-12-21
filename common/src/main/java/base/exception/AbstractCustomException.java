package base.exception;

import base.exception.code.ExceptionCode;
import lombok.Getter;

import java.io.Serial;

/**
 * 主要分为业务异常和系统异常。系统异常需要开发团队处理。业务异常需要具备监控能力。
 */
@Getter
public abstract class AbstractCustomException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    private final transient ExceptionCode exceptionCode;

    protected AbstractCustomException(ExceptionCode exceptionCode, Throwable cause) {
        super(exceptionCode.getMessage(), cause);
        this.exceptionCode = exceptionCode;
    }

    protected AbstractCustomException(ExceptionCode exceptionCode) {
        super(exceptionCode.getMessage());
        this.exceptionCode = exceptionCode;
    }

}
