package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.TaskBean;
import com.dao.TaskDao;

@WebServlet("/PercentageController")
public class PercentageController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		TaskDao taskDao = new TaskDao();
		HttpSession session = request.getSession();
		int userid = (int) session.getAttribute("userid");
		System.out.println("percentage controller");

		int per = taskDao.countPercentage(userid);
		request.setAttribute("persentage", per);
		request.getRequestDispatcher("Percentage.jsp").forward(request, response);
	}

}
