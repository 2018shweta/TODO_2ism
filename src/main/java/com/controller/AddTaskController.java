package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.TaskBean;
import com.bean.UserBean;
import com.dao.TaskDao;

@WebServlet("/AddTaskController")
public class AddTaskController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String taskname = request.getParameter("taskname");
		String description = request.getParameter("description");
		String status = request.getParameter("status");
		String priority = request.getParameter("priority");
		String date = request.getParameter("date");

		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("userid");

		System.out.println(taskname);
		System.out.println(description);
		System.out.println(status);
		System.out.println(priority);
		System.out.println(date);

		Boolean isError = false;

		if (taskname == null || taskname.trim().length() == 0) {
			isError = true;
			request.setAttribute("tasknameError", "Enter the task name");
		} else {
			request.setAttribute("tasknameValue", taskname);
		}

		if (description == null || description.trim().length() == 0) {
			isError = true;
			request.setAttribute("descriptionError", "Enter the description");
		} else {
			request.setAttribute("descriptionValue", description);
		}

		if (status == null || status.trim().length() == 0) {
			isError = true;
			request.setAttribute("statusError", "Enter the status");
		} else {
			request.setAttribute("statusValue", status);
		}

		if (priority == null || priority.trim().length() == 0) {
			isError = true;
			request.setAttribute("priorityError", "Enter the priority");
		} else {
			request.setAttribute("priorityValue", status);
		}

		if (date == null || date.trim().length() == 0) {
			isError = true;
			request.setAttribute("dateError", "Enter the date");
		} else {
			request.setAttribute("dateValue", status);
		}

		if (isError == true) {
			request.getRequestDispatcher("AddTask.jsp").forward(request, response);

		} else {

			TaskBean taskBean = new TaskBean();
			TaskDao taskDao = new TaskDao();
			taskBean.setTaskname(taskname);
			taskBean.setDescription(description);
			taskBean.setStatus(status);
			taskBean.setPriority(priority);
			taskBean.setDate(date);

			System.out.println(taskname);
			System.out.println(description);

			taskDao.insertlist(taskBean, userId);

// goahead
// goto home.jsp
//request.setAttribute("msg", "Add task done done...");
			response.sendRedirect("CustomerHomePage.jsp");
		}
	}
}
