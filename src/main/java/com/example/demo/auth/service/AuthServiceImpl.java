package com.example.demo.auth.service;

import com.example.demo.user.entity.UserCredential;
import com.example.demo.user.repository.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthServiceImpl implements UserDetailsService {

    @Autowired
    private UserCredentialRepository userCredentialRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserCredential userCred = userCredentialRepository.findByUsername(username);
        if (userCred == null) {
            throw new UsernameNotFoundException("Username not found");
        }

        return new User(userCred.getUsername(), userCred.getPassword(), List.of(new SimpleGrantedAuthority("ROLE_USER")));

    }
}
