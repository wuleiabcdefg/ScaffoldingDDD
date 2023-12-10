package ddd.adapter.service.http.interceptor;


import ddd.common.AppErrorType;
import ddd.common.AppResponseDTO;
import exception.AbstractCustomException;
import exception.BusinessRuntimeException;
import exception.code.CommonExceptionCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一处理控制层的异常
 * 编译时异常
 * 开发人员捕获到编译时异常后，根据用户是否有办法通过调整参数来判断：
 * ● 无法处理，系统内部异常，。则抛出ServerInternalRuntimeException 例如io异常，用户想下载一个文件，但是此文件在服务器上不存在。
 * ● 可以处理， 业务异常，因为用户输入的错误参数导致业务无法进行，则抛出BusinessRuntimeException 例如输入的日期格式错误导致DateFormat报错
 * 应用程序统一监控所有运行时异常，并根据异常类型对外输出
 * ● 对外只抛出业务异常与系统内部异常。
 * ● 数据库异常，封装为业务异常。统一封装数据库抛出的长度异常，转换成用户看得懂的异常信息，如：XX字段超出长度限制
 * ● 其他的运行时异常统一转换成系统内部异常。
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public AppResponseDTO<Void> error(Exception ex) {
        log.error("拦截异常打印 ", ex);

        AppErrorType errorType = AppErrorType.INTERNAL_ERROR;

        if (ex instanceof AbstractCustomException e) {
            if (e instanceof BusinessRuntimeException) {
                errorType = AppErrorType.BUSINESS_ERROR;
            }
            return AppResponseDTO.error(errorType, e.getExceptionCode());
        }

        return AppResponseDTO.error(errorType, CommonExceptionCodeEnum.UNKNOWN_ERROR);
    }

}