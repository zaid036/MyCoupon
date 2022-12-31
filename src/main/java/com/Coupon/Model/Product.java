package com.Coupon.Model;

import java.math.BigDecimal;

public class Product {

	private int id;
	private String name;
	private BigDecimal price;
	private String discription;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int id, String name, BigDecimal price, String discription) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.discription = discription;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public String getDiscription() {
		return discription;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", discription=" + discription + "]";
	}

}
