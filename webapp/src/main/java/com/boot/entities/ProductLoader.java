package com.boot.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.boot.repositories.ProductRepository;

@Component
public class ProductLoader implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	private ProductRepository productRepo;
	
	//@Autowired
	//private ProductService ps;
	

	public void onApplicationEvent(ContextRefreshedEvent event) {
		productRepo.save(new Product("0001", "Ce sont des chaussures", "https://www.cdiscount.com/pdt2/0/4/5/1/550x550/mp08060045/rw/richelieu-homme-lacet-chaussure-cuir.jpg", 177.12f));
		//ps.saveProduct(new Product("0002", "Ce sont des sandales", "https://contents.mediadecathlon.com/p751995/k$dcd4215b0e70d78bcd9b6fbad2bb139d/sq/Sandales+de+randonn+e+NH100+Homme.jpg", 14.3f));
		
				
	}
	
}