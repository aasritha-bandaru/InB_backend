package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long>{

	List<Product> findByUsername(String username);
	
//	@Autowired
//	public static final EntityManager entityManager = null;
//
//	    @Transactional
//	    public static void addProductForUser(Product product) throws Exception {
//	        UserDetails user = entityManager.find(UserDetails.class, product.getUser());
//	        if (user != null) {
//	            Product product1 = new Product();
//	            product1.setProductname(product1.getProductname());
//	            product1.setRating(product1.getRating());
//	            product1.setComments(product1.getComments());
//	            product1.setUser(product1.getUser());
//
//	            entityManager.persist(product1);
//	        } else {
//	         //   throw new RuntimeException("User not found with username: " + product.getUser());
//	            throw new Exception("User not found with username: " + product.getUser());
//	        }
//	    }

	
}
