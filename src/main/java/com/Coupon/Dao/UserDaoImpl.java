package com.Coupon.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Coupon.Model.Order;
import com.Coupon.Model.Product;
import com.Coupon.Model.User;

public class UserDaoImpl implements UserDao {

	private Connection con;
	private PreparedStatement ps;

	@Override
	public int registerUser(User u) {
		int i = 0;
		con = GetConnection.getConnection();
		String q = "insert into user(username,password,email,phone) values(?,?,?,?)";
		try {
			ps = con.prepareStatement(q);
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getPhone());
			i = ps.executeUpdate();
			ps.close();
			con.close();
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
	public boolean validate(String username, String password) {
		String q = "select * from user where username=? AND password=?";
		boolean f = false;
		try {
			con = GetConnection.getConnection();
			ps = con.prepareStatement(q);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = true;
				return f;

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
		return f;
	}

	@Override
	public List<Order> getAllOrders(String username) {
		String q = "select * from product_order where username=?";
		List<Order> list = new ArrayList<>();
		con = GetConnection.getConnection();
		try {
			ps = con.prepareStatement(q);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Order o = new Order();
				Product p=new Product();
				o.setId(rs.getInt("id"));
				o.setPid(rs.getInt("pid"));
				o.setUsername(rs.getString("username"));
				o.setPrice(rs.getBigDecimal("price"));
				o.setCoupon_used(rs.getString("coupon_used"));
				ProductDao pd=new ProductDaoImpl();
				p = pd.getProduct(rs.getInt("pid"));
				o.setProduct(p);
				list.add(o);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				con.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

}
