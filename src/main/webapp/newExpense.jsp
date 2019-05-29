<html>
<head>
<%@ include file="header.jsp"%>
<%@ include file="link.jsp"%>
<%@ include file="script.jsp"%>
<title>Add new Expense</title>

<style>

body { 
	background-color:#dcddd3
}

.required {
  color: red;
}
</style>

 <script type = "text/javascript">
 function validate()
 {
	 var date = document.getElementById("date");
	 var expenseHead = document.getElementById("expenseHead");
	 var amount = document.getElementById("amount");
	 
	 if(date.value == ""|| expenseHead.value ==""|| amount.value=="")
	 	{
		 alert("Please enter mandatory fields");
		 return false;
		}
	
	var dateValue = new Date($('#date').val());
	 
	console.log("Year: ", dateValue.getFullYear());
	
	if(dateValue.getFullYear() > 9999){
		{
			alert("Please enter year less than 9999");
			return false;
		}
	}
 }
 
</script>

</head>
<body>
	<div
		class="d-flex justify-content-center align-items-center container ">
		<div class="container">
			<div class="row">
				<div class="col-4">
				</div>
				<div class="col-4 mx-auto">
					<div class="card card-signin my-5">
						<div class="card-body">
							<h3 class="card-title text-center">
								<c:if test="${not empty Expense.id}">Edit Expense</c:if> 
								<c:if test="${empty Expense.id}">New Expense</c:if>
							</h3>
							<div class="Absolute-Center is-Responsive">
							
							<c:if test="${not empty SuccessText}">
								<h5 class="text-center alert alert-success">${SuccessText}</h5>
							</c:if>
							
				
								<form:form class="form-horizontal" method="post" onsubmit="return validate()" 
									modelAttribute="Expense" id="submitForm"
									action="${pageContext.request.contextPath}/submit-form">

									<div class="row my-3">
										<div class="col-3 field-label-responsive">
											<label for="date">Date<span class="required">*</span></label>
										</div>
										<div class="col-9">
											<div>
												<form:input type="date" id= "date" path="date" value="${Expense.date}"  style="width:100%"/>
											</div>
										</div>
									</div>

									<div class="row my-3">
										<div class="col-3 field-label-responsive">
											<label for="expenseHead">Head<span class="required">*</span></label>
										</div>
										<div class="col-9">
											<div>

												<form:select class="form-control" path="expenseHead" id= "expenseHead"
													value="${Expense.expenseHead}" style="width:100%">
													<form:option value="Taxi" label="Taxi" />
													<form:option value="Meal" label="Meal" />
													<form:option value="Travel" label="Travel" />
													<form:option value="Stationary" label="Stationary" />
												</form:select>

											</div>
										</div>
									</div>

									<div class="row my-3">
										<div class="col-3 field-label-responsive">
											<label for="amount">Amount<span class="required">*</span></label>
										</div>
										<div class="col-9">
											<div>
												<form:input type="number" path="amount" id="amount" min="1" max="100000" step="any" style="width:100%"
													value="${Expense.amount}" />
											</div>
										</div>
									</div>

									<div class="row my-3">
										<div class="col-3 field-label-responsive">
											<label for="name">Currency:</label>
										</div>
										<div class="col-9">
											<div>
												<form:select class="form-control" path="currency"
													value="${Expense.currency}" style="width:100%">
													<!-- <option value="INR">INR</option>
													<option value="USD">USD</option>
													<option value="YEN">YEN</option>
													<option value="EURO">EURO</option> -->
													<form:option value="INR" label="INR" />
													<form:option value="USD" label="USD" />
													<form:option value="YEN" label="YEN" />
													<form:option value="EUR" label="EUR" />
												</form:select>
											</div>
										</div>
									</div>




									<div class="row my-3">
										<div class="col-3"></div>
										<div class="col-9">
											<form:input type="hidden" path="userId"
												value="${Expense.userId}" />
											<form:input type="hidden" path="id" value="${Expense.id}" />
											<button type="submit" class="btn btn-primary btn-block">Save</button>
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