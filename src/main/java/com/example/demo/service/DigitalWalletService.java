package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.DigitalWalletEntity;
import com.example.demo.repo.DigitalWalletRepo;

@Service
public class DigitalWalletService {

    private final DigitalWalletRepo dr;

    @Autowired
    public DigitalWalletService(DigitalWalletRepo dr) {
        this.dr = dr;
    }

    // Add user (wallet)
    public DigitalWalletEntity addUser(DigitalWalletEntity dwe) {
        
        if (dwe.getBalance()==0) {
            dwe.setBalance(0.0);  
        }
        return dr.save(dwe);
    }

    // Get all wallets
    public Iterable<DigitalWalletEntity> getAllUsers() {
        return dr.findAll();
    }

    // Get user by wallet ID
    public Optional<DigitalWalletEntity> getUserById(Long id) {
        return dr.findById(id);
    }

    // Transfer money (method is not implemented in this version)
    public String transfer(Long walletId, Long recipientWalletId, Double amount) {
        return null;
    }

    public String deposit(Long walletId, Double amount) {
        if (amount == null || amount <= 0) {
            return "Invalid deposit amount!";
        }

        Optional<DigitalWalletEntity> walletOptional = dr.findById(walletId);

        if (walletOptional.isPresent()) {
            DigitalWalletEntity wallet = walletOptional.get();
            
            // Ensure balance is initialized to 0 if it's null
            if (wallet.getBalance() ==0.0) {
                wallet.getBalance(); // Initialize balance to 0 if it's null
            }

            // Perform deposit
            wallet.setBalance(wallet.getBalance() + amount);
            dr.save(wallet); // Save the updated wallet
            return "Deposit successful! New Balance: " + wallet.getBalance();
        }

        return "Wallet not found!";
    }

    public String withdraw(Long walletId, Double amount) {
        if (amount == null || amount <= 0) {
            return "Invalid withdrawal amount!";
        }

        Optional<DigitalWalletEntity> walletOptional = dr.findById(walletId);

        if (walletOptional.isPresent()) {
            DigitalWalletEntity wallet = walletOptional.get();

            // Ensure balance is initialized to 0 if it's null
            if (wallet.getBalance() == 0.0) {
                wallet.getBalance();  // Initialize balance to 0 if it's null
            }

            // Check if balance is sufficient for withdrawal
            if (wallet.getBalance() >= amount) {
                wallet.setBalance(wallet.getBalance() - amount);
                dr.save(wallet);  // Save the updated wallet
                return "Withdrawal successful! New Balance: " + wallet.getBalance();
            } else {
                return "Insufficient balance!";
            }
        }

        return "Wallet not found!";
    }

}
