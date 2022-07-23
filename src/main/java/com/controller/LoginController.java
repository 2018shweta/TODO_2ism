package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserBean;
import com.dao.UserDao;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String isactive = request.getParameter("isactive");

		System.out.println(email);
		UserDao userDao = new UserDao();
		UserBean user = userDao.login(email, password);
		RequestDispatcher rd = null;
		if (user == null) {
			request.setAttribute("errorMsg", "Invalid credentials");
			rd = request.getRequestDispatcher("Login.jsp");

		} else {
			HttpSession session = request.getSession();
			session.setAttribute("userid", user.getUserid());
			// session.setAttribute("gmail",user.getGmail());

			/*
			 * if (user.getUsertype().equals("customer")) { rd =
			 * request.getRequestDispatcher("CustomerHomePage.jsp");
			 * 
			 * if (user.getIsactive()==(1)) { //HttpSession session =
			 * request.getSession(true); //session.setAttribute("userid", user.getUserId());
			 * rd = request.getRequestDispatcher("CustomerHomePage.jsp"); }else
			 * if(user.getIsactive()==0) { request.setAttribute("error",
			 * "You Have Disable your account "); rd =
			 * request.getRequestDispatcher("Login.jsp"); System.out.println("lc"); }else {
			 * request.setAttribute("error", "SomeThing Went Wrong "); rd =
			 * request.getRequestDispatcher("Login.jsp"); }//customer } else if
			 * (user.getUsertype().equals("admin")) { rd =
			 * request.getRequestDispatcher("AdminHomePage.jsp"); } //admin else { rd =
			 * request.getRequestDispatcher("404.jsp"); }
			 */

			System.out.println(user.getIsactive());
			if (user.getIsactive() == (1)) {
				// HttpSession session = request.getSession(true);
				// session.setAttribute("userid", user.getUserId());
				if (user.getUsertype().equals("admin")) {
					rd = request.getRequestDispatcher("AdminHomePage.jsp");
				} else {
					rd = request.getRequestDispatcher("CustomerHomePage.jsp");
				}

			} else if (user.getIsactive() == 0) {
				request.setAttribute("error", "You Have Disable your account ");
				rd = request.getRequestDispatcher("Login.jsp");
				System.out.println("lc");
			} else {
				request.setAttribute("error", "SomeThing Went Wrong ");
				rd = request.getRequestDispatcher("Login.jsp");
			}

		}

		// ArrayList<UserBean> users = userDao.getAllUsers();
		// request.setAttribute("usertable", users);
//
		// RequestDispatcher rd = request.getRequestDispatcher("ListUser.jsp");
		rd.forward(request, response);
	}

}
