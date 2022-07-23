package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.TaskBean;
import com.dao.TaskDao;

@WebServlet("/ListTaskController")
public class ListTaskController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		TaskDao taskDao = new TaskDao();
		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("userid");
		System.out.println("jnknkd");
		ArrayList<TaskBean> tasks = TaskDao.getAllTask(userId);
		request.setAttribute("tasks", tasks);
		System.out.println(tasks);
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("ListTask.jsp");
		rd.forward(request, response);

	}

}
