package com.Coupon.Dao;

import java.util.List;

import com.Coupon.Model.Coupon;
import com.Coupon.Model.Product;

public interface CouponDao {

	int addCoupon(Coupon c);
	List<Coupon> getAllCoupon();
	Coupon getCoupon(String code);
	
}
