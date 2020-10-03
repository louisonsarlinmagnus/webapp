package com.boot.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boot.entities.User;
import com.boot.repositories.UserRepository;
import com.boot.service.security.EncryptionService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EncryptionService encryptionService;

    public User saveOrUpdate(User domainObject) {
        if(domainObject.getPassword() != null){
            domainObject.setEncryptedPassword(encryptionService.encryptString(domainObject.getPassword()));
        }
        return userRepository.save(domainObject);
    }
    

    @Override
    public List<User> listAll() {
        List<User> users = StreamSupport.stream(userRepository.findAll().spliterator(), false).collect(Collectors.toList());
        		
        return users;
    }

    public User getById(Integer id) {
        return userRepository.findById(id).get();
    }

    
    @Override
    @Transactional
    public void delete(Integer id) {
    	userRepository.deleteById(id);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}