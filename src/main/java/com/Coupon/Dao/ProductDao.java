package com.Coupon.Dao;

import java.util.List;

import com.Coupon.Model.Product;

public interface ProductDao {

	int addProduct(Product p);
	List<Product> getAllProducts();
	Product getProduct(int id);
	
}
