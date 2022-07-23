<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.bean.TaskBean"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update task</title>
</head>
<body>

	<%
	TaskBean task = (TaskBean) request.getAttribute("task");
	//String genderValue = t.getGender();
	%>
	<h2>Update Task</h2>
	<form method="post" action="UpdateTaskFromController">
		<input type="hidden" value="${task.taskid }" name="taskid">
		First Name: <input type="text" placeholder="First Name"
			name="taskname" value="${task.taskname}" />${firstNameError}<br>
		<br> Last Name: <input type="text" placeholder="Last Name"
			name="description" value="${task.description}" />${lastNameError}<br>
		<br> Status: <input type="text" placeholder="status"
			name="status" value="${task.status}" />${emailError}<br>
		<br> Priority: <input type="text" placeholder="priority"
			name="priority" value="${task.priority}" />${passwordError}<br>
		<br> Date: <input type="date" placeholder="date" name="date"
			value="${task.date}" />${passwordError}<br>
		<br> <input type="submit" value="Update User" />${message}

	</form>



</body>
</html>