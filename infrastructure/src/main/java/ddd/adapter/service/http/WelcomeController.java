package ddd.adapter.service.http;

import ddd.auth.services.WelcomeAppService;
import ddd.auth.usecase.LoginUseCase;
import ddd.common.AppResponseDTO;
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
    public AppResponseDTO<Void> login(@RequestBody LoginUseCase.Request loginRequest) {
        return welcomeAppService.login(loginRequest);
    }
}
