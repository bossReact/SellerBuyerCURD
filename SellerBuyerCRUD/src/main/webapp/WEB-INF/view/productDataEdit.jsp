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
<script type="text/javascript" src="../bootstrap/js/clientValidation/productFormValidation.js"></script>

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
				<h2>WELCOME TO Product  EDIT PAGE</h2>
			</div>
			<!-- CARD HEAD END -->
			<div class="card-body">
				<form:form action="update" method="post" modelAttribute="product" d="productRegister" name="productRegister" onsubmit="return productRegisterFormValidation();">
				
					<div class="form-group">
						<label for="id" class="control-label col-sm-2">ID</label>
						 <form:input path="id" cssClass="form-control col-sm-4" readonly="true" />
					</div>
					
					
					<div class="form-group">
  					 <label for="name" class="control-label col-sm-2"><b>Product Name</b></label>
   					 <form:input path="name" cssClass="form-control col-sm-4"/>
   					 <form:errors path="name" cssClass="text-danger"/>
				   	</div>
         		   <div class="form-group">
  					 <label for="price" class="control-label col-sm-4"><b>Price</b></label>
   					 <form:textarea path="price" cssClass="form-control col-sm-4"/>
   					 <form:errors path="price" cssClass="text-danger"/>
				   </div>
				
         		   <div class="form-group">	
			       <label for="seller" class="control-label col-sm-4"><b>Seller Product</b></label>	
             		<form:select path="seller" cssClass="form-control col-sm-4">
         					<form:option value="">--Select--</form:option>
         				 	<form:options items="${sellerList}" itemLabel="name" itemValue="id"/>
         		   	</form:select>
         		   	<form:errors path="seller" cssClass="text-danger"/> 		 
         		   </div>
         		   
         		   <div class="form-group">
  					 <label for="desc" class="control-label col-sm-4"><b>Description</b></label>
   					 <form:textarea path="desc" cssClass="form-control col-sm-4"/>
   					 <form:errors path="desc" cssClass="text-danger"/>
				   </div>
				
					<input type="submit" value="Update Item" class="btn btn-success" />
					
				</form:form>
			</div>
			
		</div>
		<!-- Card End -->
	</div>
	<!--Container End-->
</body>
</html>