package com.pc.product.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pc.product.model.ProductResourceList;
import com.pc.product.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/product")
	public ProductResourceList getProducst(ProductParams params) {
		
		return productService.findProducts(params);
		
	}
	
	
	

}
