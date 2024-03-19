package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Product;
import com.example.repository.ProductRepo;

@Service
public class ProductService implements ProductInt{
	
	@Autowired
	public ProductRepo productRepo;

	@Override
	public Product saveDetails(Product product) {
		// TODO Auto-generated method stub
		return productRepo.save(product);
	}

	public List<Product> getRatingsByUsername(String username) {
		// TODO Auto-generated method stub
		return productRepo.findByUsername(username);
	}

	public List<Product> getAllRatings() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}

	
	
//	 public void addProductForUser(Product product) throws Exception {
//		 ProductRepo.addProductForUser(product);
//	    }

	


}
