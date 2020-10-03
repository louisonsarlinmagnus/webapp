package com.boot.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entities.Role;
import com.boot.repositories.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> listAll() {
    	List<Role> roles = StreamSupport.stream(roleRepository.findAll().spliterator(), false).collect(Collectors.toList());
        return roles;
    }

    @Override
    public Role getById(Integer id) {
        return roleRepository.findById(id).get();
    }

    public Role saveOrUpdate(Role domainObject) {
        return roleRepository.save(domainObject);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
    	roleRepository.deleteById(id);
    }

}