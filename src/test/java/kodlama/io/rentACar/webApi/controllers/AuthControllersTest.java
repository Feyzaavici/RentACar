package kodlama.io.rentACar.webApi.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import kodlama.io.rentACar.business.abstructs.AuthService;
import kodlama.io.rentACar.business.requests.CreateLoginRequest;
import kodlama.io.rentACar.business.requests.CreateRegisterRequest;
import kodlama.io.rentACar.business.responses.AuthResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AuthControllers.class)
@DisplayName("AuthControllers Web Layer Tests")
@AutoConfigureMockMvc(addFilters = false)
class AuthControllersTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private AuthService authService;

    @Test
    @DisplayName("POST /auth/register should return 200 OK")
    void registerSuccess() throws Exception {

        CreateRegisterRequest createRegisterRequest = new CreateRegisterRequest(
                "Feyza",
                "Avci",
                "feyza@gmail.com",
                "123"
        );

        mockMvc.perform(post("/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createRegisterRequest)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("POST /auth/login should return token when credentials are correct")
    void loginSuccess() throws Exception {

        CreateLoginRequest createLoginRequest =
                new CreateLoginRequest("feyza@gmail.com", "123");

        AuthResponse authResponse = new AuthResponse("mocked_token");

        when(authService.login(any(CreateLoginRequest.class)))
                .thenReturn(authResponse);

        mockMvc.perform(post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createLoginRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").value("mocked_token"));
    }
}



