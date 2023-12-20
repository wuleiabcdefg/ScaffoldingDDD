package base.exception;

import base.exception.code.ExceptionCode;

/**
 * 可以处理的业务异常，
 * 因为用户输入的错误参数导致业务无法进行，则抛出BusinessRuntimeException
 * 例如输入的日期格式错误导致DateFormat报错
 */
@SuppressWarnings("unused")
public class BusinessRuntimeException extends AbstractCustomException {

    /**
     * @param exceptionCode 异常code
     * @param cause         原始异常，
     */
    public BusinessRuntimeException(ExceptionCode exceptionCode, Throwable cause) {
        super(exceptionCode, cause);
    }

    /**
     * @param exceptionCode 异常code
     */
    public BusinessRuntimeException(ExceptionCode exceptionCode) {
        super(exceptionCode);
    }
}
