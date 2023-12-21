package ddd.interceptor;

import base.exception.AbstractCustomException;
import base.exception.ServerInternalRuntimeException;
import base.exception.code.CommonExceptionCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 异常处理切面
 */
@Aspect
@Component
@Slf4j
public class ServiceExceptionHandlerAOP {


    /**
     * 切点 所有应用层服务的公共方法 排除set方法
     */
    @Pointcut(value = "execution(public * ddd.services.*.*(..)) && !execution(public * ddd..*.set*(..)) ")
    public void pointCut() {

    }

    /**
     * 后置异常通知
     * 定义一个名字，该名字用于匹配通知实现方法的一个参数名，当目标方法抛出异常返回后，将把目标方法抛出的异常传给通知方法；
     * throwing:限定了只有目标方法抛出的异常与通知方法相应参数异常类型时才能执行后置异常通知，否则不执行，
     * 对于throwing对应的通知方法参数为Throwable类型将匹配任何异常。
     *
     * @param joinPoint 切点
     * @param exception 抛出的异常
     */
    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void doAfterThrowingAdvice(JoinPoint joinPoint, Throwable exception) {
        log.error("拦截异常打印 ", exception);

        if (exception instanceof AbstractCustomException e) {
            throw e;
        }

        throw new ServerInternalRuntimeException(CommonExceptionCodeEnum.UNKNOWN_ERROR, exception);
    }
}