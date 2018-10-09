	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
<script type="text/javascript" src="../bootstrap/popper.min.js"></script>
<script type="text/javascript" src="../bootstrap/js/clientValidation/orderItemFormValidation.js"></script>

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

<title>ORDER ITEM REGISTER</title>
</head>
<body>
	<%@include file="Menu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header bg-primary text-white">
				<h2>WELCOME TO ORDER iTEM REGISTER PAGE</h2>
			</div>
			<!-- CARD HEAD END -->
				<div class="card-body">
				<form:form action="register" method="post" modelAttribute="orderItem" name="orderItemForm" id="orderItemForm" onsubmit="return orderItemRegisterFormValidation();">
	
				<div class="form-group">
  					 <label for="quantity" class="control-label col-sm-2"><b>ORDER ITEM QUANTITY</b></label>
   					 <form:input path="quantity" cssClass="form-control col-sm-4"/>
   					 <form:errors path="quantity" cssClass="text-danger"/>
				   </div>
				     		   
         		   <div class="form-group">	
			       <label for="order" class="control-label col-sm-4"><b>Order Buyer Name</b></label>	
             		<form:select path="order" cssClass="form-control col-sm-4">
         					<form:option value="">--Select--</form:option>
         				 	<form:options items="${orderList}" itemLabel="buyer.firstName" itemValue="id"/>
         		   	</form:select>
         		   	<form:errors path="order" cssClass="text-danger"/> 		 
         		   </div>
					
					 <div class="form-group">	
			       <label for="product" class="control-label col-sm-4"><b>Order Product Name</b></label>	
             		<form:select path="product" cssClass="form-control col-sm-4">
         					<form:option value="">--Select--</form:option>
         				 	<form:options items="${productList}" itemLabel="name" itemValue="id"/>
         		   	</form:select>
         		   	<form:errors path="product" cssClass="text-danger"/> 		 
         		   </div>
					
         		   
         		
						<input type="submit" value="Create OrderItem" class="btn btn-success"/>
                    	<a href="register"  class="btn btn-info">Refresh</a>
				</form:form>
			</div>
			<!-- CARD BODY END -->
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