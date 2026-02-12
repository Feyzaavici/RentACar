package kodlama.io.rentACar.business.abstructs;

import kodlama.io.rentACar.business.requests.CreateLoginRequest;
import kodlama.io.rentACar.business.requests.CreateRegisterRequest;

public interface AuthService {

    void register(CreateRegisterRequest createRegisterRequest);
    void login(CreateLoginRequest createLoginRequest);

}
