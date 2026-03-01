package kodlama.io.retACar.business.concretes;

import kodlama.io.rentACar.business.concretes.AuthManager;
import kodlama.io.rentACar.business.requests.CreateLoginRequest;
import kodlama.io.rentACar.business.requests.CreateRegisterRequest;
import kodlama.io.rentACar.business.responses.AuthResponse;
import kodlama.io.rentACar.business.rules.UserBusinessRules;
import kodlama.io.rentACar.core.security.jwt.JwtService;
import kodlama.io.rentACar.dataAccess.abstructs.UserRepository;
import kodlama.io.rentACar.entities.concretes.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("AuthManager Unit Tests")
public class AuthManagerTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private UserBusinessRules userBusinessRules;
    @Mock
     private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Mock
    private JwtService jwtService;

    @InjectMocks
    private AuthManager authManager;
    private CreateRegisterRequest createRegisterRequest;
    private User user;
    private CreateLoginRequest createLoginRequest;


    @Nested
    @DisplayName("Create Register Tests")
    class CreateRegisterTests{


        @BeforeEach
        void setUp() {
            createRegisterRequest= new CreateRegisterRequest("Feyza","Avci",
                    "feyza@gmail.com","123");

        }

        @Test
        @DisplayName("Should register user successfully when email is not already taken")
        void registerSuccess(){

            when(bCryptPasswordEncoder.encode(anyString())).thenReturn("hashed_password");

            authManager.register(createRegisterRequest);

            verify(userBusinessRules, times(1)).checkIfEmailAlreadyExists("feyza@gmail.com");

            verify(bCryptPasswordEncoder, times(1)).encode("123");

            verify(userRepository, times(1)).save(any(User.class));
        }


    }

    @Nested
    @DisplayName("Create Login Tests")
    class CreateLoginTests{

        @BeforeEach
        void setUp(){
            createLoginRequest = new CreateLoginRequest("feyza@gmail.com", "123");

            user = new User();
            user.setId(1);
            user.setEmail("feyza@gmail.com");
            user.setPassword("encoded_password");

        }

        @Test
        @DisplayName("Should return token when email exists and password is correct")
        void loginSuccess(){

            when(userRepository.findByEmail("feyza@gmail.com")).thenReturn(user);

            when(bCryptPasswordEncoder.matches("123", user.getPassword())).thenReturn(true);

            when(userRepository.findClaimsByUserId(user.getId())).thenReturn(List.of("ROLE_USER"));

            when(jwtService.generateToken(anyString(), anyList())).thenReturn("mocked_token");

            AuthResponse response = authManager.login(createLoginRequest);

            assertNotNull(response);
            assertEquals("mocked_token", response.getToken());

            verify(userBusinessRules, times(1))
                    .checkIfEmailNotExists("feyza@gmail.com");

            verify(userRepository, times(1))
                    .findByEmail("feyza@gmail.com");

            verify(jwtService, times(1))
                    .generateToken(anyString(), anyList());



        }


    }





}
