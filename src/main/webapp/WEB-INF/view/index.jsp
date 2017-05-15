<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<%-- Bootstrap css --%>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
		crossorigin="anonymous">
<link rel="stylesheet" href="./static/styles/styles.css">
<title>Home</title>
</head>

<body>
	<div class="container">
		<jsp:include page="./header.jspf" />

		<spring:form action="${pageContext.request.contextPath}/calculator" method="post" modelAttribute="calculator">

			<div class="form-group">
				<label for="firstNumber">First Number</label> 
				<spring:input id="firstNumber" path="firstNumber" type="text" 
								cssClass="form-control"/>
			</div>

			<div class="form-group">

				<label for="operation">Operation</label> 
				<spring:select cssClass="form-control" id="operation" path="operation">
					<option value="plus">+</option>
					<option value="minus">-</option>
					<option value="multiply">*</option>
					<option value="divide">/</option>
				</spring:select>
			</div>

			<div class="form-group">
				<label for="secondNumber">Second Number</label> 
				<spring:input id="secondNumber" path="secondNumber" type="text" cssClass="form-control"/>
			</div>

			<input type="submit" class="btn btn-default" value="Submit">
		</spring:form>

		<%--Check if result is null and display the data in case it is not--%>
		<c:if test="${result != null}">
			<h3>${result}</h3>
		</c:if>

		<jsp:include page="./footer.jspf" />
	</div>

	<%-- Load JS libraries --%>
	<script src="https://code.jquery.com/jquery-3.2.1.js"
		integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE="
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.js"></script>
</body>
</html>