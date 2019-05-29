<html>
<head>
<title>Login page</title>
<%@ include file="link.jsp"%>
<%@ include file="script.jsp"%>
<style>
body {
	/* The image used */
	background-image:
		url("${pageContext.request.contextPath}/images/bank-notes.jpg");
	/* Full height */
	height: 100%;
	/* Center and scale the image nicely */
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
}
</style>
<script type="text/javascript">
	window.setTimeout(function() {
		$("#logoutAlert").fadeTo(500, 0).slideUp(500, function() {
			$(this).remove();
		});
	}, 2000);
	
	window.setTimeout(function() {
		$("#invalidCredential").fadeTo(500, 0).slideUp(500, function() {
			$(this).remove();
		});
	}, 2000);
	
</script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark" style="padding-right: 0px;">
	<label class="navbar-brand">Expense Tracker</label>
	<div style="width: 100%">
	<img class="rounded float-right" src="${pageContext.request.contextPath}/images/logo.jpg" id="logo"  width="120" >
	</div>

</nav>

	<div
		class="d-flex justify-content-center align-items-center container ">
		<div class="container">
			<div class="row">
			<div class="col-4">
				</div>
				<div class="col-4 mx-auto">
					<div class="card card-signin my-5">
						<div class="card-body">
							<h3 class="card-title text-center mt-2 mb-5">Expense Tracker</h3>
							<div class="Absolute-Center is-Responsive">
								<c:if test="${param.error != null}">
									
									<div id="invalidCredential" class="alert alert-danger">
										<a id="linkClose" href="#" class="close">&times;</a> <strong>Incorrect Username or Password</strong>
									</div>
									
								</c:if>

								<c:if test="${param.logout != null}">
									<div id="logoutAlert" class="alert alert-success">
										<a id="linkClose" href="#" class="close">&times;</a> <strong>User is logged-out successfully.</strong>
									</div>
								</c:if>

								<c:url value="/login" var="login" />
								<form:form action="${pageContext.request.contextPath}/login" method="post">


									<div class="form-group">
										<div class="row">
											<div class="col-3">
												<label>Username:</label>
											</div>
											<div class="col-9">
												<input type="text" name="username" style="width:100%">
											</div>
										</div>


									</div>
									<div class="form-group">


										<div class="row">
											<div class="col-3">
												<label>Password:</label>
											</div>
											<div class="col-9">
												<input type="password" name="password" style="width:100%">
											</div>
										</div>


									</div>
									<div class="row">
										<div class="col-6 justify-content-center">

											<input type="submit" name="submit"
												class="btn btn-primary btn-md btn-block" value="Login" />

										</div>
										<div class="col-6 justify-content-center">

											<!-- <input type="submit" name="submit"
											class="btn btn-success btn-lg" value="Register" /> -->
											<a class="btn btn-secondary btn-md btn-block"
												href="${pageContext.request.contextPath}/add-user">Register</a>

										</div>
									</div>


								</form:form>
							</div>
						</div>
					</div>
				</div>
				<div class="col-4">
				</div>
			</div>
		</div>
	</div>
	<%@ include file="footer.html"%>
</body>
</html>