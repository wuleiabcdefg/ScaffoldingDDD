package ddd.web.controller;

import ddd.auth.services.WelcomeAppService;
import ddd.auth.usecase.LoginUseCase;
import ddd.common.AppResponseDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    private WelcomeAppService indexAppServer;

    public void setIndexAppServer(WelcomeAppService indexAppServer) {
        this.indexAppServer = indexAppServer;
    }

    @RequestMapping("/welcome/login")
    public AppResponseDTO<Void> login(@RequestBody LoginUseCase.Request loginRequest) {
        return indexAppServer.login(loginRequest);
    }
}
