package com.example.demo.user.repository;

import com.example.demo.user.entity.UserProfile;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, String> {

    UserProfile getReferenceById(String id);

    UserProfile findByEmail(String email);

    UserProfile findByPhone(String phone);
}
