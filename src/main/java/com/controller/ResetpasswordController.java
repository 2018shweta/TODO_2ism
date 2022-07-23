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

@WebServlet("/ResetpasswordController")
public class ResetpasswordController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String newpassword = request.getParameter("newpassword");
		String confirmpassword = request.getParameter("confirmpassword");
		// System.out.println(newpassword);
		// System.out.println(confirmpassword);
		boolean isError = false;
		if (newpassword == null) {
			isError = true;
			request.setAttribute("newpasswordError", "Please Select newpassword");
		} else {
			request.setAttribute("newpasswordValue", newpassword);
		}
		if (confirmpassword == null) {
			isError = false;
			request.setAttribute("confirmpasswordError", "Please Select confirmpasswordr");
		} else {
			request.setAttribute("confirmpasswordValue", confirmpassword);
		}
		UserDao userDao = new UserDao();
		HttpSession session = request.getSession();
		String gmail = (String) session.getAttribute("gmail");
		System.out.println(gmail);
		if (newpassword.equals(confirmpassword)) {
			isError = false;
			Boolean up1 = userDao.updatepassword(newpassword, gmail);
		}

		// goback}
		if (isError == true) {
			request.getRequestDispatcher("Resetpassword.jsp").forward(request, response);

		} else {
			// goahead
			// goto home.jsp

//		userBean.setPassword(confirmpassword);
//		userBean.setUserlastname(lastName);
//		userBean.setGmail(email);
//		userBean.setPassword(password);
//		userBean.setQueans(queans);
//		userBean.setGender(gender);
//		userBean.setUsertype("customer");

			// goahead
			// goto home.jsp
			request.setAttribute("msg", "update  done...");
			request.getRequestDispatcher("Login.jsp").forward(request, response);

		}

	}

}
