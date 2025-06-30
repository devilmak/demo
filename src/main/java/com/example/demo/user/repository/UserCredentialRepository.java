package com.example.demo.user.repository;

import com.example.demo.user.entity.UserCredential;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface UserCredentialRepository extends JpaRepository<UserCredential, String> {

    UserCredential getReferenceById(String id);

    UserCredential findByUsername(String username);
}
