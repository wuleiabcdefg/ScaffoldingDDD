package ddd.common;

import base.exception.code.ExceptionCode;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode
public class AppResponseDTO {

    /**
     * 业务请求是否成功
     */
    private Boolean success;
    /**
     * 错误码
     */
    private String errCode;

    /**
     * 描述
     */
    private String message;

    /**
     * 异常类别 参考 {@link AppErrorType}
     */
    private String errorType;

    /**
     * 响应数据
     */
    private Object data;

    /**
     * 不可删除， jackson反序列化转JSON时使用
     */
    @SuppressWarnings("unused")
    public AppResponseDTO() {
        this(Boolean.FALSE);
    }

    private AppResponseDTO(Boolean success) {
        if (success==null) {
            throw new NullPointerException("success is null");
        }
        this.setSuccess(success);
    }

    /**
     * 成功默认成功状态，有业务数据
     *
     * @param data 业务数据可以是List、Entity等数据
     * @return 正确结果
     */
    public static AppResponseDTO ok(Object data) {
        AppResponseDTO tAppResponseDTO = new AppResponseDTO(Boolean.TRUE);
        tAppResponseDTO.setData(data);
        return tAppResponseDTO;
    }

    /**
     * 返回默认成功的状态信息，无业务数据
     *
     * @return 正确结果
     */
    public static AppResponseDTO ok() {
        return ok(null);
    }

    public static AppResponseDTO error(AppErrorType errorType, ExceptionCode exceptionCode) {
        AppResponseDTO tAppResponseDTO = new AppResponseDTO(Boolean.FALSE);
        tAppResponseDTO.setErrorType(errorType.getErrorType());
        tAppResponseDTO.setMessage(exceptionCode.getMessage());
        tAppResponseDTO.setErrCode(exceptionCode.getCode());
        return tAppResponseDTO;
    }
}
