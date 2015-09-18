package com.iRentService.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iRentService.model.Product;
import com.iRentService.repository.ProductRepository;

@RestController
public class ProductController {

		private final ProductRepository prodRepository ;

	    @RequestMapping(value = "/iRentService/product/{prodName}", method = RequestMethod.GET)
	    Product getDetails(@PathVariable String prodName){	    	
	    	System.out.println("Prod == "+prodName);
	    	//System.out.println("Product ="+(this.prodRepository.findByProdName(prodName)).toString());
	    	Product prod = this.prodRepository.findByProdName(prodName);
	    	System.out.println("-------------------------");
	    	if(prod != null)
	    		System.out.println(prod.toString());
	    	return this.prodRepository.findByProdName(prodName);
	    }
	    @RequestMapping(value = "/iRentService/product/all", method = RequestMethod.GET)
	    List<Product> getAllProducts(){	    	
	    	List<Product> prod = new ArrayList<Product>();
	    	prod = (List<Product>) this.prodRepository.findAll();
	    	for (Product p : prod) {
	    		System.out.println("-------------------------");
    			System.out.println(p.toString());
    		}
	    	
	    	
	    	return prod;
	    }
	    
	    @Autowired
	    ProductController(ProductRepository prodRepository) {
			this.prodRepository = prodRepository;

	    }
	    
}
