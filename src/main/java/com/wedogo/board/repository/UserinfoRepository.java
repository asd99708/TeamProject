package com.wedogo.board.repository;


import com.wedogo.board.entity.Userinfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserinfoRepository extends JpaRepository<Userinfo, String> {
}