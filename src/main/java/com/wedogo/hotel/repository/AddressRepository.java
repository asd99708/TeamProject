package com.wedogo.hotel.repository;

import com.wedogo.hotel.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AddressRepository extends JpaRepository<Address, String> {
        List<Address> findByAddress(String address);
    }
