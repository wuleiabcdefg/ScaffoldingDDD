package exception;

import exception.code.ExceptionCode;
import lombok.Getter;

import java.io.Serial;

/** 可以处理的业务异常，
 *  因为用户输入的错误参数导致业务无法进行，则抛出BusinessRuntimeException
 *  例如输入的日期格式错误导致DateFormat报错
 */
@Getter
@SuppressWarnings("unused")
public class BusinessRuntimeException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    private final ExceptionCode exceptionCode;

    /**
     * @param exceptionCode 异常code
     * @param cause 原始异常，
     */
    public BusinessRuntimeException(ExceptionCode exceptionCode, Throwable cause) {
        super(exceptionCode.getMessage(), cause);
        this.exceptionCode = exceptionCode;
    }

    /**
     * @param exceptionCode  异常code
     */
    public BusinessRuntimeException(ExceptionCode exceptionCode) {
        super(exceptionCode.getMessage());
        this.exceptionCode = exceptionCode;
    }
}
