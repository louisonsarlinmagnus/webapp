package com.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boot.entities.User;
import com.boot.repositories.UserRepository;
import com.boot.service.EncryptionService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EncryptionService encryptionService;


    @Override
    public List<User> listAll() {
        ...
        return users;
    }

    public User getById(Integer id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User saveOrUpdate(User domainObject) {
        if(domainObject.getPassword() != null){
            domainObject.setEncryptedPassword(encryptionService.encryptString(domainObject.getPassword()));
        }
        return ...
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

	@Override
	public Object saveOrUpdate(Object domainObject) {
		// TODO Auto-generated method stub
		return null;
	}
}