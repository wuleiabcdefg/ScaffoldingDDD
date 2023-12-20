package ddd.utils;

import base.exception.ServerInternalRuntimeException;
import base.exception.code.CommonExceptionCodeEnum;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.common.base.Strings;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * 基于Jackson的JSON转换工具类
 *
 * @author ye17186
 * @version 2018/6/29 12:06
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JsonUtil {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {

        // 对象的所有字段全部列入，还是其他的选项，可以忽略null等
        OBJECT_MAPPER.setSerializationInclusion(Include.ALWAYS);
        // 设置Date类型的序列化及反序列化格式
        OBJECT_MAPPER.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

        // 忽略空Bean转json的错误
        OBJECT_MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        // 忽略未知属性，防止json字符串中存在，java对象中不存在对应属性的情况出现错误
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // 注册一个时间序列化及反序列化的处理模块，用于解决jdk8中localDateTime等的序列化问题
        OBJECT_MAPPER.registerModule(new JavaTimeModule());
    }

    /**
     * 对象 => json字符串
     *
     * @param obj 源对象
     */
    public static <T> String toJson(T obj) {

        String json = null;
        if (obj!=null) {
            try {
                json = OBJECT_MAPPER.writeValueAsString(obj);
            } catch (JsonProcessingException e) {
                log.warn(e.getMessage(), e);
                throw new ServerInternalRuntimeException(CommonExceptionCodeEnum.OBJECT_TO_JSON_ERROR, e);
            }
        }
        return json;
    }

    /**
     * json字符串 => 对象
     *
     * @param json  源json串
     * @param clazz 对象类
     * @param <T>   泛型
     */
    public static <T> T fromJson(String json, Class<T> clazz) {
        T obj = null;
        if (!Strings.isNullOrEmpty(json) && clazz!=null) {
            try {
                obj = OBJECT_MAPPER.readValue(json, clazz);
            } catch (IOException e) {
                log.warn(e.getMessage(), e);
                throw new ServerInternalRuntimeException(CommonExceptionCodeEnum.JSON_TO_OBJECT_ERROR, e);
            }
        }
        return obj;
    }

    /**
     * json字符串 => 对象
     *
     * @param json             源json串
     * @param parametrized     对象类型
     * @param parameterClasses 泛型
     */
    // 新增方法，使用反射获取泛型类型
    public static <T> T fromJson(String json, Class<?> parametrized, Class<?>... parameterClasses)
            throws JsonProcessingException {
        JavaType type = OBJECT_MAPPER.getTypeFactory().constructParametricType(parametrized, parameterClasses);
        return OBJECT_MAPPER.readValue(json, type);
    }

}