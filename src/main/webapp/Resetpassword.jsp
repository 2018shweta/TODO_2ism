<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resetpassword page</title>

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
	String newpasswordError = (String) request.getAttribute("newpasswordError");
	String confirmpasswordValue = (String) request.getAttribute("confirmpasswordValue");
	String newpasswordValue = (String) request.getAttribute("newpasswordValue");
	String confirmpasswordError = (String) request.getAttribute("confirmpasswordError");
	%>


	<div class="container">

		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="card">
					<header class="card-header">
						<a href="Login.jsp"
							class="float-right btn btn-outline-primary mt-1">Login</a>
						<h4 class="card-title mt-2">Resetpassword</h4>
					</header>
					<article class="card-body">
						<form method="post" action="ResetpasswordController">
							<div class="form-row">

								<!-- form-group end.// -->

							</div>
							<!-- form-row end.// -->



							<div class="form-group">
								<label>New Password</label> <input type="password"
									name="newpassword" placeholder="value" class="form-control"
									value="${newpasswordValue}" />
								<%=newpasswordError == null ? "" : newpasswordError%>
							</div>


							<div class="form-group">
								<label>Confirm Passowrd</label> <input type="password"
									name="confirmpassword" placeholder="value" class="form-control"
									value="${confirmpasswordValue}" />
								<%=confirmpasswordError == null ? "" : confirmpasswordError%>
							</div>






							<!-- form-group end.// -->




							<!-- form-group end.// -->
				</div>
				<!-- form-row.// -->
				<div class="form-group">
					<button type="submit" class="btn btn-primary btn-block">
						Submit</button>
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