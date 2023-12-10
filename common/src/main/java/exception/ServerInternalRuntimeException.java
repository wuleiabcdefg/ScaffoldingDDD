package exception;

import exception.code.ExceptionCode;
import lombok.Getter;

import java.io.Serial;

/** 用户无法处理无法处理的系统内部异常, 例如io异常，用户想下载一个文件，但是此文件在服务器上不存在；空指针异常等等
 */
@Getter
public class ServerInternalRuntimeException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    private final ExceptionCode exceptionCode;

    /**
     * @param exceptionCode 异常code
     * @param cause 原始异常，不可传null。
     */
    public ServerInternalRuntimeException(ExceptionCode exceptionCode, Throwable cause) {
        super(exceptionCode.getMessage(), cause);
        this.exceptionCode = exceptionCode;
    }
}
