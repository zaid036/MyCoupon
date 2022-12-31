package com.Coupon.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Coupon.Model.Coupon;
import com.Coupon.Model.Product;

public class CouponDaoImpl implements CouponDao {

	private Connection con;
	private PreparedStatement ps;
	private Statement st;

	@Override
	public int addCoupon(Coupon c) {
		int i = 0;
		String q = "insert into couponcode(coupon_code,discount,exp_date) values(?,?,?)";
		try {
			con = GetConnection.getConnection();
			ps = con.prepareStatement(q);
			ps.setString(1, c.getCoupon_Code());
			ps.setBigDecimal(2, c.getDiscount());
			ps.setString(3, c.getExp_date());
			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return i;
	}

	@Override
	public List<Coupon> getAllCoupon() {
		List<Coupon> list = new ArrayList<>();
		String q = "select * from couponcode";
		try {
			con = GetConnection.getConnection();
			st = con.createStatement();
			ResultSet rs = st.executeQuery(q);
			while (rs.next()) {
				Coupon c = new Coupon(rs.getInt("id"), rs.getString("coupon_code"), rs.getBigDecimal("discount"),
						rs.getString("exp_date"));
				list.add(c);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;
	}

	@Override
	public Coupon getCoupon(String code) {
		String q = "select * from couponcode where Coupon_code=?";
		Coupon c = null;
		try {
			con = GetConnection.getConnection();
			ps = con.prepareStatement(q);
			ps.setString(1, code);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				c = new Coupon(rs.getInt("id"), rs.getString("coupon_code"), rs.getBigDecimal("discount"),
						rs.getString("exp_date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return c;
	}

}
