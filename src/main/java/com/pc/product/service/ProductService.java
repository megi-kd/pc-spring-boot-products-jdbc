package com.pc.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pc.product.controller.ProductParams;
import com.pc.product.model.ProductResource;
import com.pc.product.model.ProductResourceList;
import com.pc.product.repository.ProductJdbcRepository;

@Service
public class ProductService {

	@Autowired
	private ProductJdbcRepository repository;

	public ProductResourceList findProducts(ProductParams params) {
		
		List<ProductResource> data = repository.findByProductParams(params);
		return new ProductResourceList(data);
	}
}
