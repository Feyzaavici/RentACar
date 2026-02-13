package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstructs.AuthService;
import kodlama.io.rentACar.business.requests.CreateLoginRequest;
import kodlama.io.rentACar.business.requests.CreateRegisterRequest;
import kodlama.io.rentACar.business.responses.AuthResponse;
import kodlama.io.rentACar.business.rules.UserBusinessRules;
import kodlama.io.rentACar.core.exceptions.BusinessException;
import kodlama.io.rentACar.dataAccess.abstructs.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import kodlama.io.rentACar.entities.concretes.User;
import org.springframework.stereotype.Service;

@Service
public class AuthManager implements AuthService {
    UserRepository userRepository;
    UserBusinessRules userBusinessRules;
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public AuthManager( UserRepository userRepository, UserBusinessRules userBusinessRules, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.userRepository=userRepository;
        this.userBusinessRules=userBusinessRules;
        this.bCryptPasswordEncoder=bCryptPasswordEncoder;
    }

    @Override
    public void register(CreateRegisterRequest createRegisterRequest) {
        String email =createRegisterRequest.getEmail();
        userBusinessRules.checkIfEmailAlreadyExists(email);
        String encodedPassword = bCryptPasswordEncoder.encode(createRegisterRequest.getPassword());
        User user = new User(createRegisterRequest.getFirstName(), createRegisterRequest.getLastName(), email, encodedPassword);
        userRepository.save(user);


    }

    @Override
    public AuthResponse login(CreateLoginRequest createLoginRequest) {
        String email =createLoginRequest.getEmail();
        userBusinessRules.checkIfEmailNotExists(email);
        User user = userRepository.findByEmail(createLoginRequest.getEmail());
        if(!bCryptPasswordEncoder.matches(
                createLoginRequest.getPassword(),
                user.getPassword()
        )){
            throw new BusinessException("Wrong password");
        }

        return new AuthResponse("test-token");

    }
}
