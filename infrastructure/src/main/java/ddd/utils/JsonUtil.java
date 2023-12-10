package ddd.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import exception.ServerInternalRuntimeException;
import exception.code.CommonExceptionCode;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JsonUtil {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static String toJson(Object request) {
        try {
            return MAPPER.writeValueAsString(request);
        } catch (JsonProcessingException e) {
            throw new ServerInternalRuntimeException(CommonExceptionCode.TO_JSON_STR_ERROR, e);
        }
    }
    @SneakyThrows
    public static <T> T fromJson(String json, Class<T> clazz) {
        return MAPPER.readValue(json, clazz);
    }

}
