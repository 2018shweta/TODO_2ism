<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.bean.TaskBean"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Task</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css">
</head>
<body>
	<jsp:include page="CustomerHeader.jsp"></jsp:include>
	<%
	ArrayList<TaskBean> tasks = (ArrayList<TaskBean>) request.getAttribute("tasks");
	%>
	<div class="container">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<h2 align="center" class="text-center">List Tasks</h2>

				<table border="4" class=" table display table-striped" id="users">
					<thead class="thead-dark table-dark">
						<tr class="table  ">

							<th>taskname</th>
							<th>description</th>
							<th>status</th>
							<th>priority</th>
							<th>date</th>
							<th>action</th>
							<th>task_action</th>
						</tr>
					</thead>

					<tbody>
						<%
						for (TaskBean t : tasks) {
						%>
						<tr>

							<td><%=t.getTaskname()%></td>
							<td><%=t.getDescription()%></td>
							<td><%=t.getStatus()%></td>
							<td><%=t.getPriority()%></td>
							<td><%=t.getDate()%></td>
							<td><a href="DeleteTaskController?taskid=<%=t.getTaskid()%>">Del</a>
								|<a href="UpdateController?taskid=<%=t.getTaskid()%>">Upd</a></td>
							<td><a
								href="TaskActionDoneController?taskid=<%=t.getTaskid()%>">Done</a></td>
						</tr>
						<%
						}
						%>

					</tbody>
				</table>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#users').DataTable();
		});
	</script>
</body>
</html>