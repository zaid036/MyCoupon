package com.Coupon.Model;

import java.math.BigDecimal;

public class Coupon {

	private int id;
	private String coupon_Code;
	private BigDecimal discount;
	private String exp_date;

	public Coupon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Coupon(int id, String coupon_Code, BigDecimal discount, String exp_date) {
		super();
		this.id = id;
		this.coupon_Code = coupon_Code;
		this.discount = discount;
		this.exp_date = exp_date;
	}

	public int getId() {
		return id;
	}

	public String getCoupon_Code() {
		return coupon_Code;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public String getExp_date() {
		return exp_date;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCoupon_Code(String coupon_Code) {
		this.coupon_Code = coupon_Code;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public void setExp_date(String exp_date) {
		this.exp_date = exp_date;
	}

	@Override
	public String toString() {
		return "Coupon [id=" + id + ", coupon_Code=" + coupon_Code + ", discount=" + discount + ", exp_date=" + exp_date
				+ "]";
	}

}
