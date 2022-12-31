package com.Coupon.Model;

import java.math.BigDecimal;

public class Order {

	private int id;
	private String username;
	private int pid;
	private BigDecimal price;
	private String coupon_used;
	private Product product;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int id, String username, int pid, BigDecimal price, String coupon_used, Product product) {
		super();
		this.id = id;
		this.username = username;
		this.pid = pid;
		this.price = price;
		this.coupon_used = coupon_used;
		this.product = product;
	}
	public int getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public int getPid() {
		return pid;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public String getCoupon_used() {
		return coupon_used;
	}
	public Product getProduct() {
		return product;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public void setCoupon_used(String coupon_used) {
		this.coupon_used = coupon_used;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", username=" + username + ", pid=" + pid + ", price=" + price + ", coupon_used="
				+ coupon_used + ", product=" + product + "]";
	}

	

}
