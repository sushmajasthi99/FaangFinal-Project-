package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.DigitalWalletEntity;
import com.example.demo.service.DigitalWalletService;

@RestController
@RequestMapping("/wallets")
public class DigitalWalletController {

    private final DigitalWalletService walletService;

    public DigitalWalletController(DigitalWalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping("/insert")
    public ResponseEntity<DigitalWalletEntity> createWallet(@RequestBody DigitalWalletEntity wallet) {
        return ResponseEntity.ok(walletService.addUser(wallet));
    }

   
    @GetMapping("/retriveAllWallets")
    public ResponseEntity<Iterable<DigitalWalletEntity>> getAllWallets() {
        return ResponseEntity.ok(walletService.getAllUsers());
    }

  
    @GetMapping("/{walletId}")
    public ResponseEntity<DigitalWalletEntity> getWalletById(@PathVariable Long walletId) {
        Optional<DigitalWalletEntity> wallet = walletService.getUserById(walletId);
        return wallet.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping("/{walletId}/transfer")
    public ResponseEntity<String> transfer(@PathVariable Long walletId,
                                           @RequestParam Long recipientWalletId,
                                           @RequestParam Double amount) {
        return ResponseEntity.ok(walletService.transfer(walletId, recipientWalletId, amount));
    }
}