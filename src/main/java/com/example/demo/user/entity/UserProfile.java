package com.example.demo.user.entity;

import com.example.demo.audit.Auditable;
import com.example.demo.user.dto.UserAccountDto;
import com.example.demo.user.dto.UserProfileDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Table(name = "USER_PROFILE")
@Entity
@Data
public class UserProfile extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL, orphanRemoval = true)
    private UserCredential userCredential;

    private String name;

    private String email;

    private String phone;


    public void mapToEntity(UserProfileDto userProfileDto) {
        this.setId(userProfileDto.getId());
        this.setEmail(userProfileDto.getEmail());
        this.setName(userProfileDto.getName());
        this.setPhone(userProfileDto.getPhone());
    };

    public void mapToEntity(UserAccountDto userAccountDto) {
        this.setEmail(userAccountDto.getEmail());
        this.setName(userAccountDto.getName());
        this.setPhone(userAccountDto.getPhone());
    };
}
