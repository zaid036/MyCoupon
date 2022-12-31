package com.Coupon.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Coupon.Model.Coupon;
import com.Coupon.Model.Order;

public class OrderDaoImpl implements OrderDao {

	private Connection con;
	private PreparedStatement ps;
	private Statement st;

	@Override
	public int addOrder(Order o) {
		int i = 0;
		String q = "insert into product_order(username,pid,price,coupon_used) values(?,?,?,?)";
		try {
			con = GetConnection.getConnection();
			ps = con.prepareStatement(q);
			ps.setString(1, o.getUsername());
			ps.setInt(2, o.getPid());
			ps.setBigDecimal(3, o.getPrice());
			ps.setString(4, o.getCoupon_used());
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
	public List<Order> getAllOrder() {
		List<Order> list = new ArrayList<>();
		String q = "select * from product_order";
		try {
			con = GetConnection.getConnection();
			st = con.createStatement();
			ResultSet rs = st.executeQuery(q);
			while (rs.next()) {
				Order o = new Order();
				o.setId(rs.getInt("id"));
				o.setUsername(rs.getString("username"));
				o.setPid(rs.getInt("pid"));
				o.setPrice(rs.getBigDecimal("price"));
				o.setCoupon_used(rs.getString("coupon_used"));
				list.add(o);
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
	public Order getOrder(String username) {
		String q = "select * from product_order where username=?";
		Order o = null;
		try {
			con = GetConnection.getConnection();
			ps = con.prepareStatement(q);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				o = new Order();
				o.setId(rs.getInt("id"));
				o.setUsername(rs.getString("username"));
				o.setPid(rs.getInt("pid"));
				o.setPrice(rs.getBigDecimal("price"));
				o.setCoupon_used(rs.getString("coupon_used"));

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

		return o;
	}

}
