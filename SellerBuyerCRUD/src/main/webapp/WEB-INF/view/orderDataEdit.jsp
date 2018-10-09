<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="../bootstrap/css/bootstrap-grid.min.css">
<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">

<script type="text/javascript"
	src="../bootstrap/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="../bootstrap/js/jquery-3.2.1.slim.min.js"></script>
<script type="text/javascript" src="../bootstrap/js/popper.min.js"></script>
<script type="text/javascript" src="../bootstrap/js/clientValidation/orderFormValidation.js"></script>

<style type="text/css">
  .col-custom-1 {
    -webkit-box-flex: 0;
    -ms-flex: 0 0 8.333333%;
    flex: 0 0 8.333333%;
    max-width: 8.333333%;
  }
    .col-custom-2 {
    -webkit-box-flex: 0;
    -ms-flex: 0 0 16.666667%;
    flex: 0 0 16.666667%;
    max-width: 8.666667%;
  }
  </style>


<title>Product Edit Page</title>
</head>
<body>
<%@include file="Menu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header bg-primary text-white">
				<h2>WELCOME TO Order  EDIT PAGE</h2>
			</div>
			<!-- CARD HEAD END -->
			<div class="card-body">
				<form:form action="update" method="post" modelAttribute="order" id="orderRegisterForm" name="orderRegisterForm" onsubmit="return orderRegisterFormValidation();">
				
					<div class="form-group">
						<label for="id" class="control-label col-sm-2">ID</label>
						 <form:input path="id" cssClass="form-control col-sm-4" readonly="true" />
					</div>
					
				  <div class="form-group">	
			       <label for="buyer" class="control-label col-sm-4"><b>Buyer</b></label>	
             		<form:select path="buyer" cssClass="form-control col-sm-4">
         					<form:option value="">--Select--</form:option>
         				 	<form:options items="${buyerList}" itemLabel="firstName" itemValue="id"/>
         		   	</form:select>
         		   	<form:errors path="buyer" cssClass="text-danger"/> 		 
         		   </div>
         		 		
					<input type="submit" value="Update Order" class="btn btn-success" />
					
				</form:form>
			</div>
			
		</div>
		<!-- Card End -->
	</div>
	<!--Container End-->
</body>
</html>