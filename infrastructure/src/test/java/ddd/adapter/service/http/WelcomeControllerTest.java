package ddd.adapter.service.http;

import ddd.ApplicationRunner;
import ddd.adapter.service.http.interceptor.GlobalExceptionHandler;
import ddd.adapter.service.http.interceptor.ResponseBodyHandler;
import ddd.code.AppExceptionCodeEnum;
import ddd.common.AppErrorType;
import ddd.common.AppResponseDTO;
import ddd.usecase.LoginUseCase;
import ddd.usecase.ShowPersonalInfoUseCase;
import ddd.utils.HttpSendUtil;
import ddd.utils.JsonUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


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

        HttpSendUtil.sendRequestExceptSuccess(mockMvc, "/welcome/login", request, null);
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

    /**
     * 场景2： 查不到用户
     *
     * @param mockMvc mockMvc
     */
    void testShowPersonalInfoCase2(MockMvc mockMvc) {
        ShowPersonalInfoUseCase.Request request = new ShowPersonalInfoUseCase.Request();
        request.setUserId("wangwu");
        AppResponseDTO<ShowPersonalInfoUseCase.Response> responseFailedDTO = HttpSendUtil.sendRequestExceptFailure(mockMvc, "/welcome/showPersonalInfo", request, ShowPersonalInfoUseCase.Response.class);
        Assertions.assertEquals(AppErrorType.BUSINESS_ERROR.getErrorType(), responseFailedDTO.getErrorType());
        Assertions.assertEquals(responseFailedDTO.getErrCode(),
                AppExceptionCodeEnum.USER_NOT_FOUND.getCode());
    }

    /**
     * 场景1： 正常查询
     *
     * @param mockMvc mockMvc
     */
    private void testShowPersonalInfoCase1(MockMvc mockMvc) {
        ShowPersonalInfoUseCase.Request request = new ShowPersonalInfoUseCase.Request();
        request.setUserId("zhangsan");

        ShowPersonalInfoUseCase.Response mockResult = new ShowPersonalInfoUseCase.Response();
        mockResult.setUserId("zhangsan");
        mockResult.setUserName("张三");
        AppResponseDTO<ShowPersonalInfoUseCase.Response> appResponseDTO = AppResponseDTO.ok(mockResult);
        AppResponseDTO<ShowPersonalInfoUseCase.Response> responseAppResponseDTO = HttpSendUtil.sendRequestExceptSuccess(mockMvc, "/welcome/showPersonalInfo", request, ShowPersonalInfoUseCase.Response.class);

        Assertions.assertEquals(JsonUtil.toJson(responseAppResponseDTO.getData()), JsonUtil.toJson(appResponseDTO.getData()));
    }


}
