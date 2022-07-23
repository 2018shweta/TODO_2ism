package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;

public class SignUpDuplicate implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String gmail = request.getParameter("email");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String queans = request.getParameter("queans");
		String usertype = request.getParameter("usertype");
		String isactive = request.getParameter("isactive");
		// String gmail=request.getParameter("email");
		UserDao userDao = new UserDao();
		Boolean isError = false;
		Boolean d1 = userDao.checkGmailDuplication(gmail);
		if (firstName == null || firstName.trim().length() == 0) {
			isError = true;
			request.setAttribute("firstNameError", "<font color='red'>Please Enter FirstName</font>");
		}
		if (lastName == null || lastName.trim().length() == 0) {
			isError = true;
			request.setAttribute("lastNameError", "<font color='red'>Please Enter lastName</font>");
		}

		if (gmail == null || gmail.trim().length() == 0) {
			isError = true;
			request.setAttribute("emailError", "Please Enter Email");
		}

		if (queans == null || queans.trim().length() == 0) {
			isError = true;
			request.setAttribute("queansError", "Please Enter queans");
		}

		if (password == null || password.trim().length() == 0) {
			isError = true;
			request.setAttribute("passwordError", "Please enter password");
		}

		if (gender == null) {
			isError = true;
			request.setAttribute("genderError", "Please Select Gender");
		}

		if (d1) {
			isError = true;
			request.setAttribute("dGmail", "Duplicate gmail not valid");
			request.getRequestDispatcher("SignUp.jsp").forward(request, response);
		}
		if (isError) {
			request.getRequestDispatcher("SignUp.jsp").forward(request, response);
		}

		else {

			UserBean userBean = new UserBean();
			userBean.setUserfirstname(firstName);
			userBean.setUserlastname(lastName);
			userBean.setGmail(gmail);
			userBean.setPassword(password);
			userBean.setQueans(queans);
			userBean.setGender(gender);
			userBean.setUsertype("customer");
			userBean.setIsactive(1);

			// userDao.withoutDuplicateGmailInsert(userBean);
			userDao.insertUser(userBean);
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
