package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class BankingWalletEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long userId;
	String accNo;
	Double balance;
	Double amount;
	public BankingWalletEntity(Long userId, String accNo, Double balance, Double amount) {
		super();
		this.userId = userId;
		this.accNo = accNo;
		this.balance = balance;
		this.amount = amount;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
}
