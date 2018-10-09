<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="base">${pageContext.request.requestURL}</c:set>
<c:set var="url"
	value="${fn:replace(base, pageContext.request.requestURI, pageContext.request.contextPath)}" />
<!-- <link rel="stylesheet" href="../bootstrap/css/bootstrap-grid.min.css">
<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
<script type="text/javascript"
	src="../bootstrap/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="../bootstrap/js/jquery-3.2.1.slim.min.js"></script>
<script type="text/javascript" src="../bootstrap/js/popper.min.js"></script> -->

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>


<nav class="navbar navbar-expand-sm bg-dark navbar-dark ">
	<!-- Brand -->
	<a class="navbar-brand " href="#">Logo</a>

	<!-- Links -->
	<ul class="navbar-nav">
		<!--   <li class="nav-item">
      <a class="nav-link" href="#">Link 1</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">Link 2</a>
    </li> -->

		<!-- Dropdown -->
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="navbardrop" data-toggle="dropdown"> Seller </a>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="${url}/seller/register">Register Seller</a> <a
					class="dropdown-item" href="${url}/seller/all">View All</a> 
			</div></li>


		<!-- Order Method -->
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="navbardrop" data-toggle="dropdown"> Product </a>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="${url}/product/register">Register Product
				</a> <a class="dropdown-item" href="${url}/product/all">View All</a>
			</div></li>

		<!-- Shipment Type -->
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="navbardrop" data-toggle="dropdown"> Buyer </a>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="${url}/buyer/register">Register
				</a> <a class="dropdown-item" href="${url}/buyer/all">View
					All</a> 
			</div></li>


		<!-- WH USER TYPE -->

		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="navbardrop" data-toggle="dropdown"> Order </a>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="${url}/order/register">Register
				</a> <a class="dropdown-item" href="${url}/order/all">View All</a>
			</div></li>

		<!-- ITEM  -->
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="navbardrop" data-toggle="dropdown">OrderItem</a>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="${url}/orderItem/register">Register </a> <a
					class="dropdown-item" href="${url}/orderItem/all">View All</a> 
			</div></li>
		<!-- SWAGGER -->
		<li class="nav-item"><a class="nav-link"
			href="${url}/swagger-ui.html">Swagger</a></li>

	</ul>
</nav>