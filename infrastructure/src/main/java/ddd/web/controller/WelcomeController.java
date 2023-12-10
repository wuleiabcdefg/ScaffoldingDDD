package ddd.web.controller;

import ddd.common.AppResponseDTO;
import ddd.auth.services.WelcomeAppService;
import ddd.auth.usecasea.LoginUseCase;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    private WelcomeAppService indexAppServer;

    @Resource
    public void setIndexAppServer(WelcomeAppService indexAppServer) {
        this.indexAppServer = indexAppServer;
    }

    @RequestMapping("/welcome/login")
    public AppResponseDTO<Void> login(@RequestBody LoginUseCase.Request loginRequest) {
        return indexAppServer.login(loginRequest);
    }
}
