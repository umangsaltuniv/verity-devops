
<nav class="navbar navbar-expand-lg navbar-dark bg-dark" style="padding-right: 0px;">
	<label class="navbar-brand">Expense Tracker</label>


	<div class="collapse navbar-collapse" id="main-navbar">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/new-expense">Add
					Expense</a></li>
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/expense-list">Expense
					List</a></li>

		</ul>
		<form class="form-inline my-2 my-lg-0"
			action="${pageContext.request.contextPath}/appLogout" method="POST">
			<span style="color: white;" class="mx-2"> <i
				class="fas fa-user"></i></span> <label class="mx-2" style="color: white;">${user.name}</label>

			<button id="btnDelete" class="btn btn-danger" onclick="return confirm('Confirm! Do you want to logout?')">
				<span
					style="color: white;"><i class="fa fa-sign-out-alt"></i>
					Logout</span>
			</button>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
		<div style="width:10pt">
		</div>
		<!-- <img class="rounded float-right" src="/images/logo.jpg" id="logo"  width="100" > -->
	</div>
	<img class="rounded float-right" src="${pageContext.request.contextPath}/images/logo.jpg" id="logo"  width="120" >
</nav>
