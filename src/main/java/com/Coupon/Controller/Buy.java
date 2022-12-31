package com.Coupon.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Coupon.Dao.CouponDao;
import com.Coupon.Dao.CouponDaoImpl;
import com.Coupon.Dao.ProductDao;
import com.Coupon.Dao.ProductDaoImpl;
import com.Coupon.Model.Coupon;
import com.Coupon.Model.Product;

@WebServlet(urlPatterns = "/buy")
public class Buy extends HttpServlet  {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		ProductDao pd=new ProductDaoImpl();
		CouponDao cd=new CouponDaoImpl();
		HttpSession session = req.getSession();
		String name=(String) session.getAttribute("name");
		
		if(name!=null) {
		String code = req.getParameter("couponcode").trim();
		int id =Integer.parseInt(req.getParameter("productid"));
		Product product = pd.getProduct(id);
		Coupon coupon = cd.getCoupon(code);
		req.setAttribute("product", product);
		req.setAttribute("coupon", coupon);
		req.getRequestDispatcher("Order.jsp").forward(req, resp);
		}
		else
		{
			resp.sendRedirect("index.html");
		}
		
		
	}
	

}
