package kodlama.io.rentACar.business.abstructs;

import kodlama.io.rentACar.business.requests.CreateLoginRequest;
import kodlama.io.rentACar.business.requests.CreateRegisterRequest;
import kodlama.io.rentACar.business.responses.AuthResponse;

public interface AuthService {

    void register(CreateRegisterRequest createRegisterRequest);
    AuthResponse login(CreateLoginRequest createLoginRequest);

}
