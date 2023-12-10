package ddd.adapter.service.http;

import ddd.ApplicationRunner;
import ddd.adapter.service.http.interceptor.GlobalExceptionHandler;
import ddd.adapter.service.http.interceptor.ResponseBodyHandler;
import ddd.auth.code.AppExceptionCodeEnum;
import ddd.auth.usecase.LoginUseCase;
import ddd.auth.usecase.ShowPersonalInfoUseCase;
import ddd.common.AppErrorType;
import ddd.common.AppResponseDTO;
import ddd.utils.JsonUtil;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.nio.charset.StandardCharsets;


//增加junit5 spring 的注解
@SpringBootTest(classes = ApplicationRunner.class)

class WelcomeControllerTest {

    @Autowired
    private WelcomeController welcomeController;

    @Test
    void testLogin() {
        MockMvc mockMvc = getBuild(welcomeController);

        LoginUseCase.Request request = new LoginUseCase.Request();
        request.setUserName("zhangsan");
        request.setPassword("123456");

        sendRequestExceptSuccess(mockMvc, "/welcome/login", request, null);
    }

    private MockMvc getBuild(WelcomeController welcomeController) {
        return MockMvcBuilders.standaloneSetup(welcomeController)
                .setControllerAdvice(new ResponseBodyHandler(), new GlobalExceptionHandler())
                .build();
    }

    @Test
    void testShowPersonalInfo() {
        MockMvc mockMvc = getBuild(welcomeController);


        testShowPersonalInfoCase1(mockMvc);

        testShowPersonalInfoCase2(mockMvc);

    }

    /** 场景2： 查不到用户
     * @param mockMvc mockMvc
     */
    void testShowPersonalInfoCase2(MockMvc mockMvc) {
        ShowPersonalInfoUseCase.Request request = new ShowPersonalInfoUseCase.Request();
        request.setUserId("wangwu");
        AppResponseDTO<ShowPersonalInfoUseCase.Response> responseFailedDTO = sendRequestExceptFailure(mockMvc, "/welcome/showPersonalInfo", request, ShowPersonalInfoUseCase.Response.class);
        Assertions.assertEquals(AppErrorType.BUSINESS_ERROR.getErrorType(), responseFailedDTO.getErrorType());
        Assertions.assertEquals(responseFailedDTO.getErrCode(),
                AppExceptionCodeEnum.USER_NOT_FOUND.getCode());
}

    /** 场景1： 正常查询
     * @param mockMvc  mockMvc
     */
    private void testShowPersonalInfoCase1(MockMvc mockMvc) {
        ShowPersonalInfoUseCase.Request request = new ShowPersonalInfoUseCase.Request();
        request.setUserId("zhangsan");

        ShowPersonalInfoUseCase.Response mockResult = new ShowPersonalInfoUseCase.Response();
        mockResult.setUserId("zhangsan");
        mockResult.setUserName("张三");
        AppResponseDTO<ShowPersonalInfoUseCase.Response> appResponseDTO = AppResponseDTO.ok(mockResult);
        AppResponseDTO<ShowPersonalInfoUseCase.Response> responseAppResponseDTO = sendRequestExceptSuccess(mockMvc, "/welcome/showPersonalInfo", request, ShowPersonalInfoUseCase.Response.class);

        Assertions.assertEquals(JsonUtil.toJson(responseAppResponseDTO.getData()), JsonUtil.toJson(appResponseDTO.getData()));
    }

    private static <T> AppResponseDTO<T> sendRequestExceptSuccess(MockMvc mockMvc, String path, Object params, Class<T> responseClass) {
        AppResponseDTO<T> tAppResponseDTO = sendRequest(mockMvc, path, params, responseClass);
        Assertions.assertTrue(tAppResponseDTO.getSuccess());
        return tAppResponseDTO;
    }
    private static <T> AppResponseDTO<T> sendRequestExceptFailure(MockMvc mockMvc, String path, Object params, Class<T> responseClass) {
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
