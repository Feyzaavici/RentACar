package kodlama.io.rentACar.business.rules;

import kodlama.io.rentACar.core.exceptions.BusinessException;
import kodlama.io.rentACar.dataAccess.abstructs.UserRepository;

public class UserBusinessRules {

    UserRepository userRepository;

    public UserBusinessRules( UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public void checkIfEmailNotExists(String email){
       if( !userRepository.existsByEmail(email)){
           throw new BusinessException("Email not found ");
       }
    }

    public void checkIfEmailAlreadyExists(String email){
        if(userRepository.existsByEmail(email)){
            throw new BusinessException("Email already exists");
        }
    }
}
