package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.TaskBean;
import com.dao.TaskDao;
import com.dao.UserDao;

@WebServlet("/TaskActionDoneController")
public class TaskActionDoneController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		TaskDao taskDao = new TaskDao();
		int taskid = Integer.parseInt(request.getParameter("taskid"));
		UserDao userDao = new UserDao();
		// TaskBean task=taskDao.taskDone(taskid);
		if (taskDao.taskDone(taskid)) {
			request.setAttribute("done_msg", "Task Done");
		} else {
			request.setAttribute("done_msg", "something error");
		}

		// request.setAttribute("task", task);
		request.getRequestDispatcher("ListTaskController").forward(request, response);

	}

}
