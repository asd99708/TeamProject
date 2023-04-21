package com.wedogo.hotel.repository;


import com.wedogo.hotel.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemEntity, String> {

  //  Optional<ItemEntity> findByid(Long id);
}
