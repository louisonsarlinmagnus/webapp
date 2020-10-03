package com.boot.service.security;

public interface EncryptionService {
    String encryptString(String password);
    boolean checkPassword(String plainPassword, String encryptedPassword);
}