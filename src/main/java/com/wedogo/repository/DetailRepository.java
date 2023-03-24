package com.wedogo.repository;

import com.wedogo.entity.DetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DetailRepository extends JpaRepository<DetailEntity , Long> {


    Optional<DetailEntity> findByRoomNumber(String roomNumber);

}

