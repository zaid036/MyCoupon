package com.Coupon.Dao;

import java.util.List;

import com.Coupon.Model.Order;

public interface OrderDao {
	
	int addOrder(Order o);
	List<Order> getAllOrder();
	Order getOrder(String username);

}
