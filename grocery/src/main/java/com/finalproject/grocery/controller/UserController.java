package com.finalproject.grocery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.finalproject.grocery.dto.ResponseDto;
import com.finalproject.grocery.dto.SignInDto;
import com.finalproject.grocery.dto.SignInResponseDto;
import com.finalproject.grocery.dto.SignupDto;
import com.finalproject.grocery.entity.User;
import com.finalproject.grocery.exceptions.AuthenticationFailException;
import com.finalproject.grocery.exceptions.CustomException;
import com.finalproject.grocery.repository.UserRepository;
import com.finalproject.grocery.service.AuthenticationService;
import com.finalproject.grocery.service.UserService;

import java.util.List;

@RequestMapping("user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    UserService userService;

    @GetMapping("/all")
    public List<User> findAllUser(@RequestParam("token") String token) throws AuthenticationFailException {
        authenticationService.authenticate(token);
        return userRepository.findAll();
    }

    @PostMapping("/signup")
    public ResponseDto Signup(@RequestBody SignupDto signupDto) throws CustomException {
        return userService.signUp(signupDto);
    }

    //TODO token should be updated
    @PostMapping("/signIn")
    public SignInResponseDto Signup(@RequestBody SignInDto signInDto) throws CustomException {
        return userService.signIn(signInDto);
    }
}
