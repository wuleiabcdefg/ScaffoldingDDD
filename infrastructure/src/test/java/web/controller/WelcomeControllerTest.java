package web.controller;

import ddd.common.AppResponseDTO;
import ddd.auth.usecasea.LoginUseCase;
import ddd.utils.JsonUtil;
import ddd.web.WebServerStarter;
import ddd.web.controller.WelcomeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

//增加junit5 spring 的注解
@SpringBootTest(classes = WebServerStarter.class)
class WelcomeControllerTest {

    private MockMvc mockMvc;
    @Autowired
    private WelcomeController welcomeController;



    @Test
    void testLogin() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(welcomeController).build();

        LoginUseCase.Request request = new LoginUseCase.Request();
        request.setUserName("zhangsan");
        request.setPassword("123456");

        AppResponseDTO<Void> appResponseDTO = AppResponseDTO.ok();

        mockMvc.perform(MockMvcRequestBuilders.post("/welcome/login")
                .content(JsonUtil.toJson(request))
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(JsonUtil.toJson(appResponseDTO)));
    }

}
