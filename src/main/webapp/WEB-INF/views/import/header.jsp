<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
	<title><s:message code="home.company"/></title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
<style>
	.avata{
		width: 39px !important;
		height: 39px !important;
		border-radius: 37px !important;
		padding: 0;
	}
	#username{
		margin: auto;
		padding-right: 10px;
		color: black;
	}
	#lnkSearch{
		background: #24292e !important
	}
	.navbar-nav a[data-lang]{
		color: white !important;
	}
	.dropdown-item{
		color: black !important;
	}
	#logo{
		width: 50px;
		height: 50px;
		border-radius: 50%;
	}
	
	.dropdown-menu{
			background-color: #f9f9f9;
			border-radius: 10px !important;
        animation: fadeInAnimation ease .5s; 
        animation-iteration-count: 1; 
        animation-fill-mode: forwards; 
    } 
    @keyframes fadeInAnimation { 
        0% { 
            opacity: 0; 
        } 
        100% { 
            opacity: 1; 
        } 
    }
    
    .btn-secondary {
	    color: #292b2c !important;
	    background-color: #f9f9f9 !important;
	    background: #f9f9f9 !important;
	    border: none !important;
	}
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
				<a class="navbar-brand" href="${ rootName }/"><img id="logo" src="<c:url value="/lib/images/version/logo.png" />" alt=""></a>
				<div class="collapse navbar-collapse" id="navbarCollapse">
					<ul class="navbar-nav mr-4">
						  <input id="searchText" type="text" class="form-control" placeholder="<s:message code="title.searchPlace" />" aria-label="Recipient's username" aria-describedby="button-addon2">
							<a id="lnkSearch" class="btn" href="${ rootName }/home/?search=" role="button"><s:message code="title.search" /></a>
					</ul>
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
						<a style="height: 30px; margin-top: 7px; color: white" href="#" data-lang="en">English</a>
						<li style="height: 30px; margin-top: 7px" >/</li>
						<a style="height: 30px; margin-top: 7px; margin-right:5px; color: white" href="#" data-lang="vi">Viet Nam</a>
					</ul>
					
					<ul class="navbar-nav mr-2">
						<div class="btn-group">
							<c:if test="${ current_user == null }">
							  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							    <s:message code="title.login" />/<s:message code="title.signup" />
							  </button>
							  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
							    <a class="dropdown-item" href="${ rootName }/login"><s:message code="title.login" /></a>
							    <a class="dropdown-item" href="${ rootName }/sign-up/"><s:message code="title.signup" /></a>
							  </div>
						  </c:if>
							<c:if test="${ current_user != null }">
							<%-- <p id="username">${ current_user.fullName }</p> --%>
						    
								
							  <img src="<c:url value="${ current_user.image }" />" class="avata btn btn-secondary dropdown-toggle" data-toggle="dropdown" data-display="static" aria-haspopup="true" aria-expanded="false">
							  <div class="dropdown-menu dropdown-menu-right dropdown-menu-lg-left">
							  		<h6 class="dropdown-header" id="username">${ current_user.fullName }</h6>
							  		<div class="dropdown-divider"></div>
							  		<c:if test="${ current_user.roleName=='AUTHOR' }">
								  		<a class="dropdown-item" href="${ rootName }/author/dashboard"><s:message code="title.dashboard" /></a>							  		
							  		</c:if>
							  		<c:if test="${ current_user.roleName=='MANAGER' }">
								  		<a class="dropdown-item" href="${ rootName }/management/dashboard"><s:message code="title.dashboard" /></a>							  		
							  		</c:if>
								  <a class="dropdown-item" href="${ rootName }/edit-user/"><s:message code="title.editinfo" /></a>
								  <div class="dropdown-divider"></div>
								  <a class="dropdown-item" href="${ rootName }/logout/"><s:message code="title.logout" /></a>
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