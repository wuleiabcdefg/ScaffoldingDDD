package ddd.adapter.service.http.interceptor;

import ddd.common.AppResponseDTO;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 返回结果拦截处理
 */
@ControllerAdvice
@SuppressWarnings("all")
public class ResponseBodyHandler implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof AppResponseDTO) {
            return body;
        }
        if (body != null) {
            return AppResponseDTO.ok(body);
        }
        return AppResponseDTO.ok();
    }
}
