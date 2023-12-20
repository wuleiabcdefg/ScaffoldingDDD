package base.exception;

import base.exception.code.ExceptionCode;
import lombok.Getter;

import java.io.Serial;

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
