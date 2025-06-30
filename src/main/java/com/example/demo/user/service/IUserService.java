package com.example.demo.user.service;

import com.example.demo.user.dto.UserAccountDto;
import com.example.demo.user.dto.UserCredentialDto;
import com.example.demo.user.dto.UserProfileDto;

public interface IUserService {

    String sayHello();

    Boolean login(UserCredentialDto userCredentialDto);

    UserProfileDto getUserById(String id);

    Boolean createUserAccount(UserAccountDto userAccountDto) throws Exception;

    UserProfileDto updateUserProfile(UserProfileDto userProfileDto) throws Exception;
}
