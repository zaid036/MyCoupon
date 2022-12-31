package com.Coupon.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Coupon.Dao.CouponDao;
import com.Coupon.Dao.CouponDaoImpl;
import com.Coupon.Dao.ProductDao;
import com.Coupon.Dao.ProductDaoImpl;
import com.Coupon.Model.Coupon;
import com.Coupon.Model.Product;

@WebServlet("/add")
public class Add extends HttpServlet {

	ProductDao pd = new ProductDaoImpl();
	CouponDao cd = new CouponDaoImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		String task = req.getParameter("add");

		if (task.equals("coupon")) {

			int i = addCoupon(req, resp);
			if (i > 0) {
				out.print("Coupon Added");
				req.getRequestDispatcher("admin.jsp").include(req, resp);
			}
		} else if (task.equals("product")) {

			int i = addProduct(req, resp);
			if (i > 0) {
				out.print("Product Added");
				req.getRequestDispatcher("admin.jsp").include(req, resp);
			}

		} else {

			out.print("Not Added");
			req.getRequestDispatcher("admin.jsp").include(req, resp);
		}
	}

	private int addProduct(HttpServletRequest req, HttpServletResponse resp) {
		int i = 0;
		String name = req.getParameter("name");
		String price = req.getParameter("price");
		String dis = req.getParameter("discription");

		Product p = new Product();
		p.setName(name);
		p.setPrice(new BigDecimal(price));
		p.setDiscription(dis);

		i = pd.addProduct(p);

		return i;
	}

	private int addCoupon(HttpServletRequest req, HttpServletResponse resp) {
		int i = 0;

		String code = req.getParameter("coupon_Code");
		String discount = req.getParameter("discount");
		String exp_date = req.getParameter("exp_date");

		Coupon c = new Coupon();
		c.setCoupon_Code(code);
		c.setDiscount(new BigDecimal(discount));
		c.setExp_date(exp_date);
		i = cd.addCoupon(c);

		return i;
	}

}
