package com.Coupon.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Coupon.Dao.UserDao;
import com.Coupon.Dao.UserDaoImpl;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserDao d = new UserDaoImpl();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String uname = request.getParameter("username");
		String pass = request.getParameter("password");

		HttpSession session = request.getSession();

		if (uname.equalsIgnoreCase("admin") && pass.equalsIgnoreCase("admin")) {
			session.setAttribute("name", uname);
			request.getRequestDispatcher("admin.jsp").forward(request, response);

		} else if (d.validate(uname, pass)) {
			session.setAttribute("name", uname);
			request.getRequestDispatcher("Welcome.jsp").forward(request, response);
		} else {

			out.print("Wrong Password");
			request.getRequestDispatcher("index.html").include(request, response);
		}

	}

}
