package com.Coupon.Dao;

import java.util.List;

import com.Coupon.Model.Order;
import com.Coupon.Model.User;

public interface UserDao {

	int registerUser(User u);
	boolean validate(String username,String password);
	List<Order> getAllOrders(String username);
	
}
