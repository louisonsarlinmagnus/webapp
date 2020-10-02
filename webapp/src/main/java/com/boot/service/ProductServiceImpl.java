package com.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entities.Product;
import com.boot.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public Iterable<Product> listAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(Integer id) {
		return productRepository.findById(id).get();
	}

	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public void deleteProduct(Integer id) {
		productRepository.deleteById(id);;
		
		
	}

}
