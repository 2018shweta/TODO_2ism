
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup page</title>

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style type="text/css">
p {
	color: red;
}
</style>
</head>
<body>
	<%
	String emailError = (String) request.getAttribute("emailError");
	String emailValue = (String) request.getAttribute("emailValue");
	String passwordError = (String) request.getAttribute("passwordError");
	String passwordValue = (String) request.getAttribute("passwordValue");
	String genderError = (String) request.getAttribute("genderError");
	String genderValue = (String) request.getAttribute("genderValue");
	String queansError = (String) request.getAttribute("queansError");
	String queansValue = (String) request.getAttribute("queansValue");
	%>



	<div class="container">

		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="card">
					<header class="card-header">
						<a href="Login.jsp"
							class="float-right btn btn-outline-primary mt-1">Login</a>
						<h4 class="card-title mt-2">Sign up</h4>
					</header>
					<article class="card-body">
						<form method="post" action="SignUpController">
							<div class="form-row">
								<div class="col form-group">
									<label>First name </label> <input type="text" name="firstName"
										class="form-control" />
									<p>${firstNameError}</p>
								</div>
								<!-- form-group end.// -->
								<div class="col form-group">
									<label>Last name</label> <input type="text" name="lastName"
										value="${lastNameValue}" class="form-control" />
									<p>${lastNameError}</p>
								</div>
								<!-- form-group end.// -->
							</div>
							<!-- form-row end.// -->
							<div class="form-group">
								<label>Email address</label> <input type="email"
									class="form-control " name="email" value="${emailValue}" />
								<p>${dGmail }</p>
								<p>${emailError }</p>

							</div>
							<!-- form-group end.// -->
							<div class="form-group">
								<label>Create password</label> <input type="password"
									name="password" class="form-control value=" ${passwordValue}"/>
								<p>${passwordError}</p>
							</div>

							<div class="form-group">
								<label>Enter your goal in life</label> <input type="queans"
									name="queans" class="form-control value=" ${queansValue}"/>
								<p>${queansError}</p>
							</div>

							<!-- form-group end.// -->

							<div class="form-group">
								<label class="form-check form-check-inline">Gender: <input
									class="form-check-input" type="radio" name="gender"
									value="male"
									<%=genderValue != null && genderValue.equals("male") ? "checked" : ""%> />
									<span class="form-check-label"> Male </span>
								</label> <label class="form-check form-check-inline"> <input
									class="form-check-input" type="radio" name="gender"
									value="female"
									<%=genderValue != null && genderValue.equals("female") ? "checked" : ""%> />
									<span class="form-check-label"> Female </span> <br> <span
									class="error"><br> </span>
							</div>
							<p>${genderError}</p>


							</label>


							<!-- form-group end.// -->
				</div>
				<!-- form-row.// -->
				<div class="form-group">
					<button type="submit" class="btn btn-primary btn-block">
						Register</button>
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
	<!--container end.//-->
</body>
</html>