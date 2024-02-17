package ddd.service.http;

//  写一个springboot controller测试类


import ddd.ApplicationRunner;
import ddd.usecase.LoginUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest(classes = ApplicationRunner.class)
@ExtendWith(SpringExtension.class)
class WelcomeControllerTest {


    MockMvc mockMvc;

    WebApplicationContext webApplicationContext;

    // 实例化mockMvc

    @Autowired
    private WelcomeController welcomeController;

    @Test
    void login() {
        final LoginUseCase.Request req = new LoginUseCase.Request();
        req.setPassword("sda");
        req.setUserName("dsad");
        welcomeController.login(req);
    }

    @Test
    void showPersonalInfo() {
    }

    @Test
    void setWelcomeAppService() {
    }
}