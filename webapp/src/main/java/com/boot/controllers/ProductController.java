package com.boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.boot.entities.Product;
import com.boot.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
     private ProductService productService;
     
		//GET sur /products
     	@RequestMapping(value="/products", method=RequestMethod.GET)
        public String list(Model model){
            model.addAttribute("products", productService.listAllProducts());
            return "products";
        }

        //GET sur "product/show/{id}"
     	@RequestMapping(value="/product/show/{id}", method=RequestMethod.GET)
        public String showProduct(@PathVariable Integer id, Model model){
            model.addAttribute("product", productService.getProductById(id));
            return "productshow";
        }

        //GET sur "product/edit/{id}"
     	@RequestMapping(value="/product/edit/{id}", method=RequestMethod.GET)
        public String edit(@PathVariable Integer id, Model model){
            model.addAttribute("product", productService.getProductById(id));
            return "productform";
        }

        //GET sur"product/new"
     	@RequestMapping(value="/product/new", method=RequestMethod.GET)
        public String newProduct(Model model){
            model.addAttribute("product", new Product());
            return "productform";
        }

        //POST sur "product"
     	@RequestMapping(value="/product", method=RequestMethod.GET)
        public String saveProduct(Product product){
        	productService.saveProduct(product);
            return "redirect:/product/show/" + product.getId();
        }

        //GET sur "product/delete/{id}"
     	@RequestMapping(value="/product/delete/{id}", method=RequestMethod.GET)
        public String delete(@PathVariable Integer id){
        	productService.deleteProduct(id);
            return "redirect:/products";
        }
}