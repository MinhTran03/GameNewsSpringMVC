<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<body>
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
								<li class="nav-item"><a class="nav-link" href="${ rootName }/${ list.name.toLowerCase().replace(' ', '-') }">
									${ list.name }</a>
								</li>
								
							</c:forEach>
						</c:if>
					</ul>
					<ul class="navbar-nav mr-2">
						<li class="nav-item"><a class="nav-link" href="#"><i
								class="fa fa-rss"></i></a></li>
						<li class="nav-item"><a class="nav-link" href="#"><i
								class="fa fa-android"></i></a></li>
						<li class="nav-item"><a class="nav-link" href="#"><i
								class="fa fa-apple"></i></a></li>
					</ul>
				</div>
			</nav>
		</div>
		<!-- end container-fluid -->
	</header>
	<!-- end market-header -->
</body>
</html>