package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private Long id;

	    @Column(name = "productname")
	    private String productname;

	    @Column(name = "rating")
	    private int rating;

	    @Column(name = "comments")
	    private String comments;

	    @Column(name = "username")
	    private String username;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getProductname() {
			return productname;
		}

		public void setProductname(String productname) {
			this.productname = productname;
		}

		public int getRating() {
			return rating;
		}

		public void setRating(int rating) {
			this.rating = rating;
		}

		public String getComments() {
			return comments;
		}

		public void setComments(String comments) {
			this.comments = comments;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}
		

		public Product() {
			super();
		}
		
		  public Product(Long id, String productname, int rating, String comments, String username ) {
			  super();
			  this.id=id;
			  this.productname = productname;
			  this.rating = rating;
			  this.comments = comments;
			this.username =username;
		  }

		

		@Override
		public String toString() {
			return "Product [id=" + id + ", productname=" + productname + ", rating=" + rating + ", comments="
					+ comments + ", username=" + username + "]";
		}
		
	
	  

}
