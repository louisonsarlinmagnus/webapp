package com.boot.service.security;

import org.jasypt.util.password.PasswordEncryptor;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.stereotype.Service;

@Service
public class EncryptionServiceImpl implements EncryptionService{
	
	
	PasswordEncryptor pe = new StrongPasswordEncryptor();

	@Override
	public String encryptString(String password) {
		return pe.encryptPassword(password);
	}

	@Override
	public boolean checkPassword(String plainPassword, String encryptedPassword) {
		if (pe.checkPassword(plainPassword, encryptedPassword)) {
			return true;
		}
		else {
			return false;
		}
	}

}
