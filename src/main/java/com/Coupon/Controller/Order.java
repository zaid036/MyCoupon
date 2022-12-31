package com.Coupon.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Coupon.Dao.OrderDao;
import com.Coupon.Dao.OrderDaoImpl;

@WebServlet("/order")
public class Order extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		OrderDao od = new OrderDaoImpl();
		com.Coupon.Model.Order o = new com.Coupon.Model.Order();
		int pid = Integer.parseInt(req.getParameter("pid"));
		HttpSession session = req.getSession();
		String name = (String) session.getAttribute("name");
		String code = req.getParameter("ccode");
		float discount = Float.parseFloat(req.getParameter("cdiscount"));
		float price = Float.parseFloat(req.getParameter("pprice"));
		if (name != null && code != null) {
			o.setPid(pid);
			o.setUsername(name);
			o.setPrice(new BigDecimal(price - discount));
			o.setCoupon_used(code);
			int i = od.addOrder(o);
			if (i > 0) {
				req.getRequestDispatcher("GetAllProducts.jsp").forward(req, resp);
			}

		} else if (name != null) {
			o.setPid(pid);
			o.setUsername(name);
			o.setPrice(new BigDecimal(price));
			o.setCoupon_used(code);
			int i = od.addOrder(o);
			if (i > 0) {

				req.getRequestDispatcher("GetAllProducts.jsp").forward(req, resp);
			}

		} else {
			resp.sendRedirect("Order.jsp");
		}

	}

}
