<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<%@ include file="link.jsp"%>
<%@ include file="script.jsp"%>
<title>Home page</title>
<style>

body { 
  /* The image used */
  background-image: url("${pageContext.request.contextPath}/images/business-bills.jpg");

  /* Full height */
  height: 100%; 

  /* Center and scale the image nicely */
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
}
</style>
</head>
<body>
	<%@ include file="header.jsp"%>
	<%@ include file="footer.html"%>
</body>
</html>