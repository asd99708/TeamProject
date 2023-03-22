package com.wedogo.repository;
import com.wedogo.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true) // (1)
public interface UserInfoRepository extends JpaRepository<Account, Long> { // (2)

    boolean existsByEmail(String email); // (3)

    boolean existsByUserid(String userid); // (4)
}