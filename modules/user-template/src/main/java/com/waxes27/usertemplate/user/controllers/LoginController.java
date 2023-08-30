package com.waxes27.usertemplate.user.controllers;


import com.waxes27.usertemplate.user.models.User;
import com.waxes27.usertemplate.user.models.enums.Role;
import com.waxes27.usertemplate.user.requests.UserRegistrationRequest;
import com.waxes27.usertemplate.user.security.PasswordEncoder;
import com.waxes27.usertemplate.user.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LoginController {
    private AuthenticationManager authenticationManager;
    private UserService userService;
    PasswordEncoder passwordEncoder = new PasswordEncoder();
//    private final RestTemplate restTemplate;


    @PostMapping(path = "/login")
    public Object login(
            @RequestParam("username") String username,
            @RequestParam("password") String password
    ){

        JSONObject jsonObject = new JSONObject();
        System.out.println(username +" : "+password);


        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            username,password));
            System.out.println(authentication.isAuthenticated());
            SecurityContextHolder.getContext().setAuthentication(authentication);

            return authentication.getPrincipal();

        }catch (Exception e){
            return e.getMessage();
        }
    }

    @PostMapping(path = "/register")
    public User registerUser(@RequestBody UserRegistrationRequest userRegistrationRequest) throws IllegalAccessException {
        User user = new User(
                userRegistrationRequest.username(),
                userRegistrationRequest.password(),
                Role.USER
        );

        user = userService.createNewUser(user);

        return user;
    }

}