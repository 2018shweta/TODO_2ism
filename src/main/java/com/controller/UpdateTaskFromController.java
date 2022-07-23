package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.TaskBean;
import com.bean.UserBean;
import com.dao.TaskDao;
import com.dao.UserDao;

@WebServlet("/UpdateTaskFromController")
public class UpdateTaskFromController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TaskBean task = new TaskBean();
		task.setTaskname(request.getParameter("taskname"));
		task.setDescription(request.getParameter("description"));
		task.setStatus(request.getParameter("status"));
		task.setPriority(request.getParameter("priority"));
		System.out.println(request.getParameter("priority"));
		// task.se(request.getParameter("password"));
		task.setDate(request.getParameter("date"));
		task.setTaskid(Integer.parseInt(request.getParameter("taskid")));// ahiya zero aave che
		// int taskid=Integer.parseInt(request.getParameter("taskid"));
		System.out.println("taskid." + Integer.parseInt(request.getParameter("taskid")));
		System.out.println("enter utfc");
		TaskDao taskDao = new TaskDao();
		if (taskDao.updateTask(task)) {
			request.setAttribute("message", "Updated Successfully");
		} else {
			request.setAttribute("message", "Some error occured");
		}
		request.getRequestDispatcher("ListTaskController").forward(request, response);
	}

}
