package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserBean;
import com.dao.UserDao;

public class forgetpassword implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String gmail = request.getParameter("gmail");
		String queans = request.getParameter("queans");
		boolean isError = false;
		if (gmail == null || gmail.trim().length() == 0) {
			isError = true;
			request.setAttribute("gmailError", "Please Enter gamial filter");
		} else if (queans == null || queans.trim().length() == 0) {
			isError = true;
			request.setAttribute("queansError", "Please Enter queans filter");
		}
		UserDao userDao = new UserDao();
		boolean flag = userDao.duplicate(gmail, queans);
		if (flag == false) {
			isError = true;
			request.setAttribute("duplicatError", "not duplicate accepted");
		}
		if (isError) {
			request.getRequestDispatcher("Forgetpassword.jsp").forward(request, response);
		} else {

			// go ahead
			chain.doFilter(request, response);
		} // servlet -- second filter
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
