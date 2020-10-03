package com.boot.configuration;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class CommonBeanConfig {
    @Bean
    public StrongPasswordEncryptor strongEncryptor() {
        StrongPasswordEncryptor encryptor = new StrongPasswordEncryptor();
        return encryptor;
    }
}