package com.Coupon.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Coupon.Model.Product;

public class ProductDaoImpl implements ProductDao {

	private Connection con = GetConnection.getConnection();
	private PreparedStatement ps;
	private Statement st;

	@Override
	public int addProduct(Product p) {
		int i = 0;
		String q = "insert into product(name,price,discription) values(?,?,?)";
		try {
			ps = con.prepareStatement(q);
			ps.setString(1, p.getName());
			ps.setBigDecimal(2, p.getPrice());
			ps.setString(3, p.getDiscription());
			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return i;
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> list = new ArrayList<>();
		String q = "select * from product";
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(q);
			while (rs.next()) {
				Product p = new Product(rs.getInt("id"), rs.getString("name"), rs.getBigDecimal("price"),
						rs.getString("discription"));
				list.add(p);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public Product getProduct(int id) {
		String q = "select * from product where id=?";
		Product p = null;
		try {
			ps = con.prepareStatement(q);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				p = new Product(rs.getInt("id"), rs.getString("name"), rs.getBigDecimal("price"),
						rs.getString("discription"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return p;
	}
	
}