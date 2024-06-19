package ddd.service.http;

import ddd.common.AppResponseDTO;
import ddd.services.WelcomeAppService;
import ddd.usecase.LoginUseCase;
import ddd.usecase.ShowPersonalInfoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @Autowired
    private WelcomeAppService welcomeAppService;

    /* 登录
     * @param loginRequest
     */
    @RequestMapping("/welcome/login")
    public AppResponseDTO login(@RequestBody LoginUseCase.Request loginRequest) {
        final String token = welcomeAppService.login(loginRequest);
        return AppResponseDTO.ok(token);
    }

    @RequestMapping("/welcome/showPersonalInfo")
    public ShowPersonalInfoUseCase.Response showPersonalInfo(@RequestBody ShowPersonalInfoUseCase.Request request) {
        return welcomeAppService.showPersonalInfo(request);
    }
}
