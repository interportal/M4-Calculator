<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>SignUp Page</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<link rel="stylesheet" href="./../static/styles/styles.css">
</head>
<body>
	<div class="container">
		<h3 class="well">Registration</h1>
		<div class="col-lg-12 well">
			<div class="row">
				<spring:form action="${pageContext.request.contextPath}/app/signup" method="post" modelAttribute="user">
					
					<spring:errors path="*" element="div" cssClass="alert alert-danger"/>
					
					<div class="col-sm-12">
						<div class="row">
							<div class="col-sm-6 form-group">
								<label>First Name</label> 
								<spring:input type="text" path = "firstName"
									placeholder="Enter First Name Here.." class="form-control"/>
								<spring:errors path="firstName" cssClass="alert alert-danger" element="div"/>
							</div>
							<div class="col-sm-6 form-group">
								<label>Last Name</label> 
								<spring:input type="text" path="lastName"
									placeholder="Enter Last Name Here.." class="form-control"/>
								<spring:errors path="lastName" cssClass="alert alert-danger" element="div"/>
							</div>
						</div>
						
						<div class="form-group">
							<label>Email Address</label> 
							<spring:input type="text" path="email"
								placeholder="Enter Email Address Here.." class="form-control"/>
						</div>
						
						<div class="form-group">
							<label>Password</label> 
							<spring:input type="password" path="password"
								placeholder="Enter Password Here.." class="form-control"/>
						</div>
						
						<div class="form-group">
							<label>Age</label> 
							<spring:input type="text" path="age"
								placeholder="Enter Age Here.." class="form-control"/>
						</div>

						<div class="form-group">
							<label>Phone Number</label> 
							<spring:input type="text" path="phone"
								placeholder="Enter Phone Number Here.." class="form-control"/>
						</div>
						
						<button type="submit" class="btn btn-lg btn-info">Submit</button>
					</div>
				</spring:form>
			</div>
		</div>
	</div>


	<%-- Load JS libraries --%>
	<script src="https://code.jquery.com/jquery-3.2.1.js"
		integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE="
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.js"></script>
</body>
</html>