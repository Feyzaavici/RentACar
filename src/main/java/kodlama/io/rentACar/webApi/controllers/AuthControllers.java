package kodlama.io.rentACar.webApi.controllers;

import kodlama.io.rentACar.business.abstructs.AuthService;
import kodlama.io.rentACar.business.requests.CreateLoginRequest;
import kodlama.io.rentACar.business.requests.CreateRegisterRequest;
import kodlama.io.rentACar.business.responses.AuthResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthControllers {

    AuthService authService;

    public AuthControllers (AuthService authService){
        this.authService=authService;
    }

    @PostMapping("/register")
    public void register(@RequestBody CreateRegisterRequest request) {
        authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody CreateLoginRequest request) {
        return authService.login(request);
    }



}
