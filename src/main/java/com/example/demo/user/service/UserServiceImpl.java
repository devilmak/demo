package com.example.demo.user.service;

import com.example.demo.user.dto.UserAccountDto;
import com.example.demo.user.dto.UserCredentialDto;
import com.example.demo.user.dto.UserProfileDto;
import com.example.demo.user.entity.UserCredential;
import com.example.demo.user.entity.UserProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.user.repository.UserCredentialRepository;
import com.example.demo.user.repository.UserProfileRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserCredentialRepository userCredentialRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private UserCredential getUserCredById(String id) {
        return userCredentialRepository.getReferenceById(id);
    }

    private UserProfile getUserProfileById(String id) {
        return userProfileRepository.getReferenceById(id);
    }

    @Override
    public String sayHello() {
        return "hello World";
    }

    @Override
    public Boolean login(UserCredentialDto userCredentialDto) {

        if (userCredentialDto == null || userCredentialDto.getUsername() == null || userCredentialDto.getPassword() == null) {
            throw new ResourceNotFoundException("Missing username or password");
        }
        UserProfile userProfile = null;
        if (userCredentialDto.getUsername().contains("@")) {
            userProfile = userProfileRepository.findByEmail(userCredentialDto.getUsername());
        } else if (StringUtils.isNumeric(userCredentialDto.getUsername())) {
            userProfile = userProfileRepository.findByPhone(userCredentialDto.getUsername());
        }
        if (userProfile == null) {
            throw new ResourceNotFoundException("No such user");
        } else {
            String savedPassword = userProfile.getUserCredential().getPassword();
            if (Objects.equals(userCredentialDto.getPassword(), savedPassword)) {
                return true;
            } else {
                throw new ResourceNotFoundException("Incorrect password");
            }
        }
    }


    @Override
    public UserProfileDto getUserById(String id) {
        UserProfile userProfile = getUserProfileById(id);
        UserProfileDto userProfileDto = new UserProfileDto();
        userProfileDto.mapToDto(userProfile);

        return userProfileDto;
    }


    @Override
    public Boolean createUserAccount(UserAccountDto userAccountDto) {
        UserCredential userCredential = new UserCredential();
        userCredential.setUsername(userAccountDto.getEmail());
        userCredential.setPassword(passwordEncoder.encode(userAccountDto.getPassword()));

        UserProfile userProfile = new UserProfile();
        userProfile.mapToEntity(userAccountDto);

        // One-to-One relationship
        userProfile.setUserCredential(userCredential);
        userCredential.setUserProfile(userProfile);

        UserProfile persisted = userProfileRepository.save(userProfile);
        System.out.println("Version after save: " + persisted.getVersion());

        return true;
    }

    @Override
    public UserProfileDto updateUserProfile(UserProfileDto userProfileDto) throws Exception {
        UserProfile userprofile = userProfileRepository.getReferenceById(userProfileDto.getId());
        userprofile.mapToEntity(userProfileDto);

        return userProfileDto;
    }
}
