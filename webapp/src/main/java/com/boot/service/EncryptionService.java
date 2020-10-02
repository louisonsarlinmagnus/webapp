package com.boot.service;

public interface EncryptionService extends CRUDService{

	String encryptString(String password);

}
