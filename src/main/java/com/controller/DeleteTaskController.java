package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.TaskDao;

@WebServlet("/DeleteTaskController")
public class DeleteTaskController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		TaskDao taskDao = new TaskDao();
		int taskid = Integer.parseInt(request.getParameter("taskid"));
		if (taskDao.deleteTask(taskid)) {
			response.sendRedirect("ListTaskController");
		} else {
			System.out.println("not deleted");
		}

	}

}
