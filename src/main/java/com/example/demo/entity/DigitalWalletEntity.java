package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class DigitalWalletEntity {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	String walletEntity ;//we
	Double balance;
	
	public long getId() {
		return id;
	}
	public String getWalletEntity() {
		return walletEntity;
	}
	public void setWalletEntity(String walletEntity) {
		this.walletEntity = walletEntity;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public void setId(long id) {
		this.id = id;
	}		
}
