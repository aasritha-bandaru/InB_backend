package com.example.service;

import java.util.List;

import com.example.entity.Product;

public interface ProductInt {
	public Product saveDetails(Product product);
	//public void addProductForUser(Product product) throws Exception;
	public List<Product> getRatingsByUsername(String username);
	public List<Product> getAllRatings();

}
