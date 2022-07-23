<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Task</title>

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>

	<jsp:include page="CustomerHeader.jsp"></jsp:include>

	<%
	String tasknameError = (String) request.getAttribute("tasknameError");
	String descriptionError = (String) request.getAttribute("descriptionError");
	String statusError = (String) request.getAttribute("statusError");
	String priorityError = (String) request.getAttribute("priorityError");
	String dateError = (String) request.getAttribute("dateError");
	%>

	<div class="container">

		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="card">
					<header class="card-header">
						<a href="Login.jsp"
							class="float-right btn btn-outline-primary mt-1">Login</a>
						<h4 class="card-title mt-2">Add Task</h4>
					</header>
					<article class="card-body">
						<form method="post" action="AddTaskController">

							<div class=" form-group">
								<label>Task name </label> <input type="text" name="taskname"
									class="form-control" /> <span style="color: red">
									<p>${tasknameError}</p>
								</span>
							</div>

							<div class=" form-group">
								<label>Description </label> <input type="text"
									name="description" class="form-control" />
								<p style="color: red"><%=descriptionError == null ? "" : descriptionError%></p>
							</div>
							<div class=" form-group">
								<label>Status </label> <input type="text" name="status"
									class="form-control" />
								<p style="color: red"><%=statusError == null ? "" : statusError%></p>
							</div>

							<div class=" form-group">
								<label>Priority </label> <input type="text" name="priority"
									class="form-control" />
								<p style="color: red"><%=priorityError == null ? "" : priorityError%></p>
							</div>
							<div class=" form-group">
								<label>Date </label> <input type="date" name="date"
									class="form-control" />
								<p style="color: red"><%=dateError == null ? "" : dateError%></p>
							</div>



							<!-- form-group end.// -->

							<!-- form-group end.// -->

							<!-- form-row end.// -->
							<%-- <div class="form-group">
								<label>Email address</label> <input type="email"
									class="form-control" name="email" value="${emailValue}" />
								<%=emailError == null ? "" : emailError%>
							</div> --%>
							<!-- form-group end.// -->


							<!-- form-group end.// -->


							<!-- form-row.// -->
							<div class="form-group">
								<button type="submit" class="btn btn-primary btn-block">
									Submit</button>
							</div>
							<!-- form-group// -->
						</form>
					</article>
					<!-- card-body end .// -->
					<div class="border-top card-body text-center">
						Have an account? <a href="Login.jsp">Log In</a>
					</div>
				</div>
				<!-- card.// -->
			</div>
			<!-- col.//-->
		</div>
		<!-- row.//-->
	</div>
</body>
</html>