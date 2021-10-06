package pl.gren.advevethesis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.gren.advevethesis.dto.LoginRequest;
import pl.gren.advevethesis.dto.RegisterRequest;
import pl.gren.advevethesis.service.AuthService;
import javax.validation.constraints.NotBlank;


@RestController
@CrossOrigin( origins = "*", maxAge = 3600)
@RequestMapping("/api/auth")
public class AuthController {

    private static final Logger logger  = LoggerFactory.getLogger(pl.gren.advevethesis.controller.AuthorController.class);


    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody @NotBlank RegisterRequest registerRequest) {
        authService.signup(registerRequest);
        if(registerRequest.getEmail() == null)
        {
//            logger.warn("Mail jest pusty!");
        }
        if(registerRequest.getPassword() == null)
        {
//            logger.warn("Mail jest pusty!");
        }
        if(registerRequest.getUsername() == null)
        {
//            logger.warn("Mail jest pusty!");
        }

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/hello")
    public String sayHello(@RequestParam(name = "name", defaultValue = "World") String name)
    {
        return String.format("Hello, %s", name);
    }

    @PostMapping("/login")
    public void login(@RequestBody LoginRequest loginRequest) throws Exception {
        authService.login(loginRequest);

    }


}




