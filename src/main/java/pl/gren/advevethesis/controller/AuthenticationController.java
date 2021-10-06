//package pl.gren.adveve.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.*;
//import pl.gren.adveve.dto.LoginRequest;
//
//import javax.naming.AuthenticationException;
//
//@CrossOrigin(origins = "*", maxAge = 3600)
//@RestController
//@RequestMapping("/token")
//public class AuthenticationController {
//
//@Autowired
//private AuthenticationManager authenticationManager;
//
//@Autowired
//private TokenProvider jwtTokenUtil;
//
//@RequestMapping(value = "/generate-token", method = RequestMethod.POST)
//public ResponseEntity register(@RequestBody LoginRequest loginRequest) throws AuthenticationException {
//
//final Authentication authentication = authenticationManager.authenticate(
//        new UsernamePasswordAuthenticationToken(
//        loginRequest.getUsername(),
//        loginRequest.getPassword()
//        )
//        );
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//final String token = jwtTokenUtil.generateToken(authentication);
//        return ResponseEntity.ok(new AuthToken(token));
//        }
//
//        }