package com.Coupon.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Coupon.Dao.UserDao;
import com.Coupon.Dao.UserDaoImpl;
import com.Coupon.Model.User;

@WebServlet(urlPatterns = "/register")
public class RegisterController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		UserDao d = new UserDaoImpl();
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		String uname = req.getParameter("username");
		String pass = req.getParameter("password");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		User u = new User();
		u.setUsername(uname);
		u.setPassword(pass);
		u.setEmail(email);
		u.setPhone(phone);
		int i = d.registerUser(u);

		if (i > 0) {
			out.print("Register Done");
			req.getRequestDispatcher("index.html").include(req, resp);
		} else {
			out.print("Try again");
			req.getRequestDispatcher("register.html").include(req, resp);
		}

	}

}
