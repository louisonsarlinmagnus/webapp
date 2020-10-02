package com.boot.repositories;

import org.springframework.data.repository.CrudRepository;

import com.boot.entities.Product;

public interface RoleRepository extends CrudRepository<Product, Integer>{
	
}