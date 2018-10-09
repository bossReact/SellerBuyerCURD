<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="../bootstrap/css/bootstrap-grid.min.css">
<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
<script type="text/javascript"
	src="../bootstrap/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="../bootstrap/js/jquery-3.2.1.slim.min.js"></script>
	<script type="text/javascript" src="../bootstrap/js/clientValidation/buyerFormValidation.js"></script>
<script type="text/javascript" src="../bootstrap/popper.min.js"></script>
<title>Uom Data Edit</title>
</head>
<body>
<%@include file="Menu.jsp" %>
	<div class="container">
		<div class="card">
			<div class="card-header bg-primary text-white">
				<h2>WELCOME TO Buyer EDIT PAGE</h2>
			</div>
			<!-- CARD HEAD END -->
			<div class="card-body">
				<form:form action="update" id="buyerRegister" name="buyerRegister" onsubmit="return buyerRegisterFormValidation();" method="post" modelAttribute="buyer">

					<div class="form-group">
						<label for="id" class="control-label  col-sm-4">BUYER ID</label>
						<form:input path="id" readonly="true" cssClass="form-control col-sm-4" />
						<form:errors path="id" cssClass="text-danger" />
					</div>

					<div class="form-group">
						<label for="firstName" class="control-label  col-sm-4">FIRSTNAME</label>
						<form:input path="firstName" cssClass="form-control col-sm-4" />
						<form:errors path="firstName" cssClass="text-danger" />
					</div>
					
					<div class="form-group">
						<label for="lastName" class="control-label  col-sm-4">LASTNAME</label>
						<form:input path="lastName" cssClass="form-control col-sm-4" />
						<form:errors path="lastName" cssClass="text-danger" />
					</div>

					<input type="submit" value="Update Buyer" class="btn btn-success" />

				</form:form>
			</div>
			<!-- CARD BODY END -->
		</div>
		<div>
			<c:if test="${null!=message}">
				<div class="card-footer bg-success text-white">
					<b>${message}</b>
				</div>
				<!--CARD FOOTER END -->
			</c:if>
		</div>
		<!--CARD END -->
	</div>
	<!-- CONTAINER END -->
</body>
</html>