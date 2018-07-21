package com.cg.spring.boot.jpa.springbootdatajpa.products;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	ProductRespository productRespository;

	public List<Product> getAllProducts() {

		List<Product> products = new ArrayList<>();
		productRespository.findAll().forEach(products::add);
		return products;

	}

	public Optional<Product> getProduct(String id) {

		return productRespository.findById(id);
	}

	public void addProduct(Product p) {
		
		
		productRespository.save(p);
		
	}

	public void updateProduct(String id, Product p) {

		productRespository.save(p);
	}

	public void removeProduct(String id) {

		productRespository.deleteById(id);
	}
}
