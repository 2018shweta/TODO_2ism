package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.TaskBean;
import com.dao.TaskDao;

@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		TaskDao taskDao = new TaskDao();
		int taskid = Integer.parseInt(request.getParameter("taskid"));
		TaskBean task = taskDao.getTaskByTaskid(taskid);
		request.setAttribute("task", task);
		request.getRequestDispatcher("UpdateTask.jsp").forward(request, response);

	}

}
