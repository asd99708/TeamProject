package com.wedogo.domain.login;


import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LoginRepository extends JpaRepository<LoginForm, String> {
    Optional<LoginForm> findByUserid(String userid);
}
