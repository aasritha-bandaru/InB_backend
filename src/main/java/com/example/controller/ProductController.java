package com.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Product;
import com.example.service.ProductService;

@CrossOrigin(origins = "http://inbsample.s3-website.ap-south-1.amazonaws.com")
@RestController
@RequestMapping("/api/Product")
public class ProductController {
	
	@Autowired
	private ProductService productservice;
	
	@PostMapping(path = "/addFeeback", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String addFeeback(@RequestBody Product product) {
		if (product == null 
		    	||	product.getProductname() == null || product.getProductname().trim().isEmpty()
		    	|| product.getComments() == null || product.getComments().trim().isEmpty()
		    	|| product.getUsername() == null ) {
		        return "Please fill out all the fields";
		    }
		else {
		productservice.saveDetails(product);
		return "Added succesfully";
		
		}
		
//		@PostMapping("/addFeeback")
//	    public ResponseEntity<String> addProductForUser(@RequestBody Product product) throws Exception {
//			productservice.addProductForUser(product);
//	        return ResponseEntity.ok("Product added successfully");
//	    }
		
		}
	
	@GetMapping("/getFeedback/{username}")
    public List<Product> getRatingsByUsername(@PathVariable String username) {
        return productservice.getRatingsByUsername(username);
    }
	
	@GetMapping("/getAllFeedback")
	public List<Product> getAllRatings(){
	//	return productservice.getAllRatings();
		List<Product> apiResponse =  productservice.getAllRatings();
		
		List<Product> productList = new ArrayList<>();

        try {
            JSONArray jsonArray = new JSONArray(apiResponse);
            Map<String, Integer> productRatings = new HashMap<>();
            Map<String, Integer> productCounts = new HashMap<>();

            // Iterate through the JSON array
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String productName = jsonObject.getString("productname");
                int rating = jsonObject.getInt("rating");

                // Update the sum of ratings and count for each product
                productRatings.put(productName, productRatings.getOrDefault(productName, 0) + rating);
                productCounts.put(productName, productCounts.getOrDefault(productName, 0) + 1);
            }

            // Calculate the average rating for each product
            for (String productName : productRatings.keySet()) {
                int totalRating = productRatings.get(productName);
                int count = productCounts.get(productName);
                int averageRating = totalRating / count;

                // Create a Product object with the product name and average rating
                Product product = new Product();
                product.setProductname(productName);
                product.setRating(averageRating);

                // Add the product to the list
                productList.add(product);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return productList;
		
	}
}

	


