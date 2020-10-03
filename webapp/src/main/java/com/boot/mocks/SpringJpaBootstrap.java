package com.boot.mocks;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.boot.entities.Product;
import com.boot.entities.Role;
import com.boot.entities.User;
import com.boot.repositories.ProductRepository;
import com.boot.service.RoleService;
import com.boot.service.UserService;

@Component
public class SpringJpaBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
    private ProductRepository productRepository;
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        loadProducts();
        loadUsers();
        loadRoles();
        assignUsersToUserRole();
        assignUsersToAdminRole();
    }

    private void loadProducts() {
        Product shirt = new Product();
        shirt.setDescription(" Chemise Lacouste");
        shirt.setPrice(18.95f);
        shirt.setImageUrl("https://www.vision-naire.com/wp-content/uploads/2016/11/T-SHIRT-V-150x150.jpg");
        shirt.setProductId("235268845711068308");
        productRepository.save(shirt);


        Product pant = new Product();
        pant.setDescription("Pantalon Hugo Boot");
        pant.setPrice(120.9f);
        pant.setImageUrl("https://www.vision-naire.com/wp-content/uploads/2020/06/jogging-visionnaire-2-100x100.jpg");
        pant.setProductId("168639393495335947");
        productRepository.save(pant);

    }

    private void loadUsers() {
        User user1 = new User();
        user1.setUsername("user");
        user1.setPassword("user");
        userService.saveOrUpdate(user1);

        User user2 = new User();
        user2.setUsername("admin");
        user2.setPassword("admin");
        userService.saveOrUpdate(user2);

    }

    private void loadRoles() {
        Role admin = new Role();
        admin.setRole("ADMIN");
        roleService.saveOrUpdate(admin);
        
        Role user = new Role();
        user.setRole("USER");
        roleService.saveOrUpdate(user);
        

        
    }
    private void assignUsersToUserRole() {
        List<Role> roles = roleService.listAll();
        List<User> users = userService.listAll();
        		
        roles.forEach(role -> {
            if (role.getRole().equalsIgnoreCase("USER")) {
            	
            	users.forEach(user ->
            	{
            		if (user.getUsername().equalsIgnoreCase("user"))
            		{
            			user.addRole(role);
						userService.saveOrUpdate(user);
					}
            	});
            }
        });
    }
    private void assignUsersToAdminRole() {
        
        List<Role> roles = roleService.listAll();
        List<User> users = userService.listAll();

        roles.forEach(role -> {
            if (role.getRole().equalsIgnoreCase("ADMIN")) {

            	users.forEach(user ->
            	{
            		if (user.getUsername().equalsIgnoreCase("admin"))
            		{
            			user.addRole(role);
						userService.saveOrUpdate(user);
					}
            	});
            }
        });
    }
}