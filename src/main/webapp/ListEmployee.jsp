<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Employee</title>
</head>
<body>


	<%
	ArrayList<UserBean> users = ArrayList < UserBean > request.getAttribute("costumertable");
	%>

	<div class=container>
		<div class="row">
			<div class="col-3"></div>
			<div class="col-6">
				<h1 class="text-center">LIST OF Employees</h1>
				<table border="4" id="users" class="display">
					<thead>
						<tr class="table table-dark">
							<th scope="col">UserId</th>
							<th scope="col">FirstName</th>
							<th scope="col">LastName</th>
							<th scope="col">Email</th>
							<th scope="col">Gender</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<%
						for (UserBean user : users) {
						%>
						<tr>
							<td><%=user.getUserid()%></td>
							<td><%=user.getUserfirstname()%></td>
							<td><%=user.getUserlastname()%></td>
							<td><%=user.getGmail()%></td>
							<td><%=user.getGender()%></td>
							<td><a href="DeleteController?userid=<%=user.getUserId()%>">Delete</a>||<a
								href="UpdateUserFormController?userid=<%=user.getUserId()%>">Update</a>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>
			</div>
			<div class="col-3"></div>
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