<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<body>
<style>
	.avata{
		width: 42px !important;
		height:42px !important;
		border-radius: 50%;
		padding: 0;
	}
	/* .navbar{
		padding: 0rem 15rem !important;
	} */
	
</style>

	<c:set var="rootName" value="${ pageContext.request.contextPath }" />
	<header class="tech-header header">
		<div class="container-fluid">
			<nav
				class="navbar navbar-toggleable-md navbar-inverse fixed-top bg-inverse">
				<button class="navbar-toggler navbar-toggler-right" type="button"
					data-toggle="collapse" data-target="#navbarCollapse"
					aria-controls="navbarCollapse" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<a class="navbar-brand" href="${ rootName }/"><img src="<c:url value="/lib/images/version/tech-logo.png" />" alt=""></a>
				<div class="collapse navbar-collapse" id="navbarCollapse">
					
					<ul class="navbar-nav mr-auto">
						<c:if test="${not empty listTopic}">
							<c:forEach var="list" items="${ listTopic }">
								<li class="nav-item"><a class="nav-link" href="${ rootName }/topic/${ list.name.toLowerCase().replace(' ', '-') }">
									${ list.name }</a>
								</li>
								
							</c:forEach>
						</c:if>
					</ul>
					<ul class="navbar-nav mr-4">
						<input id="searchText" style="height: 30px; margin-top: 7px" type="text" placeholder="Search..">
						<button style="height: 30px; margin-top: 7px" id="search"><a id="lnkSearch" href="${ rootName }/home/?search=">Search</a></button>
					</ul>
					<ul class="navbar-nav mr-2">
						<div class="btn-group">
							<c:if test="${ loggingIn == false}">
							  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							    Login/SignUp
							  </button>
							  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
							    <a class="dropdown-item" href="${ rootName }/login">Login</a>
							    <a class="dropdown-item" href="${ rootName }/sign-up/">SignUp</a>
							  </div>
						  </c:if>
							<c:if test="${ loggingIn == true}">
							  <img src="<c:url value="${ avataUser }" />" class="avata btn btn-secondary dropdown-toggle" data-toggle="dropdown" data-display="static" aria-haspopup="true" aria-expanded="false">
							  <div class="dropdown-menu dropdown-menu-right dropdown-menu-lg-left">
							  		<c:if test="${ role=='AUTHOR' }">
								  		<a class="dropdown-item" href="${ rootName }/author/dashboard">Dashboard</a>							  		
							  		</c:if>
							  		<c:if test="${ role=='MANAGER' }">
								  		<a class="dropdown-item" href="${ rootName }/management/duyet-bai">Dashboard</a>							  		
							  		</c:if>
								  <a class="dropdown-item" href="${ rootName }/edit-user/">Edit Info</a>
								  <div class="dropdown-divider"></div>
								  <a class="dropdown-item" href="${ rootName }/logout/">Logout</a>
							  </div>
						  </c:if>
						</div>
					</ul>
				</div>
			</nav>
		</div>
		<!-- end container-fluid -->
	</header>
	<!-- end market-header -->
</body>
<script src="<c:url value="/lib/js/header.js" />"></script>
</html>