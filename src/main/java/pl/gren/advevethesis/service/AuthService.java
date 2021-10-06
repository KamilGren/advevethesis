package pl.gren.advevethesis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.gren.advevethesis.dto.LoginRequest;
import pl.gren.advevethesis.dto.RegisterRequest;
import pl.gren.advevethesis.model.User;
import pl.gren.advevethesis.repository.UserRepository;


import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private TokenProvider jwtProvider;

    public void signup(RegisterRequest registerRequest) {
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(registerRequest.getPassword());

        userRepository.save(user);
    }

//    private String encodePassword(String password) {
//        return passwordEncoder.encode(password);
//    }

    public void login(LoginRequest loginRequest) {

//        try {
//            Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
//                    loginRequest.getPassword()));
//            SecurityContextHolder.getContext().setAuthentication(authenticate);
//            String authenticationToken = jwtProvider.generateToken(authenticate);
//
//            return new AuthenticationResponse(authenticationToken, loginRequest.getUsername());
//        }
//        catch (BadCredentialsException e) {
//            throw new Exception("Incorrect username or password", e);
//
//        }
    }


    //final UserDetails userDetails = userDetailsService.loadUserByUserName()

    public Optional<org.springframework.security.core.userdetails.User> getCurrentUser() {
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) SecurityContextHolder.
                getContext().getAuthentication().getPrincipal();
        return Optional.of(principal);
    }
}
