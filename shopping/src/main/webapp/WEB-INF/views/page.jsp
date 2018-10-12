<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath }"></c:set>
<spring:url var="js" value="/resources/js" />
<spring:url var="css" value="/resources/css" />
<spring:url var="images" value="/resources/images" />

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Welcome to ${title}</title>
<script>
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}';
</script>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap core CSS -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

<!-- Bootstrap readable CSS -->
<%-- <link href="${css}/bootstrap-readable-theme.css" rel="stylesheet"> --%>

<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>
	<div class="wrapper">
		<!-- Navigation -->
		<%@include file="./shared/navbar.jsp"%>
		<div class="content">
			<!-- Page Content -->
			<c:if test="${userClickHome == true}">
				<%@include file="home.jsp"%>
			</c:if>

			<c:if test="${userClickAbout == true}">

				<%@include file="about.jsp"%>
			</c:if>

			<c:if test="${userClickContact == true}">
				<%@include file="contact.jsp"%>
			</c:if>
			
			<c:if test="${userClickAllProducts == true or userClickCategoryProducts == true}">
				<%@include file="listProducts.jsp"%>
			</c:if>
			<!-- Page Content END-->
		</div>
		<%@include file="./shared/footer.jsp"%>
		
		<!-- Jquery plugin -->
		<script src="${js}/jquery.js"></script>
		
		<!-- Bootstrap core JS -->
		<script src="${js}/bootstrap.min.js"></script>
		
		<!-- jQuery Data Table Js -->
		<script src="${js}/jquery.dataTables.js"></script>

		<!-- jQuery Data Table Js -->
		<script src="${js}/dataTables.bootstrap.js"></script>
		
		<!--  -->
		<script src="${js}/myJS/myapp.js"></script>
	</div>
</body>

</html>
