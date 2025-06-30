package com.example.demo.user.entity;

import com.example.demo.audit.Auditable;
import com.example.demo.user.dto.UserCredentialDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Table(name = "USER_CRED")
@Entity
@Data
public class UserCredential extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @OneToOne
    @JoinColumn(name="user_id", unique = true)
    private UserProfile userProfile;

    private String username;

    private String password;


    public void mapToEntity(UserCredentialDto userCredentialDto) {
        this.setId(userCredentialDto.getId());
        this.setUsername(userCredentialDto.getUsername());
        this.setPassword(userCredentialDto.getPassword());
    };
}
