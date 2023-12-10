package ddd.utils;

import ddd.common.AppResponseDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.StandardCharsets;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HttpSendUtil {
    public static <T> AppResponseDTO<T> sendRequestExceptSuccess(MockMvc mockMvc, String path, Object params, Class<T> responseClass) {
        AppResponseDTO<T> tAppResponseDTO = sendRequest(mockMvc, path, params, responseClass);
        Assertions.assertTrue(tAppResponseDTO.getSuccess());
        return tAppResponseDTO;
    }

    public static <T> AppResponseDTO<T> sendRequestExceptFailure(MockMvc mockMvc, String path, Object params, Class<T> responseClass) {
        AppResponseDTO<T> tAppResponseDTO = sendRequest(mockMvc, path, params, responseClass);
        Assertions.assertFalse(tAppResponseDTO.getSuccess());
        return tAppResponseDTO;
    }

    @SneakyThrows
    @SuppressWarnings("unchecked")
    private static <T> AppResponseDTO<T> sendRequest(MockMvc mockMvc, String path, Object request, Class<T> responseDataClass) {
        ResultActions perform = mockMvc.
                perform(MockMvcRequestBuilders.post(path)
                        .content(JsonUtil.toJson(request))
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
        ResultActions resultActions = perform.andDo(MockMvcResultHandlers.print());
        String contentAsString = resultActions.andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);
        if (responseDataClass == null) {
            return JsonUtil.fromJson(contentAsString, AppResponseDTO.class);
        }
        return JsonUtil.fromJson(contentAsString, AppResponseDTO.class, responseDataClass);
    }
}
