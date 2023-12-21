package ddd.service.http;

import ddd.services.WelcomeAppService;
import ddd.usecase.LoginUseCase;
import ddd.usecase.ShowPersonalInfoUseCase;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Setter(onMethod = @__(@Autowired))
@RestController
public class WelcomeController {

    private WelcomeAppService welcomeAppService;

    @RequestMapping("/welcome/login")
    public void login(@RequestBody LoginUseCase.Request loginRequest) {
        welcomeAppService.login(loginRequest);
    }

    @RequestMapping("/welcome/showPersonalInfo")
    public ShowPersonalInfoUseCase.Response showPersonalInfo(@RequestBody ShowPersonalInfoUseCase.Request request) {
        return welcomeAppService.showPersonalInfo(request);
    }
}
