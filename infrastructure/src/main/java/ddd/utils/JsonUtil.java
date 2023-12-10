package ddd.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JsonUtil {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static String toJson(Object request) {
        return MAPPER.writeValueAsString(request);
    }
    @SneakyThrows
    public static <T> T fromJson(String json, Class<T> clazz) {
        return MAPPER.readValue(json, clazz);
    }

}
