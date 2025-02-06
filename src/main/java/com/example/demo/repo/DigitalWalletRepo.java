package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.DigitalWalletEntity;



@Repository
public interface DigitalWalletRepo extends JpaRepository<DigitalWalletEntity, Long>{
}
