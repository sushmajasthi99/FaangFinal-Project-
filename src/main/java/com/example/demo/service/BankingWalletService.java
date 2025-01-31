package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.BankingWalletRepo;

@Service
public class BankingWalletService {
	
	@Autowired
	BankingWalletRepo bwr;

}
