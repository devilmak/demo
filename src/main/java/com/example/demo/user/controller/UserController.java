package com.example.demo.user.controller;

import com.example.demo.config.ApiResponse;
import com.example.demo.user.dto.UserAccountDto;
import com.example.demo.user.dto.UserCredentialDto;
import com.example.demo.util.ResponseUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.user.service.IUserService;


@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private IUserService userService;

    // login handled by AuthController
//    @PostMapping("/login")
//    public ResponseEntity<ApiResponse<Boolean>> login(@RequestBody UserCredentialDto userCredentialDto, HttpServletRequest request) {
//        return ResponseEntity.ok(ResponseUtil.success(userService.login(userCredentialDto), "", request.getRequestURI()));
//    }

    @PostMapping("/create-user-account")
    public ResponseEntity<ApiResponse<Boolean>> createUserAccount(@RequestBody UserAccountDto userAccountDto, HttpServletRequest request) throws Exception {
        return ResponseEntity.ok(ResponseUtil.success(userService.createUserAccount(userAccountDto), "", request.getRequestURI()));
    }

//    @GetMapping("/hello")
//    public String sayHello() {
//        return userService.sayHello();
//    }
}
