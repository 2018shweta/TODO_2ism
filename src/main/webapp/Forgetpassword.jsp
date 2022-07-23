<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forgetpassword page</title>

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
	<%
	String queansError = (String) request.getAttribute("queansError");

	String queansValue = (String) request.getAttribute("queansValue");
	String gmailError = (String) request.getAttribute("gmaiError");
	String gmailValue = (String) request.getAttribute("gmailValue");
	String duplicatError = (String) request.getAttribute("duplicatError");
	%>

	<div class="container">

		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="card">
					<header class="card-header">
						<a href="Login.jsp"
							class="float-right btn btn-outline-primary mt-1">Login</a>
						<h4 class="card-title mt-2">Forgotpassword</h4>
					</header>
					<article class="card-body">
						<form method="post" action="ForgetpasswordController">
							<div class="form-row">

								<!-- form-group end.// -->

							</div>
							<!-- form-row end.// -->
							<div class="form-group">
								<label>Enter your gmail</label> <input type="email" name="gmail"
									placeholder="value" class="form-control value=" ${gmailValue}"/>
								<%=gmailError == null ? "" : gmailError%>
							</div>


							<div class="form-group">
								<label>Enter your goal in life</label> <input type="queans"
									name="queans" placeholder="value" class="form-control value=" ${queansValue}"/>
								<%=queansError == null ? "" : queansError%>
							</div>

							<!-- form-group end.// -->




							<!-- form-group end.// -->
				</div>
				<!-- form-row.// -->
				<div class="form-group">
					<button type="submit" class="btn btn-primary btn-block">
						Submit</button><%=duplicatError == null ? "" : duplicatError%>
				</div>

				<!-- form-group// -->
				</form>
				</article>
				<!-- card-body end .// -->

			</div>
			<!-- card.// -->
		</div>
		<!-- col.//-->
	</div>
	<!-- row.//-->
	</div>
</body>
</html>